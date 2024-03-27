import service.RacerService;
import models.Racer;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java Web!");
        RacerService racerService = new RacerService();
        racerService.createRacer("Ivan", "Ivanov", 25);
        racerService.createRacer("Petar", "Petrov", 30);
        racerService.createRacer("Georgi", "Georgiev", 35);
        racerService.createRacer("Stoyan", "Stoyanov", 40);
        racerService.createRacer("Ivaylo", "Ivaylov", 45);

        for(Racer racer : racerService.getAllRacers()) {
            System.out.println(racer.getFirstName() + " " + racer.getLastName() + " " + racer.getAge());
        }
    }
}
