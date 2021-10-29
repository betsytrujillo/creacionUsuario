package cl.pruebajava.creacionusuario.repository.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.pruebajava.creacionusuario.entity.PhoneEntity;

public interface PhoneInterfaceRepo extends JpaRepository<PhoneEntity, UUID>{

}
