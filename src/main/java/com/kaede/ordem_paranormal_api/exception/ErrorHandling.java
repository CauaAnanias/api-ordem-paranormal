package com.kaede.ordem_paranormal_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> tratarErroDeRegraDeNegocio(RuntimeException ex){
		return ResponseEntity.badRequest().body("{\"erro\": \"" + ex.getMessage() + "\"}");
	}
}
