package cl.pruebajava.creacionusuario.dto;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
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

	public Response() {

	}

	public Response(Usuario usuario, String id, Date created, Date modified, Date last_login, UUID token,
			boolean isactive) {
		super();
		this.usuario = usuario;
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.token = token;
		this.isactive = isactive;
	}

}
