package org.hartford.mappingsdemo.service;

import org.hartford.mappingsdemo.model.Passport;
import org.hartford.mappingsdemo.model.Person;
import org.hartford.mappingsdemo.repository.PassportRepository;
import org.hartford.mappingsdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportService {
    @Autowired
    private PassportRepository passportRepository;
    @Autowired
    private PersonRepository personRepository;
    public List<Passport> findAll(){
        return passportRepository.findAll();
    }

    public Passport findById(Long id){
     return passportRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
    }

    public Passport addPassport(Passport passport){
        Person p=passport.getPerson();
        if(p==null){
            return passportRepository.save(passport);
        }
        p=personRepository.save(p);
        passport.setPerson(p);
        return passportRepository.save(passport);
    }

    public Person getPersonByPassportId(Long id){
        Passport passport = passportRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
        return passport.getPerson();
    }
    public Passport bindPersonToPerson(Long passportId, Long personId){
        Passport passport = passportRepository.findById(passportId).orElseThrow(() -> new RuntimeException("Invalid passport id"));
        Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Invalid person id"));
        passport.setPerson(person);
        return passportRepository.save(passport);

    }

    public void deleteById(Long id) {
        passportRepository.deleteById(id);
    }
}
