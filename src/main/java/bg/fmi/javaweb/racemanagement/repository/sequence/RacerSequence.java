package bg.fmi.javaweb.racemanagement.repository.sequence;

public class RacerSequence {
    private static Integer sequence = 1000;

    public static Integer getNextValue() {
        return sequence++;
    }
}