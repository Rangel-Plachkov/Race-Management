package bg.fmi.javaweb.racemanagement;

import bg.fmi.javaweb.racemanagement.models.Racer;

import bg.fmi.javaweb.racemanagement.service.RacerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RaceManagementApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(RaceManagementApplication.class, args);
        /*

        Racer racer1 = new Racer("Ivan", "Ivanov", 25);
        Racer racer2 = new Racer("Petar", "Petrov", 30);
        Racer racer3 = new Racer("Georgi", "Georgiev", 35);
        Racer racer4 = new Racer("Stoyan", "Stoyanov", 40);
        Racer racer5 = new Racer("Ivaylo", "Ivaylov", 45);


        RacerService racerService = new RacerService();
        racerService.createRacer(racer1.getFirstName(), racer1.getLastName(), racer1.getAge());
        racerService.createRacer(racer2.getFirstName(), racer2.getLastName(), racer2.getAge());
        racerService.createRacer(racer3.getFirstName(), racer3.getLastName(), racer3.getAge());
        racerService.createRacer(racer4.getFirstName(), racer4.getLastName(), racer4.getAge());
        racerService.createRacer(racer5.getFirstName(), racer5.getLastName(), racer5.getAge());

        System.out.println("test");
        //List<Racer> arr = racerService.getAllRacers();

        for (Racer racer : arr) {
            System.out.println(racer.getFirstName() + " " + racer.getLastName() + " " + racer.getAge());
        }
        */

    }
    @Autowired
    private RacerService racerService;

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("List of Beans provided by Spring Boot:");

        String[] beanNames = context.getBeanDefinitionNames();
        List<String> beanClasses = Stream.of(beanNames)
                .map(el -> context.getBean(el).getClass().toString())
                .filter(el -> el.contains("bg.fmi"))
                .toList();
        beanClasses.forEach(System.out::println);

        // uncomment to see all loaded beans
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName + " - " + context.getBean(beanName).getClass());
//        }

        System.out.println(">>>>>>>>>>>> add custom logic here");

        racerService.createRacer("Test", "Test", 18);
        racerService.createRacer("Test1", "Test1", 18);
        racerService.createRacer("Test2", "Test2", 18);

        //racerService.getAllRacers().forEach(System.out::println);
        racerService.getAllRacersByFirstName("Test").forEach(System.out::println);
        //racerService.deleteRacerById(1);
    }


}
