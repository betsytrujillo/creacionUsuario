package cl.pruebajava.creacionusuario.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="PHONE")
public class PhoneEntity {
	@Id 
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	@Column
	private String number;
	@Column
	private String citycode;
	@Column
	private String countrycode;
	@Column
	private UUID idUsuario;
	
	
	public PhoneEntity(String number, String citycode, String countrycode, UUID idUsuario) {
		this.number = number;
		this.citycode = citycode;
		this.countrycode = countrycode;
		this.idUsuario = idUsuario;
	}
	public PhoneEntity() {
		// TODO Auto-generated constructor stub
	}

}
