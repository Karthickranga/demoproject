package com.beyonmdcp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beyonmdcp.dto.CustomerDto;
import com.beyonmdcp.model.Customer;
import com.beyonmdcp.repo.CustomerRepo;
import com.beyonmdcp.util.MDCPResponse;

@Service
public class CustomerService {
	// we should validate username already exists or not 
	// if username exist not allow to insert data into DB and return message
	// username already exists,please try another one
	//if user not available we can allow to insert data in to DB
	@Autowired
	private CustomerRepo customerRepo;

	public MDCPResponse<String> addCustomerdata(CustomerDto customerDto) {
		MDCPResponse<String> response=new MDCPResponse<>();
		String message = "";
		if (customerDto != null)
		{
		Customer customerdata = customerRepo.findByUserName(customerDto.getUserName());
			if (customerdata != null){
				response.setCode(203);
				response.setMessage("userName already exists please enter valid userName");
				}
			else {
			Customer customer = new Customer();
				customer.setCustomerName(customerDto.getCustomerName());
				customer.setUserName(customerDto.getUserName());
				customer.setPassword(customerDto.getPassword());
				customer.setCompanyName(customerDto.getCompanyName());
				customer.setType(customerDto.getType());
				customer.setDob(customerDto.getDob());
				customer.setAddress(customerDto.getAddress());
				customer.setCity(customerDto.getCity());
				customer.setState(customerDto.getState());
				customer.setCountry(customerDto.getCountry());
				customer.setStatus(customerDto.getStatus());
				customer.setMobile(customerDto.getMobile());
				customer.setEmail(customerDto.getEmail());
				Customer save = customerRepo.save(customer);
			    	response.setCode(200);
			    	response.setMessage("customerData added successfully");
		}}
		
		return response;   
		}

	public MDCPResponse<CustomerDto> getdetail(Integer customerId) {
		MDCPResponse<CustomerDto> response=new MDCPResponse<>();
		  CustomerDto customerDto=new CustomerDto();
		Customer id = customerRepo.getReferenceById(customerId);
        if(id !=null)
        {
          customerDto.setCustomerName(id.getCustomerName());  
          customerDto.setUserName(id.getUserName());
          customerDto.setPassword(id.getPassword());
          customerDto.setCompanyName(id.getCompanyName());
          customerDto.setType(id.getType());
          customerDto.setDob(id.getDob());
          customerDto.setAddress(id.getAddress());
          customerDto.setCity(id.getCity());
          customerDto.setState(id.getState());
          customerDto.setCountry(id.getCountry());
          customerDto.setStatus(id.getStatus());
          customerDto.setMobile(id.getMobile());
          customerDto.setEmail(id.getEmail());
          response.setCode(200);
          response.setMessage("SUCCESS");
        }
        else
        {
        	response.setCode(203);
        	response.setMessage("please enter valid customer");
        }
		return response;
	}
	
	public MDCPResponse <List<CustomerDto>> getCustomerAll()
	{
		MDCPResponse <List<CustomerDto>> response=new MDCPResponse<>();
		List<CustomerDto> customerlist=new ArrayList<>();
		CustomerDto customerDto=new CustomerDto();
		List<Customer> find = customerRepo.findAll();
		if(find!=null)
		{
		for (Customer custom : find) {
			customerDto=new CustomerDto();
			customerDto.setCustomerId(custom.getCustomerId());
			customerDto.setCustomerName(custom.getCustomerName());
			customerDto.setUserName(custom.getUserName());
			customerDto.setPassword(custom.getPassword());
			customerDto.setCompanyName(custom.getCompanyName());
			customerDto.setType(custom.getType());
			customerDto.setDob(custom.getDob());
			customerDto.setAddress(custom.getAddress());
			customerDto.setCity(custom.getCity());
			customerDto.setState(custom.getState());
			customerDto.setCountry(custom.getCountry());
			customerDto.setStatus(custom.getStatus());
			customerDto.setMobile(custom.getMobile());
			customerDto.setEmail(custom.getEmail());
			customerlist.add(customerDto);
			response.setCode(200);
			response.setMessage("SUCCESS");
		}	
		}
		else
		{
			response.setCode(203);
			response.setMessage("All customerData required");
		}
                return response;
	}

	public MDCPResponse<String> customerDelete(Integer customerId) {
		MDCPResponse<String> response=new MDCPResponse<>();
		Customer customerdata = customerRepo.findBycustomerId(customerId);
		String message="";
		if(customerdata !=null)
		{
			customerRepo.deleteById(customerId);
			response.setCode(200);
			response.setMessage("customerdata deleted succesfully");
			}
		else
		{
			response.setCode(203);
			response.setMessage("customer data not deleted");
		}
         return response;
	}
	public MDCPResponse <String> updateUser(CustomerDto customerDto)
	{
		MDCPResponse<String> response=new MDCPResponse<>();
		
		Customer ById= customerRepo.findBycustomerId(customerDto.getCustomerId());
		if(ById !=null)
		{
			ById.setUserName(customerDto.getUserName());
			ById.setState(customerDto.getState());
			response.setCode(200);
			response.setMessage("customer data update successfully");
		}
		else
		{
			response.setCode(203);
			response.setMessage("customer data not updated");
		}
		
		return response;
		
	}
	
	} 
