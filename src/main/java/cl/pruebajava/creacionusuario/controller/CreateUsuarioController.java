package cl.pruebajava.creacionusuario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.pruebajava.creacionusuario.dto.Response;
import cl.pruebajava.creacionusuario.dto.Usuario;
import cl.pruebajava.creacionusuario.exceptions.EmailExisteException;
import cl.pruebajava.creacionusuario.service.interfaces.UsuarioInterfaceService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/createUser")
@Slf4j
public class CreateUsuarioController{
	@Autowired
	UsuarioInterfaceService usuarioIS;

	@PostMapping(value = "")
	public ResponseEntity<Response> createUsuario(@Valid @Validated @RequestBody Usuario user) throws EmailExisteException{
		Response userResponse = new Response();

		userResponse = usuarioIS.createUsuario(user);
		return new ResponseEntity<Response>(userResponse, HttpStatus.CREATED);

	}

}
