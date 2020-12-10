package robson.jake.thebatmanapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import robson.jake.thebatmanapi.MyViews;


@Entity
public class Lair {

	
	@Id
	@JsonView(MyViews.PersonView.class)
	private String _id;
	
	@JsonView(MyViews.PersonView.class)
	private String name;
	
	private int sqrft;
	
	@ManyToMany(mappedBy="lairs")
	@JsonIgnore
	private List<Person> peopleWhoLiveInLair = new ArrayList<Person>();
	
	@ElementCollection
	private List<String> traps = new ArrayList<String>();
	
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
	@JsonIgnore
	public List<Person> getPeopleWhoLiveInLair() {
		return peopleWhoLiveInLair;
	}

	public void setPeopleWhoLiveInLair(List<Person> peopleWhoLiveInLair) {
		this.peopleWhoLiveInLair = peopleWhoLiveInLair;
	}

	public List<String> getTraps() {
		return traps;
	}

	public void setTraps(ArrayList<String> traps) {
		this.traps = traps;
	}

}