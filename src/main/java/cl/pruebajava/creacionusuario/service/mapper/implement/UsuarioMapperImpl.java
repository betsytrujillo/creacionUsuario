package cl.pruebajava.creacionusuario.service.mapper.implement;

import cl.pruebajava.creacionusuario.dto.Usuario;
import cl.pruebajava.creacionusuario.entity.UsuarioEntity;
import cl.pruebajava.creacionusuario.service.mapper.interfaces.UsuarioInterfaceMapper;

public class UsuarioMapperImpl implements UsuarioInterfaceMapper{

	public UsuarioEntity usuario2usuarioEntity(Usuario usuario) {
		// TODO Auto-generated method stub
		
		UsuarioEntity usuarioE = new UsuarioEntity();
		
		usuarioE.setEmail(usuario.getEmail());
		usuarioE.setName(usuario.getName());
		usuarioE.setPassword(usuario.getPassword());
		return usuarioE;
	}

}
