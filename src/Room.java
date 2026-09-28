import java.util.ArrayList;

public class Room {
    private String roomNum;
    private String roomName;
    private String roomDescription;
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
        return roomName;
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

    //Add items:
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    // Search for items:
    public Item findItemByName(String itemName) {
        Item found = null;

        for (int i = 0; i < items.size(); i++) {
            System.out.println(itemName + );
        }
    }
}
