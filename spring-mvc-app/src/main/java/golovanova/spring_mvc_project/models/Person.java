package golovanova.spring_mvc_project.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {

	private int id;
	
	@NotEmpty(message = "Name should not be empty")
	@Size(min=2,max=30, message="Name length should be <30,>2")
	private String name;
	@Min(value =1, message = "Min age value = 1")
	private int age;
	@NotEmpty(message = "Email should not be empty")
	@Email(message="Email should be valid")
	private String  email;
	
	
	//country, city, index(6 signs)
	@Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message="Your address should be in this format: Country, City, index(6 signs)")
	private String address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person(int id,String name, int age, String email, String address) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.email=email;
		this.address=address;
		
	}
	public Person() {
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
