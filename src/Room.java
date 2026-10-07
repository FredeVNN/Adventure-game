import java.util.ArrayList;

public class Room {
    //room information
    private String roomNum;
    private String roomName;
    private String roomDescription;
    private String guide;
    private boolean discoveredRoom = false;
    //room content
    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies;
    //room directions
    private Room north, south, east, west;

    // Constructor:
    public Room(String roomNum, String name, String description, String guide) {
        this.roomNum = roomNum;
        this.roomName = name;
        this.roomDescription = description;
        this.guide = guide;
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }
    //get connected rooms:
    public Room getNorth() {
        return north;
    }
    public Room getSouth() {
        return south;
    }
    public Room getEast() {
        return east;
    }
    public Room getWest() {
        return west;
    }
    // Get Room info:
    public String getName() {
        return roomName;
    }

    public String getDescription() {
        return roomDescription;
    }

    public String getGuide() {
        return guide;
    }

    public String getRoomNum() {
        return roomNum;
    }

    // Set room connections:
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

    // checks if room is discovered:
    public boolean isDiscoveredRoom() {
        return discoveredRoom;
    }
    //changes the discovered status
    public void setDiscoveredRoom(boolean discoveredRoom) {
        this.discoveredRoom = discoveredRoom;
    }

    // gets room items:
    public ArrayList<Item> getItems() {
        return items;
    }
    //adds item to room
    public void addItem(Item item) {
        items.add(item);
    }

    // Removes an item from the room:
    public void removeItem(Item item) {
        items.remove(item);
    }

    // Search for items in room:
    public Item findItemByName(String itemName) {

        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    //gets room enemies
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    //adds enemy ro room:
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
    //removes enemy from room
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }
    //finds enemy in room:
    public Enemy findEnemy(String shortName) {
        for (Enemy enemy : enemies) {
            if (enemy.getShortName().equalsIgnoreCase(shortName)) {
                return enemy;
            }
        }
        return null;
    }
}