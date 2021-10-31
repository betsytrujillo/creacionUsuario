package cl.pruebajava.creacionusuario.dto;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

	@JsonProperty("usuario")
	private Usuario usuario;
	@JsonProperty("id")
	private String id;
	@JsonProperty("created")
	private Date created;
	@JsonProperty("modified")
	private Date modified;
	@JsonProperty("last_login")
	private Date last_login;
	@JsonProperty("token")
	private UUID token;
	@JsonProperty("isactive")
	private boolean isactive;


}
