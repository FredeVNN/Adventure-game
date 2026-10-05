import java.util.ArrayList;

public class Player {

    // Current Room:
    private Room currentRoom;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    // Move - Direction:
    public boolean move(String direction) {

        Room desiredRoom = currentRoom.getExit(direction);

        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        } else {
            return false;
        }
    }

    // Create Inventory:
    private ArrayList<Item> inventory = new ArrayList<>();

    // Add items to inventory:
    public void addToInventory(Item item) {
        inventory.add(item);
    }


    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // Removes an item from the player's inventory:
    public void removeFromInventory(Item item) {
        inventory.remove(item);
    }

    // Search for items:
    public Item findItemByName(String itemName) {

        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    // Player life:
    int health = 10;

  // Equip weapon:

    private Weapon equippedWeapon;

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void equipWeapon(Weapon weapon) {
        equippedWeapon = weapon;
    }

    // Attack:
    public void attack() {

        if (equippedWeapon == null) {
            return;
        }

        if (!equippedWeapon.canUse()) {
            return;
        }

        equippedWeapon.use();

        int damage = equippedWeapon.getDamage();
    }
}