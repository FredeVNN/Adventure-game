public class Room {
    private String roomNum;
    private String name;
    private String description;

    private Room north, south, east, west;

    //Constructor:
    public Room(String roomNum, String name, String description){
        this.roomNum = roomNum;
        this.name = name;
        this.description = description;
    }

    //Get Room info:
    public String getName() {return name;}

    public String getDescription() {return description;}

    public String getRoomNum() {return roomNum;}

    //Get direction:
    public Room getExit(String direction) {
        return switch (direction) {
            case "n" -> north;
            case "s" -> south;
            case "e" -> east;
            case "w" -> west;
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
