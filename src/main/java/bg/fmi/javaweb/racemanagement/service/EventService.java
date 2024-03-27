package bg.fmi.javaweb.racemanagement.service;

import bg.fmi.javaweb.racemanagement.models.*;
import bg.fmi.javaweb.racemanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@SuppressWarnings("UnusedDeclaration")
@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public List<Event> getAllEvents(){
        return eventRepository.getAllEvents();
    }
    public List<Event> getAllRacersByTrackName(String trackName){
        return eventRepository.getAllEvents().stream()
                .filter(event -> event.getTrack().getName().equals(trackName))
                .toList();
    }
    public void createEvent(String eventName, Track track, ArrayList<Team> teams, LocalDate date){
        eventRepository.createEvent(new Event());
    }
    public boolean deleteEventByID(Integer eventID){
        return eventRepository.deleteEventById(eventID);
    }
    public List<Event> getAllEventsBefore(LocalDate date){
        return eventRepository.getAllEvents().stream()
                .filter(event -> event.getDate().isBefore(date))
                .toList();
    }
    public List<Event> getAllEventsAfter(LocalDate date){
        return eventRepository.getAllEvents().stream()
                .filter(event -> event.getDate().isAfter(date))
                .toList();
    }
    public List<Event> getUpcomingEvents(){
        return eventRepository.getAllEvents().stream()
                .filter(event -> event.getDate().isAfter(LocalDate.now()))
                .toList();
    }
    public List<Racer> getAllRacersFromNearestEvent(){
        return eventRepository.getAllEvents().stream()
                .filter(event -> event.getDate().isAfter(LocalDate.now()))
                .findFirst()
                .get()
                .getTeams()
                .stream()
                .flatMap(team -> team.getRacers().stream())
                .toList();
    }
    public List<Event> getEventsForTrack(Track track){
        return eventRepository.getAllEvents().stream()
                .filter(event -> event.getTrack().equals(track))
                .toList();
    }


}
