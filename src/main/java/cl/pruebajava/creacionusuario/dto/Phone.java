package cl.pruebajava.creacionusuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Phone {

	@JsonProperty("number")
	public String number;
	@JsonProperty("cityCode")
	public String cityCode;
	@JsonProperty("countryCode")
	public String countryCode;

	public Phone() {

	}

	public Phone(String number, String cityCode, String countryCode) {
		super();
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}

}
