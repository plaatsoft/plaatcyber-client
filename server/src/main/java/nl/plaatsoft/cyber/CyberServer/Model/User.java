package nl.plaatsoft.cyber.CyberServer.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity 
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;	
    
	private String name;
    
	private int level;
	
	@ManyToMany(mappedBy = "users")
	private Set<Element> elements;
	    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	    
    @Override
    public String toString() {
        return String.format(
                "User [id=%d, name='%s', level='%d', ]",id, name, level);
    }
    
	public Set<Element> getElements() {
		return elements;
	}

	public void setElements(Set<Element> elements) {
		this.elements = elements;
	}
}
