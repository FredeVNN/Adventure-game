public class Player {

    //Current Room:

    private static Room currentRoom;

    public static void currentRoom() {
    }

    public Room getCurrentRoom() {
        return currentRoom;
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
