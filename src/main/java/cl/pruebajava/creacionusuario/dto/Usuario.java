package cl.pruebajava.creacionusuario.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@JsonProperty("name")
	@NotNull
	private String name;
	@NotNull
	@Pattern(regexp = "^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$", message="El email ingresado es invalido")
	private String email;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]{3}", message="La clave ingresada no es valida")
	private String password;
	@NotNull
	private List<Phone> phones;

}
