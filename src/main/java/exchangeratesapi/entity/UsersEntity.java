package exchangeratesapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UsersEntity {
	
	@Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "token")
	private String token;
	
	

}
