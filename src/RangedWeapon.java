public class RangedWeapon extends Weapon{
//remaining ammunition
    private int ammunition;
//constructor
    public RangedWeapon(String weaponName, String weaponDescription, int damage, int ammunition) {
        super(weaponName, weaponDescription, damage);
        this.ammunition = ammunition;
    }
//checks if ammunition remains
    @Override
    public boolean canUse() {
        return ammunition > 0;
    }
//uses 1 ammunition per use
    @Override
    public void use() {
        ammunition--;
    }
    //tells attack verb
    @Override
    public String getAttackVerb() {
        return "fire";
    }
    //returns remaining ammunition as text.
    @Override
    public String getUsesLeftText() {
        return ammunition + " uses left.";
    }
}