import java.util.ArrayList;

public class Room {
    private String roomNum;
    private String roomName;
    private String roomDescription;
    private boolean discoveredRoom = false;
    private ArrayList<Item> items;

    private Room north, south, east, west;

    //Constructor:
    public Room(String roomNum, String name, String description) {
        this.roomNum = roomNum;
        this.roomName = name;
        this.roomDescription = description;
        this.items = new ArrayList<>();
    }

    //Get Room info:
    public String getName() {
        return roomName;
    }

    public String getDescription() {
        return roomDescription;
    }

    public String getRoomNum() {
        return roomNum;
    }

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
    public void setNorth(Room room) {
        this.north = room;
    }

    public void setEast(Room room) {
        this.east = room;
    }

    public void setSouth(Room room) {
        this.south = room;
    }

    public void setWest(Room room) {
        this.west = room;
    }

    // Discover rooms:
    public boolean isDiscoveredRoom() {
        return discoveredRoom;
    }

    public void setDiscoveredRoom(boolean discoveredRoom) {
        this.discoveredRoom = discoveredRoom;
    }

    //Add items to rooms:
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    // Removes an item from the room
    public void removeItem(Item item) {
        items.remove(item);
    }

    // Search for items:
    public Item findItemByName(String itemName) {

        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }


}
