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

    // Moves player to connected room - Direction:
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
    //finds and takes item from room to inventory
    public Item takeItem (String itemName) {
        Item item = currentRoom.findItemByName((itemName));

        if (item == null) {
            return null;
        }
        currentRoom.removeItem(item);
        addToInventory(item);

        return item;
    }
    //finds and moves item from inventory to room
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

    //equips weapon found in inventory
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
    //finds food, changes health, and removes eaten item - from inventory or current room
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
    //applies damage and return whether player died
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

    // Finds enemy, uses equipped weapon and returns attack result:
    public AttackOutcome attack(String enemyName) {

        Enemy enemy = null;

        // Finds named enemy:
        if (!enemyName.isBlank()) {
            enemy = currentRoom.findEnemy(enemyName);

            if (enemy == null) {
                return new AttackOutcome(AttackResult.ENEMY_NOT_FOUND, null, null);
            }
        }
        // Selects first enemy if no name is entered:
        else if (!currentRoom.getEnemies().isEmpty()) {
            enemy = currentRoom.getEnemies().get(0);
        }

        if (equippedWeapon == null) {
            return new AttackOutcome(AttackResult.NO_WEAPON, null, enemy);
        }

        if (!equippedWeapon.canUse()) {
            return new AttackOutcome(AttackResult.WEAPON_EMPTY, null, enemy);
        }

        equippedWeapon.use();

        // Attacks empty air when no enemy is present:
        if (enemy == null) {
            return new AttackOutcome(AttackResult.EMPTY_AIR, null, null);
        }

        boolean enemyDied = enemy.hit(equippedWeapon.getDamage());

        if (enemyDied) {
            return new AttackOutcome(AttackResult.ENEMY_DIED, null, enemy);
        }

        return new AttackOutcome(AttackResult.ENEMY_HIT, null, enemy);
    }
}