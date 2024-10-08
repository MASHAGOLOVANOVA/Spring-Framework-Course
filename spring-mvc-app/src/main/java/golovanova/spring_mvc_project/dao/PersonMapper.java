package golovanova.spring_mvc_project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import golovanova.spring_mvc_project.models.Person;

public class PersonMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Person person = new Person();
		
		person.setId(resultSet.getInt("id"));
		person.setName(resultSet.getString("name"));
		person.setAge(resultSet.getInt("age"));
		person.setEmail(resultSet.getString("email"));
		return person;
	}

	

}
