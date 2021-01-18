package comm.pos.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Table(name="categories")
@NamedQuery(name="category.getAll",query="SELECT c FROM Category c ORDER BY c.name DESC")
@NamedQuery(name="category.findlatestCategory",query="SELECT c FROM Category c WHERE c.id=(SELECT MAX(d.id) FROM Category d)")
@NamedQuery(name="category.findByendwtihs",query="SELECT c FROM Category c WHERE c.name LIKE :start")
public class Category implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "category")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Item> items;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}


	public Category() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
