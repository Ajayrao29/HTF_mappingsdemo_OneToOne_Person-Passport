package org.hartford.mappingsdemo.controller;

import org.hartford.mappingsdemo.model.Passport;
import org.hartford.mappingsdemo.model.Person;
import org.hartford.mappingsdemo.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {
    @Autowired
    PassportService passportService;

    @GetMapping
    public List<Passport> getAllPassports() {
        return passportService.findAll();
    }

    @GetMapping("/{id}")
    public Passport getPassportById(@PathVariable Long id) {
        return passportService.findById(id);
    }

    @PostMapping
    public Passport addPassport(@RequestBody Passport passport) {
        return passportService.addPassport(passport);
    }

    @GetMapping("/p/{id}")
    public Person getPersonByPassportId(@PathVariable Long id) {
        return passportService.getPersonByPassportId(id);
    }

    @PutMapping("/{passportId}/bind/{personId}")
    public Passport bindPersonToPassport(@PathVariable Long passportId, @PathVariable Long personId) {
        return passportService.bindPersonToPerson(passportId, personId);
    }

    @DeleteMapping("/{id}")
    public void deletePassportById(@PathVariable Long id) {
        passportService.deleteById(id);
    }
}
