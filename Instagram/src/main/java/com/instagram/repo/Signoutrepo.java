package com.instagram.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagram.entity.Signoutentity;

@Repository
public interface Signoutrepo extends JpaRepository<Signoutentity, Integer> {

}
