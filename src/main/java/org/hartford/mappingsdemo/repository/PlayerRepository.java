package org.hartford.mappingsdemo.repository;

import org.hartford.mappingsdemo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
