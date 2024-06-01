package com.divya.exception.handling.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.exception.handling.ExceptionHandler.ResourceNotFoundException;

@RestController
@RequestMapping("/city")
public class CityController {
	
	
	//case 1:
	//1. in response we get 500 error in post man and exception will be printed in console
	@GetMapping("/name")
	public String cityName() {
		String m="City Name Coimbatore";
			int c=10/0;
			
	return m;
	}
	
	//----------------------------------------------------
	
	//case 2:
	//2. "m" will print as response in postman. sout inside catch block will be printed will be printed.

//	@GetMapping("/name")
//	public String cityName() {	
//		String m="City Name Coimbatore";
//		try {
//			int c=10/0;
//		}catch(Exception e) {
//		System.out.println("========="+e);
//		}
//		
//		return m;
//	}
	
	@GetMapping("/weather/{city}")
	public String getWeather(String city) throws ResourceNotFoundException {
		String m="The weather is moderate";
		int i=0;
		if(i==0) {
			throw new ResourceNotFoundException("The city with name: "+city+" is not found in the records");
	
		}
			
	return m;
	}
	//===========================================================
	//===locally handling exception--> means if ArithmeticException occurs within this class
//	this method will
//	be executed
	//==========================================
	@ExceptionHandler(value=ArithmeticException.class)
	public Map<String,String> exceptionHandlerForArithmeticException(){
		Map<String,String> m=new HashMap<>();
		m.put("Message", "Arthimetic Exception occured");
		return m;
	}

}
