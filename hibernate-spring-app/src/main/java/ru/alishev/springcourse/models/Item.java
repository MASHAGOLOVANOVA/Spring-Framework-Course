package ru.alishev.springcourse.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="Item")
public class Item {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@NotEmpty(message = "Item name should not be empty")
	@Column(name="item_name")
	private String itemName;
	
	@ManyToOne
	@JoinColumn(name="person_id",referencedColumnName="id")
	private Person owner;
	
	public Item() {}
	
	public Item(String item_name) {
		this.itemName = item_name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return itemName;
	}
	
	public void setName(String item_name) {
		this.itemName=item_name;
	}
	
	public Person getOwner() {
		return owner;
	}
	
	public void setOner(Person person) {
		this.owner=person;
	}
	 @Override
	    public String toString() {
	        return "Item{" +
	                "id=" + id +
	                ", name='" + itemName+'}';
	    }
	
}
