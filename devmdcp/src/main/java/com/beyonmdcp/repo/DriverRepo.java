package com.beyonmdcp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyonmdcp.model.Driver;
@Repository
public interface DriverRepo  extends JpaRepository<Driver, Integer>{
	


}
