package com.instagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.dto.Signindto;
import com.instagram.entity.Signinentity;
import com.instagram.entity.Signoutentity;
import com.instagram.repo.Signinrepo;
import com.instagram.repo.Signoutrepo;
@Service

public class Instaservice {
	@Autowired
	 private Signinrepo signinrepo;
	@Autowired
	 private Signoutrepo signoutrepo;

	public String addser(Signindto signindto) {
		String mes="";
		if(signindto!=null)
		{
			Signinentity signinentity=new Signinentity();
			Signoutentity signoutentity=new Signoutentity();
			signinentity.setName(signindto.getName());
			Signinentity save = signinrepo.save(signinentity);
			signoutentity.setSigninentity(save);
			signoutentity.setAge(signindto.getSignoutdto().getAge());
			
			signoutentity.setCity(signindto.getSignoutdto().getCity());
			Signoutentity save2 = signoutrepo.save(signoutentity);
			if(save2!=null)
			{
				mes="inserted";
			}
			else
			{
				mes="not";
			}
		}
		return mes;
	}}
	
 
