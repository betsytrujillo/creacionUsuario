package cl.pruebajava.creacionusuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

	@JsonProperty("number")
	public String number;
	@JsonProperty("cityCode")
	public String cityCode;
	@JsonProperty("countryCode")
	public String countryCode;

}
