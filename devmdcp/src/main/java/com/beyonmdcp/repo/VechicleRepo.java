package com.beyonmdcp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyonmdcp.model.Vechicle;
@Repository
public interface VechicleRepo extends JpaRepository<Vechicle, Integer> {
	
	


}
