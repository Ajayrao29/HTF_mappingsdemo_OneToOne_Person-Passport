package org.hartford.mappingsdemo.controller;

import org.hartford.mappingsdemo.model.Passport;
import org.hartford.mappingsdemo.model.Person;
import org.hartford.mappingsdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping("/{id}/passport")
    public Passport getPassportByPersonId(@PathVariable Long id) {
        return personService.getPassportByPersonId(id);
    }

    @PutMapping("/{personId}/bind/{passportId}")
    public Person bindPassportToPerson(@PathVariable Long personId, @PathVariable Long passportId) {
        return personService.bindPassportToPerson(personId, passportId);
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deleteById(id);
    }
}
