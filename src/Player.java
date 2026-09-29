import java.util.ArrayList;

public class Player {

    //Current Room:
    private Room currentRoom;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    //Move - Direction
    public boolean move(String direction) {

        Room desiredRoom = currentRoom.getExit(direction);

        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        } else {
            return false;
        }
    }

    //Create Inventory
    private ArrayList<Item> items;
    ArrayList<Item> inventory = new ArrayList<>();

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    //Add items to inventory:
    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // Removes an item from the player's inventory
    public void removeFromInventory(Item item) {
        inventory.remove(item);
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
