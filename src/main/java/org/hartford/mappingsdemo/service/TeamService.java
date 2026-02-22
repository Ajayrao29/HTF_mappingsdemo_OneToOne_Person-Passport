package org.hartford.mappingsdemo.service;

import org.hartford.mappingsdemo.model.Player;
import org.hartford.mappingsdemo.model.Team;
import org.hartford.mappingsdemo.repository.PlayerRepository;
import org.hartford.mappingsdemo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findById(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Player> getPlayersByTeamId(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        return team.getPlayers();
    }

    public Team bindPlayerToTeam(Long teamId, Long playerId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Invalid team id"));
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Invalid player id"));
        player.setTeam(team);
        playerRepository.save(player);
        return team;
    }

    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }
}

