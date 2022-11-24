package com.beyonmdcp.util;

import java.util.UUID;

public class AuthTokenGenerator {
//	public static void main(String[] args) {
//		System.out.println(generateToken());
//	}


	public static String generateToken() {
		String uuid = UUID.randomUUID().toString();
		String replace=uuid.replace("-", " ");
		return " "+replace;	
		//String replace = uuid.replace("-", "  ");
		 // return " "+replace; 
		
	}

}
