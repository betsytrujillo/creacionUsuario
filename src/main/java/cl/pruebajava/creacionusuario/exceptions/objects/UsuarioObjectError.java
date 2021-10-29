package cl.pruebajava.creacionusuario.exceptions.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UsuarioObjectError {
	@JsonProperty("message")
	private String message;
	@JsonProperty("status_code")
	private int statusCode;
	@JsonProperty("uri")
	private String uriRequested;
	
	public UsuarioObjectError(String message, int statusCode, String uriRequested) {
		this.message = message;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}

}
