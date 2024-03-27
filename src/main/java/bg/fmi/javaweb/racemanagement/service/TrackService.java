package bg.fmi.javaweb.racemanagement.service;

import bg.fmi.javaweb.racemanagement.models.*;
import bg.fmi.javaweb.racemanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings("UnusedDeclaration")
@Service
public class TrackService {
    @Autowired
    TrackRepository trackRepository;

    public List<Track> getAllTracks() {
        return trackRepository.getAllTracks();
    }
    public List<Track> getAllTracksByTrackName(String trackName) {
        return trackRepository.getAllTracks().stream()
                .filter(track -> track.getName().equals(trackName) )
                .toList();
    }

    public void createTrack(String name, Integer length) {
        trackRepository.createTrack(new Track(name, length));
    }

    public boolean deleteTrackById(Integer id) {
        return trackRepository.deleteTrackById(id);
    }

}
