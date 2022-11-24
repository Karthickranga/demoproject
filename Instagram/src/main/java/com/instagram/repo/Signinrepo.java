package com.instagram.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagram.entity.Signinentity;

@Repository
public interface Signinrepo extends JpaRepository<Signinentity, Integer> {

}
