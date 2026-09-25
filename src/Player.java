public class Player {

    //Current Room:
    private Room currentRoom;

    public Player(Room startRoom){
        this.currentRoom = startRoom;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }

    //Move - Direction
    public boolean move(String direction) {

        Room desiredRoom = switch (direction) {
            case "north" -> currentRoom.getNorth();
            case "south" -> currentRoom.getSouth();
            case "east"  -> currentRoom.getEast();
            case "west"  -> currentRoom.getWest();
            default -> null;
        };

        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        }
        else {
            return false;
        }
    }
}
