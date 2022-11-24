package com.beyonmdcp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beyonmdcp.dto.Signupdto;
import com.beyonmdcp.model.Signup;
import com.beyonmdcp.repo.SignupRepo;
@Service
public class SignupService {
	@Autowired
	private SignupRepo signupRepo;

	public String signupCustomer(Signupdto signupdto) {
		String msg="";
		if(signupdto!=null)
		{
			Signup findbyduplicate= signupRepo.findByuserName(signupdto.getUserName());
			if(findbyduplicate == null)
			{
	    Signup signup=new Signup();
		signup.setCustomerId(signupdto.getCustomerId());
		signup.setUserName(signupdto.getUserName());
		signup.setPassword(signupdto.getPassword());
		signup.setCompanyName(signupdto.getCompanyName());
		signup.setDob(signupdto.getDob());
		signup.setAddress(signupdto.getAddress());
		signup.setCity(signupdto.getCity());
		signup.setState(signupdto.getState());
		signup.setCountry(signupdto.getCountry());
		signup.setStatus(signupdto.getStatus());
		signup.setMobile(signupdto.getMobile());
		signup.setEmail(signupdto.getEmail());
		signupRepo.save(signup);
		msg ="user sign_up successfully";
		return msg;
			}
		else
		{
			msg="user_name already available pls enter valid user_name";
		}}
		else
		{
			msg="invalid user_name";
		}
	
	return msg;
		
	}

}