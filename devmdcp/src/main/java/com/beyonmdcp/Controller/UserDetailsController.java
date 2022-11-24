package com.beyonmdcp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beyonmdcp.dto.UserDto;
import com.beyonmdcp.model.User;
import com.beyonmdcp.service.UserDetails;
import com.beyonmdcp.util.MDCPResponse;

@RestController
@RequestMapping("/userdetail")
public class UserDetailsController {
	@Autowired
	private UserDetails userDetails;
	
	@GetMapping("/userone")
	public MDCPResponse<UserDto> getuserDetails(@RequestParam Integer userId)
	{
		return userDetails.getbyuserDetails(userId);
		}
	@GetMapping("/finduser")
public MDCPResponse<List<UserDto>> findallusers()
{
	return userDetails.findallcustomer();
		
}

	@DeleteMapping("/deletecustomer")
	public MDCPResponse<String> deleteCustomerId(@RequestParam Integer userId)
	{
		return userDetails.deletecustomer(userId);
		
	}
	@PostMapping("/updateuserdata")
	public MDCPResponse<String> updateUser(@RequestBody UserDto userDto)
	{
		return userDetails.updateUser(userDto);
	
}
} 
 