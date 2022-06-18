package io.github.lucasvilasboas.clientes.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import io.github.lucasvilasboas.clientes.exception.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleValidationErros( MethodArgumentNotValidException ex) {
		
		BindingResult bidingResult = ex.getBindingResult();
		List<String> messages = bidingResult.getAllErrors()
		.stream()
		.map(objectError  -> objectError.getDefaultMessage())
		.collect(Collectors.toList());
		return new ApiErrors(messages);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleResponseStatusExApiErrors(ResponseStatusException ex) {
		String messagemErro = ex.getMessage();
		HttpStatus codigoStatus = ex.getStatus();
		ApiErrors apiErros = new ApiErrors(messagemErro);
		return new ResponseEntity(apiErros, codigoStatus);
	}
}
