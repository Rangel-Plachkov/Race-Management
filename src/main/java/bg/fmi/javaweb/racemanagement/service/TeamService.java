package bg.fmi.javaweb.racemanagement.service;

import bg.fmi.javaweb.racemanagement.models.*;
import bg.fmi.javaweb.racemanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@SuppressWarnings("UnusedDeclaration")
@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.getAllTeams();
    }
    public List<Team> getAllTeamsByTeamName(String teamName) {
        return teamRepository.getAllTeams().stream()
                .filter(team -> Objects.equals(team.getName(), teamName) )
                .toList();
    }
    public void createTeam(String name, String country) {
        teamRepository.createTeam(new Team(name));
    }
    public boolean deleteTeamByName(String name) {
        return teamRepository.deleteTeamByName(name);
    }


}
