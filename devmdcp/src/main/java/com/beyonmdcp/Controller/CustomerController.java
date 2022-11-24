package com.beyonmdcp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beyonmdcp.dto.CustomerDto;
import com.beyonmdcp.dto.UserDto;
import com.beyonmdcp.service.CustomerService;
import com.beyonmdcp.util.MDCPResponse;

@RestController

@RequestMapping("/customer")

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@PostMapping("/add")
	public MDCPResponse<String> addustomerdata(@RequestBody CustomerDto customerDto)
	{
		return customerService.addCustomerdata(customerDto);
		
	}
	@GetMapping("/getAllCustomer")
	public MDCPResponse<List<CustomerDto>> getAllCustomer()
	{
		return customerService.getCustomerAll();
	}
	@DeleteMapping("/delete")
	public MDCPResponse<String> deleteid(@RequestParam Integer customerId)
	{
		return customerService.customerDelete(customerId);
		
	}  
	@PostMapping("/updateCustomer")
	public MDCPResponse<String> updatecustomer(@RequestBody CustomerDto customerDto)
	{
		return customerService.updateUser(customerDto);
		
	}
	
	
	
}
