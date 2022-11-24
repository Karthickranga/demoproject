package com.beyonmdcp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beyonmdcp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByuserId(Integer userId);
    
	//@Query
	//(" DELETE user, vechicle, driver FROM user INNER JOIN vechicle INNER JOIN driver  WHERE user.user_id = vechicle.user_id AND vechicle.user_id = driver.user_id AND user.user_id")
	//@Modifying
	//@Transactional
	//@Query("delete from UserContentManagep where u.id in(:integers)")
	//void deleteByIdIn     (List<Integer> integers);
	@Transactional 
	public void deleteByuserId(Integer userId); 
	
	public User findByUserName(String userName);
	

}
