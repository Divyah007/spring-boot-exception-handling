package com.divya.exception.handling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.exception.handling.ExceptionHandler.ResourceNotFoundException;

@RestController
@RequestMapping("/state")
public class StateController {
	@GetMapping("/name")
	public String cityName() {
		String m="State Name Tamil Nadu";
			int c=10/0;
			
	return m;
	}
	
	@GetMapping("/weather/{state}")
	public String getWeather(String state) throws ResourceNotFoundException {
		String m="The weather is manageable";
		int i=0;
		if(i==0) {
			throw	new ResourceNotFoundException("The state with name: "+state+" is not found in the records");
	
		}
			
	return m;
	}

}
