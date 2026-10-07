import java.util.ArrayList;

public class Adventure {
//game data:
    private final Map map;
    private final Player player;
//constructor - creates map and player:
    public Adventure() {
        map = new Map();
        player = new Player(map.getStartRoom());
    }
    //starts user interface
    public void startGame() {
        UserInterface ui = new UserInterface(this);
        ui.startProgram();
    }
//gets players current room
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
//passes movement request to player
    public boolean go(String direction) {
        return player.move(direction);
    }
//passes item action to player
    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }
    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }
//passes food action to player
    public EatOutcome eat(String foodName) {
        return player.eat(foodName);
    }
    //gets current room description:
    public String look() {
        return player.getCurrentRoom().getDescription();
    }
    //passes weapon equip action to player
    public EquipResult equip(String weaponName) {
        return player.equip(weaponName);
    }

    // Coordinates player attack and enemy counterattack:
    public AttackOutcome attack(String enemyName) {

        AttackOutcome outcome = player.attack(enemyName);

        if (outcome.getPlayerAttackResult() == AttackResult.ENEMY_HIT) {
            Enemy enemy = outcome.getEnemy();
            AttackResult enemyAttackResult = enemy.attack(player);

            return new AttackOutcome(outcome.getPlayerAttackResult(), enemyAttackResult, enemy);
        }
        return outcome;
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