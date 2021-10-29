package cl.pruebajava.creacionusuario.controller;


import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.pruebajava.creacionusuario.dto.Response;
import cl.pruebajava.creacionusuario.dto.Usuario;
import cl.pruebajava.creacionusuario.exceptions.EmailExisteException;
import cl.pruebajava.creacionusuario.service.interfaces.UsuarioInterfaceService;

@RestController
@RequestMapping("/createUser")

public class CreateUsuarioController {
	private static final Logger logger = Logger.getLogger(CreateUsuarioController.class);

	@Autowired UsuarioInterfaceService usuarioIS;
	@RequestMapping(method = RequestMethod.POST, path="")
	public ResponseEntity <Response> createUsuario ( @Valid @RequestBody Usuario user) throws EmailExisteException  {
		Response userResponse= new Response();
		
		try {
			
			userResponse=	usuarioIS.createUsuario(user);
		} catch (EmailExisteException e) {
			logger.error("Email existe en Base de Datos");
			throw new EmailExisteException();
		}
		
			return new ResponseEntity<Response>(userResponse,HttpStatus.CREATED);
	
	}

}
