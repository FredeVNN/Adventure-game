public class Enemy {
    //enemy information
    private final String shortName;
    private final String longName;
    private final String description;
    private int health;

    //enemy weapon and room
    private final Weapon weapon;
    private final Room room;

    //constructor
    public Enemy (String shortname, String longName, String description, int health, Weapon weapon, Room room) {
        this.shortName = shortname;
        this.longName = longName;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
        this.room = room;
    }
    //gets enemy information
    public String getShortName() {
        return shortName;
    }
    public String getLongName() {
        return longName;
    }
    public String getDescription() {
        return description;
    }
    public int getHealth() {
        return health;
    }
    public Weapon getWeapon() {
        return weapon;
    }

    //Enemy attacks player
    public AttackResult attack(Player player) {
        if (!weapon.canUse()) {
            return AttackResult.WEAPON_EMPTY;
        }
        weapon.use();

        boolean playerDied = player.hit(weapon.getDamage());

        if (playerDied) {
            return AttackResult.PLAYER_DIED;
        }
        return AttackResult.PLAYER_HIT;
    }
    //applies damage to enemy
    public boolean hit(int damage) {
        health = health - damage;

        if (health <= 0) {
            health = 0;
            //Enemy drops weapon
            room.addItem(weapon);

            //Enemy remove itself from room
            room.removeEnemy(this);
            return true;
        }
        return false;
    }
}
