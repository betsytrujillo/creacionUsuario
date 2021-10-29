package cl.pruebajava.creacionusuario.service.interfaces;

import cl.pruebajava.creacionusuario.dto.Response;
import cl.pruebajava.creacionusuario.dto.Usuario;
import cl.pruebajava.creacionusuario.exceptions.EmailExisteException;

public interface UsuarioInterfaceService {
	
	Response createUsuario(Usuario user) throws EmailExisteException;

}
