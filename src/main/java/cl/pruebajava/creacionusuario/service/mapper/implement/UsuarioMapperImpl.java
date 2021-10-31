package cl.pruebajava.creacionusuario.service.mapper.implement;

import org.modelmapper.ModelMapper;

import cl.pruebajava.creacionusuario.dto.Usuario;
import cl.pruebajava.creacionusuario.entity.UsuarioEntity;
import cl.pruebajava.creacionusuario.service.mapper.interfaces.UsuarioInterfaceMapper;

public class UsuarioMapperImpl implements UsuarioInterfaceMapper {

	public UsuarioEntity usuario2usuarioEntity(Usuario usuario) {
		// TODO Auto-generated method stub

		ModelMapper modelMapper = new ModelMapper();

		UsuarioEntity usuarioE = modelMapper.map(usuario, UsuarioEntity.class);

		return usuarioE;
	}

}
