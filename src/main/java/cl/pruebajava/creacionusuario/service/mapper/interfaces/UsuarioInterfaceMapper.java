package cl.pruebajava.creacionusuario.service.mapper.interfaces;

import org.mapstruct.factory.Mappers;

import cl.pruebajava.creacionusuario.dto.Usuario;
import cl.pruebajava.creacionusuario.entity.UsuarioEntity;


public interface UsuarioInterfaceMapper {
	
	UsuarioInterfaceMapper INSTANCE = Mappers.getMapper(UsuarioInterfaceMapper.class);
	public UsuarioEntity usuario2usuarioEntity(Usuario usuario);
}
