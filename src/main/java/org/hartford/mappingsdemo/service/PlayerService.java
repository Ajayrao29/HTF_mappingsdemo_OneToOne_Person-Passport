package org.hartford.mappingsdemo.service;

import org.hartford.mappingsdemo.model.Player;
import org.hartford.mappingsdemo.model.Team;
import org.hartford.mappingsdemo.repository.PlayerRepository;
import org.hartford.mappingsdemo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }

    public Player addPlayer(Player player) {
        if (player.getTeam() != null && player.getTeam().getId() != null) {
            Team team = teamRepository.findById(player.getTeam().getId())
                    .orElseThrow(() -> new RuntimeException("Invalid team id"));
            player.setTeam(team);
        }
        return playerRepository.save(player);
    }

    public Team getTeamByPlayerId(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        return player.getTeam();
    }

    public Player bindTeamToPlayer(Long playerId, Long teamId) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Invalid player id"));
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Invalid team id"));
        player.setTeam(team);
        return playerRepository.save(player);
    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
