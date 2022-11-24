package com.beyonmdcp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beyonmdcp.dto.UserDto;
import com.beyonmdcp.model.Customer;
import com.beyonmdcp.model.Driver;
import com.beyonmdcp.model.Token;
import com.beyonmdcp.model.User;
import com.beyonmdcp.model.Vechicle;
import com.beyonmdcp.repo.CustomerRepo;
import com.beyonmdcp.repo.DriverRepo;
import com.beyonmdcp.repo.TokenRepo;
import com.beyonmdcp.repo.UserRepo;
import com.beyonmdcp.repo.VechicleRepo;
import com.beyonmdcp.util.MDCPResponse;

@Service
public class UserService {
	@Autowired
	private VechicleRepo vechicleRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private DriverRepo driverRepo;

	@Autowired
	private TokenRepo tokenRepo;

	public MDCPResponse<String> adduser(UserDto userDto , String token)
	{
		MDCPResponse<String> response=new MDCPResponse<>();
		if(validateUserInfo(userDto,response)) {
		String message = "";
		
		Token tokendata = tokenRepo.findByToken(token);
	 if(tokendata == null)
	{
			if (userDto != null) {
				Customer customerdata = customerRepo.findBycustomerId(userDto.getCustomerId());
				if (customerdata != null) {
				User userdata = userRepo.findByUserName(userDto.getUserName());
				if(userdata==null) {
					User user = new User();
					Driver driver = new Driver();
					Vechicle vechicle = new Vechicle();
				
					user.setFirstName(userDto.getFirstName());
					user.setLastName(userDto.getLastName());
					user.setPassword(userDto.getPassword());
					user.setEmail(userDto.getEmail());
					user.setMobile(userDto.getMobile());
					user.setCity(userDto.getCity());
					user.setState(userDto.getState());
					user.setDob(userDto.getDob());
					user.setCountry(userDto.getCountry());
					user.setAddress(userDto.getAddress());
					user.setStatus(userDto.getStatus());
					user.setCreatedAt(new Date());
					user.setCreatedBy(userDto.getCustomerId());
					user.setUpdatedAt(new Date());
					user.setUpdatedBy(userDto.getCustomerId());
					user.setDeletedAt(new Date());
					user.setDeletedBy(userDto.getCustomerId());
					user.setCustomer(customerdata);
					User userdat = userRepo.save(user);
                     
				
					vechicle.setVechicleNo(userDto.getVechicleDto().getVechicleNo());
					vechicle.setEngineNo(userDto.getVechicleDto().getEngineNo());
					vechicle.setChasisNo(userDto.getVechicleDto().getChasisNo());
					vechicle.setModel(userDto.getVechicleDto().getModel());
					vechicle.setBrand(userDto.getVechicleDto().getBrand());
					vechicle.setType(userDto.getVechicleDto().getType());
					vechicle.setUser(userdata);
					Vechicle vechicledata = vechicleRepo.save(vechicle);

					driver.setDfirstName(userDto.getDriverDto().getDlastName());
					driver.setDlastName(userDto.getDriverDto().getDlastName());
					driver.setLicenseNo(userDto.getDriverDto().getLicenseNo());
					driver.setDob(userDto.getDriverDto().getDob());
					driver.setCity(userDto.getDriverDto().getCity());
					driver.setState(userDto.getDriverDto().getState());
					driver.setCountry(userDto.getDriverDto().getCountry());
					driver.setAddress(userDto.getDriverDto().getAddress());
					driver.setUser(userdata);
					driverRepo.save(driver);

					message = "user register data successfully";
				} else {
					message = "userName already exists";
				}
			} else {
				message = "customer not found";
			}
	} else {
			message = "user Not Found";
		}
	}
	 else
	 {
		 message="unathorized token";
	 }
		}
		return response;
	}
	private boolean validateUserInfo(UserDto userDto, MDCPResponse response) {
		boolean status=true;
		if(userDto.getCustomerId()==null) {
			status=false;
			response.setCode(700);
			response.setMessage("please enter customerId and try again");
		return status;
		}
		if(userDto.getCountry()!=null && userDto.getCountry().equals("IND"))
		{
			status=false;
			response.setCode(700);
			response.setMessage("pls enter valid country name");
			return status;
		}
		if(userDto.getDob()!=null && userDto.getDob().length()>11)
		{
	        status=false;
	        response.setCode(700);
	        response.setMessage("dob length is maximum reached");
	        return status;
		}
		return status;
		}
}