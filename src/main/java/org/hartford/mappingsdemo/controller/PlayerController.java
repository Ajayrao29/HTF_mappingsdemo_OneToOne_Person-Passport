package org.hartford.mappingsdemo.controller;

import org.hartford.mappingsdemo.model.Player;
import org.hartford.mappingsdemo.model.Team;
import org.hartford.mappingsdemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.findById(id);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @GetMapping("/{id}/team")
    public Team getTeamByPlayerId(@PathVariable Long id) {
        return playerService.getTeamByPlayerId(id);
    }

    @PutMapping("/{playerId}/bind/{teamId}")
    public Player bindTeamToPlayer(@PathVariable Long playerId, @PathVariable Long teamId) {
        return playerService.bindTeamToPlayer(playerId, teamId);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable Long id) {
        playerService.deleteById(id);
    }
}


