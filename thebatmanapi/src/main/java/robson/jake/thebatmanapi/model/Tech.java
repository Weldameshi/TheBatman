package robson.jake.thebatmanapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Tech {
	
	@Id private String _id;

	private String name;
	
	private List<String> functions = new ArrayList<>();

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

	public ArrayList<String> getFunctions() {
		return functions;
	}

	public void setFunctions(ArrayList<String> functions) {
		this.functions = functions;
	}

}
