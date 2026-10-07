public abstract class Weapon extends Item {

private int damage;

public Weapon(String weaponName, String weaponDescription, int damage) {
    super(weaponName, weaponDescription);
    this.damage = damage;
}

public int getDamage() {
    return damage;
}

public abstract boolean canUse();

public abstract void use();

public abstract String getAttackVerb();

public abstract String getUsesLeftText();

}