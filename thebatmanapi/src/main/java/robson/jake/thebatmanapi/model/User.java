package robson.jake.thebatmanapi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User{
		
	@Id
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@ElementCollection
	private List<String> authorities = new ArrayList<>();
	
	public User() {}

	public User(String username, String password, String...authorities) {
		this.setUsername(username);
		this.setPassword(password);
		this.authorities.addAll(Arrays.asList(authorities));
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}


	

}