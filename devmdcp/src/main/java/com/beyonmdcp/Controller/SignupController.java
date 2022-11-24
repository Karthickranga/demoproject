package com.beyonmdcp.Controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beyonmdcp.dto.Signupdto;
import com.beyonmdcp.service.SignupService;

@RestController
@RequestMapping("/signup")
public class SignupController {
	@Autowired
	private SignupService signupService;

	@PostMapping("userSignup")
	public String signUpCustomer(@RequestBody Signupdto signupdto )
	{
		return signupService.signupCustomer(signupdto) ;
	}

}
