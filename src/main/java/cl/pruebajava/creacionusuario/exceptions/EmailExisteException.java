package cl.pruebajava.creacionusuario.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmailExisteException extends Exception{
//	private static final long serialVersionUID = 5413770337907359976L;
	@JsonProperty("message")
	private String message;
	@JsonProperty("status_code")
	private int statusCode;
	@JsonProperty("uri")
	private String uriRequested;

	public EmailExisteException(String message, int statusCode, String uriRequested) {
		this.message = message;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}

	public EmailExisteException() {

	}

}
