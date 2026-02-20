package org.hartford.mappingsdemo.repository;

import org.hartford.mappingsdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
