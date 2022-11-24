package com.beyonmdcp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beyonmdcp.dto.LoginDto;
import com.beyonmdcp.service.LoginService;
import com.beyonmdcp.util.MDCPResponse;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;  
	
	
	@PostMapping("/customer")
	public MDCPResponse<String> customerLogin(@RequestBody LoginDto loginDto) {
		
		return loginService.customerLogin(loginDto);
	}
	@GetMapping("/logout")
	public MDCPResponse<String> logoutUser(@RequestParam Integer customerId)
	{
	
	return loginService.logoutuser(customerId);
		
	}
}
