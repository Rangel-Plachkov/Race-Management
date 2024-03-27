package bg.fmi.javaweb.racemanagement.repository;

import bg.fmi.javaweb.racemanagement.models.Team;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@SuppressWarnings("UnusedDeclaration")
@Repository
public class TeamRepository {

    private static final Map<String, Team> teamTable = new HashMap<>();

    public void createTeam(Team team) {
        if(team.getName() == null) {
            throw new IllegalArgumentException("Cannot create models.Team without name.");
        }
        teamTable.put(team.getName(), team);
    }
    public void updateTeam(Team team) {
        if(team.getName() == null) {
            throw new IllegalArgumentException("Cannot update models.Team without name.");
        }
        teamTable.put(team.getName(), team);
    }

    public boolean deleteTeamByName(String name) {
        return teamTable.remove(name) != null;
    }
    public Optional<Team> getTeamById(String name) {
        return Optional.ofNullable(teamTable.get(name));
    }

    public List<Team> getAllTeams() {
        return new ArrayList<>(teamTable.values());
    }
}