package org.hartford.mappingsdemo.controller;

import org.hartford.mappingsdemo.model.Player;
import org.hartford.mappingsdemo.model.Team;
import org.hartford.mappingsdemo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @GetMapping("/{id}/players")
    public List<Player> getPlayersByTeamId(@PathVariable Long id) {
        return teamService.getPlayersByTeamId(id);
    }

    @PutMapping("/{teamId}/bind/{playerId}")
    public Team bindPlayerToTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        return teamService.bindPlayerToTeam(teamId, playerId);
    }

    @DeleteMapping("/{id}")
    public void deleteTeamById(@PathVariable Long id) {
        teamService.deleteById(id);
    }
}
