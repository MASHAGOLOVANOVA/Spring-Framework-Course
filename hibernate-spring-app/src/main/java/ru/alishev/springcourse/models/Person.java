package ru.alishev.springcourse.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email
    @Column(name="email")
    private String email;
    
    @Column(name="date_of_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @OneToMany(mappedBy = "owner")
    private List<Item> items;
    

    @Enumerated(EnumType.STRING)
    private Mood mood;
    
    public Person() {

    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ',' +email+'}';
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Item> getItems(){
    	return items;
    }
    
    public void setItems(List<Item> items) {
    	this.items= items;
    }
    

    // Геттер для date_of_birth
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    // Сеттер для date_of_birth
    public void setDateOfBirth(Date date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }

    // Геттер для createdAt
    public Date getCreatedAt() {
        return createdAt;
    }

    // Сеттер для createdAt
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    // Геттер для mood
    public Mood getMood() {
        return mood;
    }

    // Сеттер для mood
    public void setMood(Mood mood) {
        this.mood = mood;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение с самим собой
        if (!(o instanceof Person)) return false; // Проверка типа объекта
        Person p = (Person) o; // Приведение типа
        return id == p.id; // Сравнение по id (можно изменить на другие поля, если нужно)
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id); // Генерация хэш-кода по id
    }
}
