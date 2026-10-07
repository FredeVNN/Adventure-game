import java.util.ArrayList;

public class Room {
    private String roomNum;
    private String roomName;
    private String roomDescription;
    private String guide;
    private boolean discoveredRoom = false;
    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies;
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

    // Set Direction:
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

    // Add items to rooms:
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    // Removes an item from the room:
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
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }
    public Enemy findEnemy(String shortName) {
        for (Enemy enemy : enemies) {
            if (enemy.getShortName().equalsIgnoreCase(shortName)) {
                return enemy;
            }
        }
        return null;
    }
}