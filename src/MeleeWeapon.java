public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String weaponName, String weaponDescription, int damage) {
        super(weaponName, weaponDescription, damage);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void use() {
    }
    @Override public String getAttackVerb() {
        return "swing";
    }
    @Override public String getUsesLeftText() {
        return "";
    }
}
