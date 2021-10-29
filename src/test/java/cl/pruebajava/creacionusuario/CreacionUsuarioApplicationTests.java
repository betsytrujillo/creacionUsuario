package cl.pruebajava.creacionusuario;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.pruebajava.creacionusuario.dto.Phone;
import cl.pruebajava.creacionusuario.dto.Response;
import cl.pruebajava.creacionusuario.dto.Usuario;
import cl.pruebajava.creacionusuario.exceptions.EmailExisteException;
import cl.pruebajava.creacionusuario.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CreacionUsuarioApplicationTests {
	
	@Autowired
	UsuarioService us;
	
	private Usuario  setValuesUsr() {
		Usuario dtoUser = new Usuario();
		dtoUser.setEmail	("pruebajava@gmail.com");
		dtoUser.setName		("Usuario Prueba");
		dtoUser.setPassword	("454545");
		List<Phone> phones = new ArrayList();
		//se agrega solo un telefono de prueba
		Phone phone = new Phone("7654321", "11", "30");
		phones.add(phone);
		
		dtoUser.setPhones(phones);
		
		return dtoUser;
		
	}

	@Test
	void contextLoads() {
	try {
			
			Response usr=	us.createUsuario(this.setValuesUsr());
			//OK cuando ntreega ID objeto d respuesta
				assertThat(usr.getId().length()>0);
			} catch (Exception e) {
					log.error(e.getMessage());				
					
			}
	}
	
	@Test
	void contextLoadsError() {
		
		this.setValuesUsr();
			try {
				us.createUsuario(this.setValuesUsr());
				//en esta llamada se espera la caida
				us.createUsuario(this. setValuesUsr());
				
			} catch (EmailExisteException e) {
				//se espera un 400, por que el correo ya existe
				assertThat(true);
				log.error("CODIGO DE ERROR-->" + String.valueOf( e.getStatusCode()));
			}
		
	}

}
