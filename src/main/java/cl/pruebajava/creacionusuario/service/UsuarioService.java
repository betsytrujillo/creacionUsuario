package cl.pruebajava.creacionusuario.service;

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service

public class UsuarioService implements UsuarioInterfaceService {
	private static final Logger logger = Logger.getLogger(UsuarioService.class);


	@Autowired
	UsuarioInterfaceRepo usuarioIR;
	@Autowired
	PhoneInterfaceRepo phoneIR;

	@Override
	public Response createUsuario(Usuario user) throws EmailExisteException {
		// TODO Auto-generated method stub

		logger.info("Servicio createUsuario iniciado...");

		Response response = new Response();

		if(!usuarioIR.findByEmail(user.getEmail()).isEmpty()){
			logger.error("Error:[" + user.getEmail() + "] Correo ingresado ya existe en base de datos");
			throw new EmailExisteException();

		}

		UsuarioEntity usuarioE;

		UsuarioMapperImpl usuarioMI = new UsuarioMapperImpl();

		usuarioE = usuarioMI.usuario2usuarioEntity(user);

		GregorianCalendar gcalendar = new GregorianCalendar();
		usuarioE.setCreated(gcalendar.getTime());
		usuarioE.setLast_login(gcalendar.getTime());
		usuarioE.setModified(gcalendar.getTime());
		usuarioE.setIsactive(true);
		
		

		try {
			UsuarioEntity responseUE = usuarioIR.save(usuarioE);

			logger.info("El usuario se ha creado con exito,ID=" + responseUE.getId().toString());
			for (Phone phone : user.getPhones()) {
				PhoneEntity phoneE = new PhoneEntity();

				phoneE.setCountrycode(phone.getCountryCode());
				phoneE.setIdUsuario(responseUE.getId());
				phoneE.setNumber(phone.getNumber());
				phoneIR.save(phoneE);

			}
			response.setCreated(responseUE.getCreated());
			response.setId(responseUE.getId().toString());
			response.setIsactive(responseUE.isIsactive());
			response.setLast_login(responseUE.getLast_login());
			response.setModified(responseUE.getModified());
			logger.info("Token= " + responseUE.getToken());

			response.setToken(responseUE.getToken());
			response.setUsuario(user);
		} catch (Exception e) {
			logger.info(e.getLocalizedMessage());
		}

		

		

		return response;
	}

}
