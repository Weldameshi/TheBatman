package robson.jake.thebatmanapi.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicle")
public class Vehicle {
	
	@Id private String _id;


	private String name;
	
	private int mph;
	
	private ArrayList<String> capabilities = new ArrayList<>();
	
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
	
}
