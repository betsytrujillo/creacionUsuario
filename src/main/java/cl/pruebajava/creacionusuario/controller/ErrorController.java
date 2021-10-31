package cl.pruebajava.creacionusuario.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.pruebajava.creacionusuario.exceptions.EmailExisteException;
import cl.pruebajava.creacionusuario.exceptions.objects.UsuarioObjectError;

@ControllerAdvice
public class ErrorController{

	@ExceptionHandler({ EmailExisteException.class })
	public ResponseEntity<UsuarioObjectError> handleMethodArgumentNotValid(HttpServletRequest request,
			EmailExisteException e) {
		UsuarioObjectError errorInfo = new UsuarioObjectError("El correo ingresado ya existe en base de datos",
				HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<UsuarioObjectError> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
    	
    	BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();        
    	UsuarioObjectError errorInfo = new UsuarioObjectError("Parametro ingresado no valido: campo " + fieldErrors.get(0).getField(),
				HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<UsuarioObjectError> handleAllExceptions(HttpServletRequest request, UsuarioObjectError e) {
		UsuarioObjectError errorInfo = new UsuarioObjectError("Error interno", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
