package robson.jake.thebatmanapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Vehicle {
	
	@Id private String _id;


	private String name;
	
	private int mph;
	
	@ManyToOne
	@JsonIgnore
	private Person person;
	
	@ElementCollection
	private List<String> capabilities = new ArrayList<>();
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMph() {
		return mph;
	}

	public void setMph(int mph) {
		this.mph = mph;
	}

	public ArrayList<String> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(ArrayList<String> capabilities) {
		this.capabilities = capabilities;
	}
	@JsonIgnore
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
