package robson.jake.thebatmanapi.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "tech")
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

	public List<String> getFunctions() {
		return functions;
	}

	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}


}
