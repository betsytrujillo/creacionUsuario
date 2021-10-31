package cl.pruebajava.creacionusuario.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USUARIO")
public class UsuarioEntity {

	@Id 
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private Date created;
	@Column
	private Date modified;
	@Column
	private Date last_login;
	@PreUpdate
	public void setLastLogin() {
		this.last_login= new Date();
	}
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	
	@Column(name = "token", updatable = false, nullable = false)
	private UUID token;
	@PrePersist
    public void setLastUpdate() {
		this.created = new Date();
		this.modified = new Date();
		this.last_login= new Date();

        token = UUID.randomUUID();
    }
	
	@Column
	 private boolean isactive;

}
