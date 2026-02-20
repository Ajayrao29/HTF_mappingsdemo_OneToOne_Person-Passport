package org.hartford.mappingsdemo.repository;

import org.hartford.mappingsdemo.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
