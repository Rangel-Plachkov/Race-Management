package bg.fmi.javaweb.racemanagement.controller;

import bg.fmi.javaweb.racemanagement.service.TeamService;
import bg.fmi.javaweb.racemanagement.models.TeamDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @PostMapping("/")
    String createTeam(@Valid @RequestBody TeamDTO newTeam) {
        teamService.createTeam(newTeam.getName());
        return newTeam.toString();
    }
    @GetMapping("/")
    String getTeams(@RequestParam(name = "teamName", required = false) String teamName) {
        if(teamName != null) {
            return teamService.getAllTeamsByTeamName(teamName).toString();
        } else {
            return teamService.getAllTeams().toString();
        }
    }
    @PatchMapping("/")
    String updateTeam(@Valid @RequestParam(name = "name") String name, @RequestBody TeamDTO newTeam) {
        if(teamService.deleteTeamByName(name)) {
            teamService.createTeam(newTeam.getName());
            return "Team with name " + name + " updated";
        } else {
            return "Team with name " + name + " not found";
        }
    }
    @DeleteMapping("/")
    String deleteTeam(@RequestParam(name = "name") String name) {
        if(teamService.deleteTeamByName(name)) {
            return "Team with name " + name + " deleted";
        } else {
            return "Team with name " + name + " not found";
        }
    }

}
