package com.beyonmdcp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyonmdcp.model.Signup;

@Repository
public interface SignupRepo extends JpaRepository<Signup, Integer>{
	
	public Signup findByuserName(String userName);

}
