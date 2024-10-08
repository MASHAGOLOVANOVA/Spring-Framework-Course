package ru.alishev.springcourse.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.alishev.springcourse.models.Mood;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.repositories.PeopleRepository;

@Service
@Transactional(readOnly=true)
public class PeopleService {
	
	private final PeopleRepository peopleRepository;
	
	@Autowired
	public PeopleService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
		
	}
	
	public List<Person> findAll(){
		return peopleRepository.findAll();
	}
	
	public Person findOne(int id) {
		Optional<Person> person= peopleRepository.findById(id);
		return person.orElse(null);
	}
	
	@Transactional
	public void save(Person person) {
		person.setCreatedAt(new Date());
		person.setMood(Mood.CALM);
		peopleRepository.save(person);
}

	@Transactional
	public void update(int id, Person updatedPerson) {
		updatedPerson.setId(id);
		peopleRepository.save(updatedPerson);
	}
	
	@Transactional
	public void delete(int id) {
		peopleRepository.deleteById(id);
	}
	public void test() {
		System.out.println("testing herewith debug. inside hiberrnate transaction");
	}
}
