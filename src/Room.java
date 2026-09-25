public class Room {
    private String name;
    private String description;

    private Room north, south, east, west;

    //Constructor:
    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }

    //Get Room info:
    public String getName() {return name;}

    public String getDescription() {return description;}

    //Get direction:
    public Room getExit(String direction) {
        return switch (direction) {
            case "north" -> north;
            case "south" -> south;
            case "east" -> east;
            case "west" -> west;
            default -> null;
        };
    }
    //Set Direction:
    public void setNorth(Room room){
        this.north = room;
    }

    public void setEast(Room room) {
        this.east = room;
    }

    public void setSouth(Room room) {this.south = room;}

    public void setWest(Room room) {
        this.west = room;
    }
}
