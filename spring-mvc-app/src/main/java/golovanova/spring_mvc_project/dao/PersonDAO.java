package golovanova.spring_mvc_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import golovanova.spring_mvc_project.models.Person;

@Component
public class PersonDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PersonDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Person>index(){

		return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
	}
	
	@SuppressWarnings("deprecation")
	public Optional<Person> show(String email) {
		return jdbcTemplate.query("SELECT * from Person WHERE email=?", new Object[] {email},
				new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
	}
	
	
	@SuppressWarnings("deprecation")
	public Person show(int id) {
		return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Person.class))
				.stream().findAny().orElse(null);
	}
	
	public void save(Person person) {
		jdbcTemplate.update("INSERT INTO Person (name, age, email, address) VALUES( ?, ?, ?,?)", person.getName(), person.getAge(), person.getEmail(), person.getAddress());
	}
	
	public void update(int id, Person person) {
		jdbcTemplate.update("UPDATE Person SET name=?, age=?,email=?,address=? WHERE id=?", person.getName(),person.getAge(),person.getEmail(),person.getAddress(),id);
		
	}
	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);
		
	}
	
	
	/////testing batch insert
	public void testBatchUpdate() {
		List<Person> people= create1000People();
		long before = System.currentTimeMillis();
		
		jdbcTemplate.batchUpdate("INSERT INTO Person VALUES(?,?,?,?)", 
				new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement,int i) throws SQLException {
				preparedStatement.setInt(1, people.get(i).getId());
				preparedStatement.setString(2, people.get(i).getName());
				preparedStatement.setString(4, people.get(i).getEmail());
				preparedStatement.setInt(3, people.get(i).getAge());

				preparedStatement.setString(5, people.get(i).getAddress());
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return people.size();
			}
		});

		long after =System.currentTimeMillis();
		System.out.println("time with batch: "+(after-before));
	}
	
	
	public void  testMultipleUpdate() {
		List<Person> people= create1000People();
		
		long before = System.currentTimeMillis();
		
		for (Person person:people) {
		jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?,?)", person.getName(), person.getAge(), person.getEmail(),person.getAddress());
		}
		
		
		long after =System.currentTimeMillis();
		System.out.println("time without batch: "+(after-before));
	}
	
	public List<Person> create1000People(){

		List<Person> people= new ArrayList<>();
		for (int i=0; i<1000;i++) {
			people.add(new Person(i,"name"+i,30+i,"test"+i+"@mail.ru", "mm"));
		}
		return people;
	}
}
