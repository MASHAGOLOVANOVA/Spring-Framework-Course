package hse.golovanova.spring_projects.SecurityApp.services;

import hse.golovanova.spring_projects.SecurityApp.models.Person;
import hse.golovanova.spring_projects.SecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> getPersonByUsername(String name) {
        Optional<Person> person = this.peopleRepository.findByUsername(name);
        return person;
    }
}
