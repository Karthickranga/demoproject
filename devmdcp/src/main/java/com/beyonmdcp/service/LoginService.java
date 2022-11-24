package com.beyonmdcp.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beyonmdcp.dto.LoginDto;
import com.beyonmdcp.model.Customer;
import com.beyonmdcp.model.Token;
import com.beyonmdcp.repo.CustomerRepo;
import com.beyonmdcp.repo.TokenRepo;
import com.beyonmdcp.util.AuthTokenGenerator;
import com.beyonmdcp.util.MDCPResponse;

@Service
public class LoginService {
	// check username correct or not
	// if username is correct then check password matching associated with username
	// both username and password is correct,then generate token and stored into token table
	// after stored token,also return same token as login response 
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private TokenRepo tokenRepo;

	public MDCPResponse<String> customerLogin(LoginDto loginDto) {
		MDCPResponse<String> response=new MDCPResponse<>();
		String msg = "";
		if(loginDto != null) {
			Customer customer = customerRepo.findByUserName(loginDto.getUserName());
			if(customer != null) {
				
				if(customer.getPassword().equals(loginDto.getPassword())) {
					
				Token tokendata = tokenRepo.findBycustomerId(customer.getCustomerId());
					if(tokendata != null)
					{
			
					String generateToken= AuthTokenGenerator.generateToken();
					System.out.println(generateToken);
					Token token=new Token();
	               token.setToken(generateToken);
					token.setDate(new Date());
					token.setCustomerId(customer.getCustomerId());
					tokenRepo.save(token);
			        response.setCode(200);
			        response.setMessage(generateToken);
				   }
					else {
						response.setCode(203);
						response.setMessage("user already logged in");
						}
				}else {
 					response.setCode(203);
					response.setMessage("Password incorrect, Please enter valid password");
				}
				
			}else {
				response.setCode(203);
				response.setMessage("Username incorrect, Please enter valid username");
}
			
	}else {
			response.setCode(200);
			response.setMessage("Please enter username and password");
			
		}
		
		return response;
		}

	public MDCPResponse<String> logoutuser(Integer customerId) {
		MDCPResponse<String>response=new MDCPResponse<>();
         String msg=" ";
         
         Token findBycustomerId = tokenRepo.findBycustomerId(customerId);
         if(findBycustomerId !=null)
         {
        	 tokenRepo.deleteBycustomerId(customerId);
        	 response.setCode(200);
        	 response.setMessage("customer logout successfully");
         }
         else
         {
        	response.setCode(203); 
        	response.setMessage("customer not logged in");
         }
            return response;
            }
	}
	
