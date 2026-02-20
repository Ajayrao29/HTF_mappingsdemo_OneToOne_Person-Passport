package org.hartford.mappingsdemo.repository;

import org.hartford.mappingsdemo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
