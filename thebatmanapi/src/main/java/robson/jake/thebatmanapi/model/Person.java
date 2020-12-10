package robson.jake.thebatmanapi.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "people")
public class Person{

	@Id
	private String _id;
	
	private String firstName;
	
	private String lastName;
	
	private String ailias;
	
	private String classification;
	
	private List<String> lairsLivedIn = new ArrayList<>();
	
	private List<String> vehiclesOwned = new ArrayList<>();
	
	private List<String> abilities = new ArrayList<>();
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAilias() {
		return ailias;
	}

	public void setAilias(String ailias) {
		this.ailias = ailias;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public List<String> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<String> abilities) {
		this.abilities = abilities;
	}

	public List<String> getLairsLivedIn() {
		return lairsLivedIn;
	}

	public void setLairsLivedIn(List<String> lairsLivedIn) {
		this.lairsLivedIn = lairsLivedIn;
	}

	public List<String> getVehiclesOwned() {
		return vehiclesOwned;
	}

	public void setVehiclesOwned(List<String> vehiclesOwned) {
		this.vehiclesOwned = vehiclesOwned;
	}




}
