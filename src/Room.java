public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room west;
    private Room south;

    //Constructor:

    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }

    //Get Room info:

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Get direction:

    public Room getEast() {
        return east;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    //Set Direction:

    public void setNorth(Room room){
        this.north = north;
    }

    public void setEast(Room room) {
        this.east = east;
    }

    public void setSouth(Room room) {
        this.south = south;
    }

    public void setWest(Room room) {
        this.west = west;
    }
}
