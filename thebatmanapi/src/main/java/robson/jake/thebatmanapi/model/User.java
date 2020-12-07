package robson.jake.thebatmanapi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection = "user")
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id private String _id;
	
	private String username;
	
	private String password;
	
	private List<String> authorities = new ArrayList<>();
	
	public User() {}

	public User(String username, String password, String...authorities) {
		this.setUsername(username);
		this.setPassword(password);
		this.authorities.addAll(Arrays.asList(authorities));
	}
	@Override
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
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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