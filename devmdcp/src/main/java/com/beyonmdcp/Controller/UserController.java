package com.beyonmdcp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beyonmdcp.dto.UserDto;
import com.beyonmdcp.service.UserService;
import com.beyonmdcp.util.MDCPResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	 
	
	@PostMapping("/useradd")
	public MDCPResponse<String> addUserData(@RequestBody UserDto userDto,@RequestHeader String token )
	{
		return userService.adduser(userDto,token);
		
	}
}
