import java.util.ArrayList;

public class Adventure {
//game data:
    private final Map map;
    private final Player player;
//constructor:
    public Adventure() {
        map = new Map();
        player = new Player(map.getStartRoom());
    }
    //starts user interface
    public void startGame() {
        UserInterface ui = new UserInterface(this);
        ui.startProgram();
    }
//gets current room
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
//moves player
    public boolean go(String direction) {
        return player.move(direction);
    }
//takes item
    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }
//drops item
    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }
//eats food
    public EatOutcome eat(String foodName) {
        return player.eat(foodName);
    }
//equips weapon
    public EquipResult equip(String weaponName) {
        return player.equip(weaponName);
    }
//player attacks enemy
    public AttackResult attack(Enemy enemy) {
        return player.attack(enemy);
    }
//enemy attacks player
    public AttackResult enemyAttack(Enemy enemy) {
        return enemy.attack(player);
    }
//gets players health
    public int getHealth() {
        return player.getHealth();
    }
//checks if player is alive
    public boolean isPlayerAlive() {
        return player.isAlive();
    }
//gets player inventory
    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }
//gets equipped weapon
    public Weapon getEquippedWeapon() {
        return player.getEquippedWeapon();
    }
}