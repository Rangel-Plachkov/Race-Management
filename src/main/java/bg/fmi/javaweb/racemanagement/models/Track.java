package bg.fmi.javaweb.racemanagement.models;

@SuppressWarnings("UnusedDeclaration")
public class Track {
    private static final String DEFAULT_NAME = "Unknown Track";
    private static final Integer DEFAULT_LENGTH = 0;
    private static Integer nextID = 0;
    public Integer ID;
    public String name;
    public Integer length; //in meters

    public Track() {
        setName(DEFAULT_NAME);
        setLength(DEFAULT_LENGTH);
    }
    public Track(String name, Integer length) {
        setName(name);
        setLength(length);
    }

    public void setID() {
        ID = nextID;
        nextID++;
    }
    public Integer getID() {
        return ID;
    }
    public void setName(String name) {
        this.name = (name != null && !name.isEmpty() ? name : DEFAULT_NAME);
    }
    public String getName() {
        return name;
    }
    public void setLength(Integer length) {
        this.length = (length > DEFAULT_LENGTH ? length : DEFAULT_LENGTH);
    }
    public Integer getLength() {
        return length;
    }
    @Override
    public String toString() {
        return String.format("Track %d: %s, %d meters", ID, name, length);
    }


}
