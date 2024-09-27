package ru.alishev.springcourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import ru.alishev.springcourse.models.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Component
public class PersonDAO {
	
	private final EntityManager entityManager;
	
	@Autowired
	    public PersonDAO(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }
	
	@Transactional(readOnly=true)
	public void testNPlus1() {
		Session session = entityManager.unwrap(Session.class);
		
		Set<Person> people = new HashSet<Person>(session.createQuery("select p from Person p LEFT JOIN FETCH p.items")
				.getResultList());
		
		for (Person p:  people) {
			System.out.println("Person" + p.getName()+" has: "+ p.getItems());
		}
		
	}
	
}
