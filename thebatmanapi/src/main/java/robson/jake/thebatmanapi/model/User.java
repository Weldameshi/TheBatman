package robson.jake.thebatmanapi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
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
	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities.stream()
				.map(s -> new GrantedAuthority() {
				private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return s;
			}
		}).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		return true;
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