package cl.pruebajava.creacionusuario.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Validated
@Data

public class Usuario {

	@JsonProperty("name")
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private List<Phone> phones;

	public Usuario() {

	}

	public Usuario(String name, String email, String password, List<Phone> phones) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

}
