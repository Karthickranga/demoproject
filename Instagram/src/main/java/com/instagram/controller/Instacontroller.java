package com.instagram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.dto.Signindto;
import com.instagram.service.Instaservice;

@RestController
@RequestMapping("/insta")
public class Instacontroller {
	@Autowired
	private Instaservice instaservice;
	@PostMapping("/ins")
	 public String adddetails(@RequestBody Signindto signindto)
	 {
		return instaservice.addser(signindto);
		 
	 }

}
