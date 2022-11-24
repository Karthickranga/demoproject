package com.beyonmdcp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyonmdcp.model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
 
	public Customer findByUserName(String userName);
	
	public Customer findBycustomerId(Integer customerId);   

		

}
