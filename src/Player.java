import java.util.ArrayList;

public class Player {

//player info:
    private Room currentRoom;
    private Weapon equippedWeapon;
    private int health = 100;
//constructor:
    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    // gets Current Room:
    public Room getCurrentRoom() {
        return currentRoom;
    }

    // Moves player - Direction:
    public boolean move(String direction) {

        Room desiredRoom = switch (direction) {
            case "north", "n" -> currentRoom.getNorth();
            case "east", "e" -> currentRoom.getEast();
            case "south", "s" -> currentRoom.getSouth();
            case "west", "w" -> currentRoom.getWest();
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

    // Create Inventory:
    private ArrayList<Item> inventory = new ArrayList<>();

    // Add items to inventory:
    public void addToInventory(Item item) {
        inventory.add(item);
    }
    //gets inventory:
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // Removes an item from the players inventory:
    public void removeFromInventory(Item item) {
        inventory.remove(item);

        if (item == equippedWeapon) {
            equippedWeapon = null;
        }
    }

    // Search for items in inventory:
    public Item findItemByName(String itemName) {

        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    //take item that are available in current room
    public Item takeItem (String itemName) {
        Item item = currentRoom.findItemByName((itemName));

        if (item == null) {
            return null;
        }
        currentRoom.removeItem(item);
        addToInventory(item);

        return item;
    }
    //drop item from inventory
    public Item dropItem (String itemName) {
        Item item = findItemByName(itemName);

        if (item == null) {
            return null;
        }
        removeFromInventory(item);
        currentRoom.addItem(item);

        return item;
    }
    //gets Equipped weapon:
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    //equips weapon
    public EquipResult equip (String weaponName) {
        Item item = findItemByName(weaponName);

        if (item == null) {
            return EquipResult.NOT_FOUND;
        }
        if (!(item instanceof Weapon)) {
            return EquipResult.NOT_WEAPON;
        }
        equippedWeapon = (Weapon) item;
        return EquipResult.EQUIPPED;
    }
    //eats food:
    public EatOutcome eat (String itemName) {
        Item item = findItemByName(itemName);
        boolean itemIsInInventory = item != null;
        if (item == null) {
            item = currentRoom.findItemByName(itemName);
        }

        if (item == null) {
            return new EatOutcome(EatResult.NOT_FOUND,itemName,0);
        }
        if (!(item instanceof Food)) {
            return new EatOutcome(EatResult.NOT_FOOD,item.getItemName(),0);
        }
        Food food = (Food) item;

        changeHealth(food.getHealthPoints());

        if (itemIsInInventory) {
            removeFromInventory(food);
        }
        else {
            currentRoom.removeItem(food);
        }
        return new EatOutcome(EatResult.EATEN,food.getItemName(), food.getHealthPoints());
    }
    //gets player health
    public int getHealth() {
        return health;
    }
    //checks if player is alive
    public boolean isAlive() {
        return health > 0;
    }
    //damages player
    public boolean hit(int damage) {
        changeHealth(-damage);

        return !isAlive();
    }
    //changes player health
    private void changeHealth (int healthChange) {
        health = health + healthChange;

        if (health < 0) {
            health = 0;
        }
    }

    // Attack enemy:
    public AttackResult attack(Enemy enemy) {

        if (equippedWeapon == null) {
            return AttackResult.NO_WEAPON;
        }

        if (!equippedWeapon.canUse()) {
            return AttackResult.WEAPON_EMPTY;
        }

        equippedWeapon.use();

        //No enemy means attacking empty air:
        if (enemy == null) {
            return AttackResult.EMPTY_AIR;
        }
        boolean enemyDied = enemy.hit(equippedWeapon.getDamage());

        if (enemyDied) {
            return AttackResult.ENEMY_DIED;
        }
        return AttackResult.ENEMY_HIT;
    }
}