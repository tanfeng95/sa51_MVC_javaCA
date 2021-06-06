package team5.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fixset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	@OneToMany
	private List<FixsetDetails> fixsetList;
	
	public Fixset() {
		super();
	}

	public Fixset(String name, String description, List<FixsetDetails> fixsetList) {
		super();
		this.name = name;
		this.description = description;
		this.fixsetList=fixsetList;
	}
	
	public Fixset(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		fixsetList = new ArrayList<FixsetDetails>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FixsetDetails> getFixsetList() {
		return fixsetList;
	}

	public void setFixsetList(List<FixsetDetails> fixsetList) {
		this.fixsetList = fixsetList;
	}
	
	public void addFixsetDetails(FixsetDetails fixsetDetails) {
		fixsetList.add(fixsetDetails);
	}
	
	public void removeFixsetDetails(FixsetDetails fixsetDetails) {
		fixsetList.remove(fixsetDetails);
	}


	@Override
	public String toString() {
		return "Fixset [id=" + id + ", name=" + name + ", description=" + description + "]";
	}	
	
}
