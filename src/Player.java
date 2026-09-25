public class Player {

    //Current Room:
    private Room currentRoom;

    public Player(Room startRoom){
        this.currentRoom = startRoom;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    //Move - Direction
    public boolean move(String direction) {

        Room desiredRoom = currentRoom.getExit(direction);

        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        }
        else {
            return false;
        }
    }
}
