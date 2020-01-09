package br.com.projects.emailservice.resources.exceptions.handler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.emailservice.resources.exceptions.StandardError;
import br.com.projects.emailservice.services.exceptions.ResourceNotFoundException;

@RestController
@ControllerAdvice
public class ResourceNotFoundExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String error = "Recurso não encontrado";
		String message = ex.getMessage();
		String path = req.getRequestURI();

		StandardError err = new StandardError(Instant.now(), status.value(), error, message, path);
		return ResponseEntity.status(status).body(err);
	}

}
