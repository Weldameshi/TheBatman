package robson.jake.thebatmanapi.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lair")
public class Lair {

	@Id private String _id;
	
	private String name;
	
	private int sqrft;
	
	private ArrayList<String> traps = new ArrayList<String>();
	
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

	public int getSqrft() {
		return sqrft;
	}

	public void setSqrft(int sqrft) {
		this.sqrft = sqrft;
	}

	public ArrayList<String> getTraps() {
		return traps;
	}

	public void setTraps(ArrayList<String> traps) {
		this.traps = traps;
	}

}