package bg.fmi.javaweb.racemanagement.service;

import bg.fmi.javaweb.racemanagement.models.Racer;
import bg.fmi.javaweb.racemanagement.repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RacerService {

    @Autowired
    private final RacerRepository racerRepository;

    @Autowired
    public RacerService(RacerRepository racerRepository) {
        this.racerRepository = racerRepository;
    }


    public List<Racer> getAllRacers() {
        return racerRepository.findAll();
    }

    public List<Racer> getAllRacersByFirstName(String firstName) {
        return racerRepository.findAll().stream()
                .filter(racer -> Objects.equals(racer.getFirstName(), firstName) )
                .toList();
    }
    public void createRacer(String firstName, String lastName, Integer age) {
        racerRepository.save(new Racer(firstName, lastName, age));
    }
    public boolean deleteRacerById(Integer id) {
        Optional<Racer> racerOptional = racerRepository.findById(id);
        if (racerOptional.isPresent()) {
            racerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
