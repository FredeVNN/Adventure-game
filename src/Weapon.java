public abstract class Weapon extends Item {
//weapon damage
private final int damage;
//constructor
public Weapon(String weaponName, String weaponDescription, int damage) {
    super(weaponName, weaponDescription);
    this.damage = damage;
}
//gets weapon damage
public int getDamage() {
    return damage;
}
//checks if weapon can be used
public abstract boolean canUse();
//uses weapon
public abstract void use();
//gets attack verb
public abstract String getAttackVerb();
//gets remaining uses
public abstract String getUsesLeftText();
}