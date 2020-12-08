package robson.jake.thebatmanapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person{

	@Id private String _id;
	
	private String firstName;
	
	private String lastName;
	
	private String ailias;
	
	private String classification;
	
	@ManyToMany
	private List<Lair> lairs = new ArrayList<>();
	
	@OneToMany(mappedBy="person")
	private List<Vehicle> vehicles = new ArrayList<>();
	
	private ArrayList<String> abilities = new ArrayList<>();
	
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

	public ArrayList<String> getAbilities() {
		return abilities;
	}

	public void setAbilities(ArrayList<String> abilities) {
		this.abilities = abilities;
	}

	public List<Lair> getLairs() {
		return lairs;
	}

	public void setLairs(List<Lair> lairs) {
		this.lairs = lairs;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


}
