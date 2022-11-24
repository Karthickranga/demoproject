package com.beyonmdcp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.beyonmdcp.dto.DriverDto;
import com.beyonmdcp.dto.UserDto;
import com.beyonmdcp.dto.VechicleDto;
import com.beyonmdcp.model.User;
import com.beyonmdcp.repo.DriverRepo;
import com.beyonmdcp.repo.UserRepo;
import com.beyonmdcp.repo.VechicleRepo;
import com.beyonmdcp.util.MDCPResponse;

@Service
public class UserDetails {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private VechicleRepo vechicleRepo;
	
	@Autowired
	private DriverRepo driverRepo;
	

	 public MDCPResponse<UserDto> getbyuserDetails(Integer userId) {
		 MDCPResponse<UserDto> response=new MDCPResponse<>();
		UserDto userDto=new UserDto();
		VechicleDto vechicleDto=new VechicleDto();
		DriverDto driverDto=new DriverDto();
		User Id = userRepo.getReferenceById(userId);
		if(Id!=null)
		{
			userDto.setFirstName(Id.getFirstName());
			userDto.setLastName(Id.getLastName());
			userDto.setUserName(Id.getUserName());        
			userDto.setPassword(Id.getPassword());
			userDto.setEmail(Id.getEmail());
			userDto.setMobile(Id.getMobile());
			userDto.setCity(Id.getCity());  
			userDto.setState(Id.getState());
			userDto.setDob(Id.getDob());
			userDto.setCountry(Id.getCountry());
			userDto.setAddress(Id.getAddress());
			userDto.setStatus(Id.getStatus());
			userDto.setMobile(Id.getMobile());
			userDto.setCreatedAt(Id.getCreatedAt());
			userDto.setDeletedAt(Id.getDeletedAt());
			userDto.setDeletedBy(Id.getDeletedBy());
			userDto.setUpdatedAt(Id.getUpdatedAt());
			userDto.setUpdatedBy(Id.getUpdatedBy());
		
			vechicleDto.setVechicleNo(Id.getVechicle().getVechicleNo());
			vechicleDto.setEngineNo(Id.getVechicle().getEngineNo());
			vechicleDto.setChasisNo(Id.getVechicle().getChasisNo());
			vechicleDto.setModel(Id.getVechicle().getModel());
			vechicleDto.setBrand(Id.getVechicle().getBrand());
			vechicleDto.setType(Id.getVechicle().getType());
			userDto.setVechicleDto(vechicleDto);
			
			driverDto.setDfirstName(Id.getDriver().getDfirstName());
			driverDto.setDlastName(Id.getDriver().getDlastName());
			driverDto.setLicenseNo(Id.getDriver().getLicenseNo());
			driverDto.setDob(Id.getDriver().getDob());
			driverDto.setCity(Id.getDriver().getCity());
			driverDto.setState(Id.getDriver().getState());
			driverDto.setCountry(Id.getDriver().getCountry());
			driverDto.setAddress(Id.getDriver().getAddress());
			userDto.setDriverDto(driverDto);
			response.setCode(200);
			response.setMessage("SUCCESS");
			response.setData(userDto);
			}
		else
		{
			response.setCode(203);
			response.setMessage("user not found");
		}
		return response ;
		}
	
public MDCPResponse <List<UserDto>> findallcustomer()
{
	MDCPResponse <List<UserDto>> response=new MDCPResponse<>();
	List<UserDto> ll=new ArrayList<>();
	UserDto userDtos=new UserDto();
	VechicleDto vechicleDtos=new VechicleDto();
	DriverDto driverDto=new DriverDto();
	List<User> getall = userRepo.findAll();
	if(getall!=null)
	{
	for (User useradatas : getall) {
		userDtos.setUserId(useradatas.getUserId());
		userDtos.setUserName(useradatas.getUserName());
		userDtos.setFirstName(useradatas.getFirstName());
		userDtos.setLastName(useradatas.getLastName());
		userDtos.setPassword(useradatas.getPassword());
		userDtos.setEmail(useradatas.getEmail());
		userDtos.setMobile(useradatas.getMobile());
		userDtos.setCity(useradatas.getCity());
		userDtos.setState(useradatas.getState());
		userDtos.setDob(useradatas.getDob());
		userDtos.setCountry(useradatas.getCountry());
		userDtos.setAddress(useradatas.getAddress());
		userDtos.setStatus(useradatas.getStatus());
		userDtos.setCreatedAt(useradatas.getCreatedAt());
		userDtos.setCreatedBy(useradatas.getCreatedBy());
		userDtos.setUpdatedAt(useradatas.getUpdatedAt());
		userDtos.setUpdatedBy(useradatas.getUpdatedBy());
		userDtos.setDeletedAt(useradatas.getDeletedAt());
		userDtos.setDeletedBy(useradatas.getDeletedBy());
		
		vechicleDtos.setVechicleId(useradatas.getVechicle().getVechicleId());
		vechicleDtos.setVechicleNo(useradatas.getVechicle().getVechicleNo());
		vechicleDtos.setEngineNo(useradatas.getVechicle().getEngineNo());
		vechicleDtos.setChasisNo(useradatas.getVechicle().getChasisNo());
		vechicleDtos.setModel(useradatas.getVechicle().getModel());
		vechicleDtos.setBrand(useradatas.getVechicle().getBrand());
		vechicleDtos.setType(useradatas.getVechicle().getType());
		userDtos.setVechicleDto(vechicleDtos);
		
		driverDto.setDriverId(useradatas.getDriver().getDriverId());
		driverDto.setDfirstName(useradatas.getDriver().getDfirstName());
		driverDto.setDlastName(useradatas.getDriver().getDlastName());
		driverDto.setLicenseNo(useradatas.getDriver().getLicenseNo());
		driverDto.setDob(useradatas.getDriver().getDob());
		driverDto.setCity(useradatas.getDriver().getCity());
		driverDto.setState(useradatas.getDriver().getState());
		driverDto.setCountry(useradatas.getDriver().getCountry());
		driverDto.setAddress(useradatas.getDriver().getAddress());
		userDtos.setDriverDto(driverDto);
		ll.add(userDtos);
		response.setCode(200);
		response.setMessage("SUCCESS");
		response.setData(ll);
		}}
	else
	{
		response.setCode(203);
		response.setMessage("user not found");
	}
return response;
}
public MDCPResponse <String> deletecustomer(Integer userId)
{
	 MDCPResponse <String> response=new MDCPResponse<>();
	String message="";
	User userfind = userRepo.findByuserId(userId);

	if(userfind !=null)
	{
		userRepo.deleteByuserId(userId);
		response.setCode(200);
		response.setMessage("CustomerData deleted succesfully");
	}
	else
	{
	response.setCode(203);	
	response.setMessage("customer data not deleted");
	}
	return response;
}
public MDCPResponse<String> updateUser(UserDto userDto)
{
	MDCPResponse<String> response=new MDCPResponse<>(); 
	String message=" ";
	User userdata = userRepo.getReferenceById(userDto.getUserId());
	if(userdata !=null)
	{
		userdata.setUserName(userDto.getUserName());
		userdata.setCity(userDto.getCity());
		userRepo.save(userdata);
		response.setCode(200);
		response.setMessage("UPDATE SUCCESS");
	}
	else
	{
		response.setCode(203);
		response.setMessage("userdata not updated");
		}
	return response;	
}
}