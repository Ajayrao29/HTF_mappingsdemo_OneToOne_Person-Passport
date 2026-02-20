package org.hartford.mappingsdemo.service;

import org.hartford.mappingsdemo.model.Passport;
import org.hartford.mappingsdemo.model.Person;
import org.hartford.mappingsdemo.repository.PassportRepository;
import org.hartford.mappingsdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PassportRepository passportRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Passport getPassportByPersonId(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        return passportRepository.findAll().stream()
                .filter(p -> p.getPerson() != null && p.getPerson().getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Person bindPassportToPerson(Long personId, Long passportId) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Invalid person id"));
        Passport passport = passportRepository.findById(passportId).orElseThrow(() -> new RuntimeException("Invalid passport id"));
        passport.setPerson(person);
        passportRepository.save(passport);
        return person;
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
