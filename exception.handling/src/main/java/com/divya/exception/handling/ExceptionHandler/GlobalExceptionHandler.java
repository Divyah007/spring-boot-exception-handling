package com.divya.exception.handling.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
//==============================
//	@ControllerAdvice---> @Component +
//	It will intercept(catch)
//	exceptions from both @Controller and @RestController annotated controllers.
//	Can handle both views (HTML) and REST responses (JSON/XML) depending on the controller type.
//	
//	@RestControllerAdvice---> @ControllerAdvice + @ResponseBody +
//	It will intercept exceptions only from @RestController 
//	annotated controllers.Primarily handles REST responses, so methods typically 
//	return JSON/XML directly.
	
	//====================================
	
//	@ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<?> handleGlobalException(Exception ex) {
//		Map<String,String> m=new HashMap<>();
//	m.put("Message", "Arthimetic Exception occured try again");
//	m.put("Error code ", HttpStatus.INTERNAL_SERVER_ERROR.toString());
//        return new ResponseEntity<>(m,HttpStatus.OK);
//    }
	
	
	
	@ExceptionHandler(ArithmeticException.class)
  public Map<String,String> handleGlobalException(Exception ex) {
		Map<String,String> m=new HashMap<>();
	m.put("Message", "Arthimetic Exception occured try again");
	m.put("Error code ", HttpStatus.INTERNAL_SERVER_ERROR.toString());
	m.put("type", "Global Exception Handler");
      return m;
  }
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	  public Map<String,String> handleGlobalExceptionForResourceNotFoundException(Exception ex) {
			Map<String,String> m=new HashMap<>();
		m.put("Message",ex.getMessage().toString());
		m.put("type", "Global Exception Handler");
	      return m;
	  }

}
