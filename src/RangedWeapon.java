public class RangedWeapon extends Weapon{

    private int ammunition;

    public RangedWeapon(String weaponName, String weaponDescription, int damage, int ammunition) {
        super(weaponName, weaponDescription, damage);
        this.ammunition = ammunition;
    }

    @Override
    public boolean canUse() {
        return ammunition > 0;
    }

    @Override
    public void use() {
        ammunition--;
    }
    @Override
    public String getAttackVerb() {
        return "fire";
    }
    @Override
    public String getUsesLeftText() {
        return ammunition + " uses left.";
    }
}