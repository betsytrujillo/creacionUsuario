package cl.pruebajava.creacionusuario.repository.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.pruebajava.creacionusuario.entity.UsuarioEntity;

public interface UsuarioInterfaceRepo extends JpaRepository<UsuarioEntity, UUID> {
	
	List<UsuarioEntity> findByEmail(String email);

}
