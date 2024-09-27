package golovanova.spring_mvc_project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import golovanova.spring_mvc_project.dao.PersonDAO;
import golovanova.spring_mvc_project.models.Person;


@Component
public class PersonValidator implements Validator {

	private final PersonDAO personDAO;
	
	@Autowired
	public PersonValidator(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Person p = (Person) target;
		if (personDAO.show(p.getEmail()).isPresent()) {
			errors.rejectValue("email", "", "Email already taken");
			
		}
	}
}
