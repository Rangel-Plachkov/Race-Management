package bg.fmi.javaweb.racemanagement.controller;

import bg.fmi.javaweb.racemanagement.models.TrackDTO;
import bg.fmi.javaweb.racemanagement.service.TrackService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
    TrackService trackService;

    @PostMapping("/")
    String createTrack(@Valid @RequestBody TrackDTO newTrack) {
        trackService.createTrack(newTrack.getName(), newTrack.getLength());
        return newTrack.toString();
    }
    @GetMapping("/")
    String getTracks(@RequestParam(name = "trackName", required = false) String trackName) {
        if(trackName != null) {
            return trackService.getAllTracksByTrackName(trackName).toString();
        } else {
            return trackService.getAllTracks().toString();
        }
    }
    @PatchMapping("/")
    String updateTrack(@Valid @RequestParam(name = "id") Integer id, @RequestBody TrackDTO newTrack) {
        if(trackService.deleteTrackById(id)) {
            trackService.createTrack(newTrack.getName(), newTrack.getLength());
            return "Track with name " + id + " updated";
        } else {
            return "Track with name " + id + " not found";
        }
    }
    @DeleteMapping("/")
    String deleteTrack(@RequestParam(name = "id") Integer id) {
        if(trackService.deleteTrackById(id)) {
            return "Track with name " + id + " deleted";
        } else {
            return "Track with name " + id + " not found";
        }
    }
}
