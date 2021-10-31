package cl.pruebajava.creacionusuario.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import cl.pruebajava.creacionusuario.dto.Phone;
import cl.pruebajava.creacionusuario.dto.Response;
import cl.pruebajava.creacionusuario.dto.Usuario;
import cl.pruebajava.creacionusuario.entity.PhoneEntity;
import cl.pruebajava.creacionusuario.entity.UsuarioEntity;
import cl.pruebajava.creacionusuario.exceptions.EmailExisteException;
import cl.pruebajava.creacionusuario.repository.interfaces.PhoneInterfaceRepo;
import cl.pruebajava.creacionusuario.repository.interfaces.UsuarioInterfaceRepo;
import cl.pruebajava.creacionusuario.service.interfaces.UsuarioInterfaceService;
import cl.pruebajava.creacionusuario.service.mapper.implement.UsuarioMapperImpl;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService implements UsuarioInterfaceService {
//	private static final Logger logger = Logger.getLogger(UsuarioService.class);

	@Autowired
	UsuarioInterfaceRepo usuarioRepository;
	@Autowired
	PhoneInterfaceRepo phoneRepository;

	@Override
	public Response createUsuario(Usuario user) throws EmailExisteException {
		// TODO Auto-generated method stub

		log.info("Servicio createUsuario iniciado...");

		Response response = new Response();

		if (!usuarioRepository.findByEmail(user.getEmail()).isEmpty()) {
			log.error("Error:{} Correo ingresado ya existe en base de datos", user.getEmail());

			throw new EmailExisteException();

		}
		UsuarioEntity usuarioEntity;

		UsuarioMapperImpl usuarioMI = new UsuarioMapperImpl();
		usuarioEntity = usuarioMI.usuario2usuarioEntity(user);
		usuarioEntity.setIsactive(true);

		try {
			UsuarioEntity responseUserEntity = usuarioRepository.save(usuarioEntity);

			log.info("El usuario se ha creado con exito,ID= {}", responseUserEntity.getId());

			for (Phone phone : user.getPhones()) {
				PhoneEntity phoneEntity = new PhoneEntity();

				ModelMapper modelMapper = new ModelMapper();
				phoneEntity = modelMapper.map(phone, PhoneEntity.class);
				phoneEntity.setIdUsuario(responseUserEntity.getId());
				phoneRepository.save(phoneEntity);

			}
			response.setCreated(responseUserEntity.getCreated());
			response.setId(responseUserEntity.getId().toString());
			response.setIsactive(responseUserEntity.isIsactive());
			response.setLast_login(responseUserEntity.getLast_login());
			response.setModified(responseUserEntity.getModified());
			log.info("Token= " + responseUserEntity.getToken());

			response.setToken(responseUserEntity.getToken());
			response.setUsuario(user);
		} catch (Exception e) {
			log.info(e.getLocalizedMessage());
		}

		return response;
	}

}
