package bg.fmi.javaweb.racemanagement;

import bg.fmi.javaweb.racemanagement.service.*;
import bg.fmi.javaweb.racemanagement.models.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RaceManagementApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(RaceManagementApplication.class, args);
    }
    @Autowired
    private RacerService racerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TrackService trackService;
    @Autowired
    private EventService eventService;

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started");
/*
        System.out.println("List of Beans provided by Spring Boot:");
        String[] beanNames = context.getBeanDefinitionNames();
        List<String> beanClasses = Stream.of(beanNames)
                .map(el -> context.getBean(el).getClass().toString())
                .filter(el -> el.contains("bg.fmi"))
                .toList();
        beanClasses.forEach(System.out::println);
        // uncomment to see all loaded beans
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName + " - " + context.getBean(beanName).getClass());
        }*/

        /*//RaceService tests
        racerService.createRacer("Ivan", "Ivanov", 25);
        racerService.createRacer("Petar", "Petrov", 30);
        racerService.createRacer("Ivan", "Georgiev", 35);
        racerService.createRacer("Georgi", "Ivanov", 40);
        racerService.createRacer("Petar", "Ivanov", 25);
        racerService.deleteRacerById(0);
        System.out.println(racerService.getAllRacersByFirstName("Ivan"));

        //TeamService tests
        teamService.createTeam("Team1");
        teamService.createTeam("Team2");
        teamService.createTeam("Team3");
        System.out.println(teamService.getAllTeams());

        //TrackService tests
        trackService.createTrack("Sofia", 100);
        trackService.createTrack("Plovdiv", 200);
        trackService.createTrack("Varna", 300);
        System.out.println(trackService.getAllTracks());

        //EventService tests
        eventService.createEvent("Sofia-Tour", new Track("Sofia", 100), LocalDate.EPOCH);
        eventService.createEvent("Plovdiv-Tour", new Track("Plovdiv", 200), LocalDate.EPOCH);
        eventService.createEvent("Varna-Tour", new Track("Varna", 300), LocalDate.EPOCH);
        eventService.createEvent("Burgas-Tour", new Track("Burgas", 400), LocalDate.EPOCH);
        System.out.println(eventService.getAllEvents());*/

    }
}
