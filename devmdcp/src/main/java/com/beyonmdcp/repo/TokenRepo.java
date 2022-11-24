package com.beyonmdcp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beyonmdcp.model.Token;


@Repository
public interface TokenRepo extends JpaRepository<Token, Integer>{
	
	public Token findByToken(String token);
	
	public Token findBycustomerId(Integer customerId);
	
	
	@Transactional
	@Modifying
    @Query("delete from Token e  where e.customerId=:customerId") 
	public void deleteBycustomerId(Integer customerId);
	
	
	
	
}
