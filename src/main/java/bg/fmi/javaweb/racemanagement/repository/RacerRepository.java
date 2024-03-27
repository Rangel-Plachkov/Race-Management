package bg.fmi.javaweb.racemanagement.repository;

import bg.fmi.javaweb.racemanagement.models.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@SuppressWarnings("UnusedDeclaration")
@Repository
public class RacerRepository {
    private static final Map<Integer, Racer> racerTable = new HashMap<>();

    public void createRacer(Racer racer) {

        if(racer.getID() != null) {
            throw new IllegalArgumentException("Cannot create Racer with already given ID.");
        }
        racer.setID();
        racerTable.put(racer.getID(), racer);
    }
    public void updateRacer(Racer racer) {
        if(racer.getID() == null) {
            throw new IllegalArgumentException("Cannot update Racer without ID.");
        }
        racerTable.put(racer.getID(), racer);
    }
    public boolean deleteRacerById(Integer id) {
        return racerTable.remove(id) != null;
    }
    public Optional<Racer> getRacerById(Integer id) {
            return Optional.of(racerTable.get(id));
    }
    public List<Racer> getAllRacers() {
        return new ArrayList<>(racerTable.values());
    }

}
