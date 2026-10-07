import java.util.ArrayList;

public class Adventure {

    private final Map map;
    private final Player player;

    public Adventure() {
        map = new Map();
        player = new Player(map.getStartRoom());
    }
    public void startGame() {
        UserInterface ui = new UserInterface(this);
        ui.startProgram();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean go(String direction) {
        return player.move(direction);
    }

    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public EatOutcome eat(String foodName) {
        return player.eat(foodName);
    }

    public EquipResult equip(String weaponName) {
        return player.equip(weaponName);
    }

    public AttackResult attack(Enemy enemy) {
        return player.attack(enemy);
    }

    public AttackResult enemyAttack(Enemy enemy) {
        return enemy.attack(player);
    }

    public int getHealth() {
        return player.getHealth();
    }

    public boolean isPlayerAlive() {
        return player.isAlive();
    }

    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public Weapon getEquippedWeapon() {
        return player.getEquippedWeapon();
    }
}