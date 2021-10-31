package cl.pruebajava.creacionusuario.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailExisteException extends Exception{

	private static final long serialVersionUID = 4836782185665741488L;
	@JsonProperty("message")
	private String message;
	@JsonProperty("status_code")
	private int statusCode;
	@JsonProperty("uri")
	private String uriRequested;

}
