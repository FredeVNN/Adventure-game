public class RangedWeapon extends Weapon{
//remaining ammunition
    private int ammunition;
//constructor
    public RangedWeapon(String weaponName, String weaponDescription, int damage, int ammunition) {
        super(weaponName, weaponDescription, damage);
        this.ammunition = ammunition;
    }
//checks ammunition
    @Override
    public boolean canUse() {
        return ammunition > 0;
    }
//uses ammunition
    @Override
    public void use() {
        ammunition--;
    }
    //tells attack verb
    @Override
    public String getAttackVerb() {
        return "fire";
    }
    //gets remaining ammunition
    @Override
    public String getUsesLeftText() {
        return ammunition + " uses left.";
    }
}