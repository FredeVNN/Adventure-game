public class MeleeWeapon extends Weapon{
    //constructor
    public MeleeWeapon(String weaponName, String weaponDescription, int damage) {
        super(weaponName, weaponDescription, damage);
    }
//melee weapons have unlimited use
    @Override
    public boolean canUse() {
        return true;
    }
//melee weapon uses no ammunition therefore empty
    @Override
    public void use() {
    }
    //tells attack verb
    @Override public String getAttackVerb() {
        return "swing";
    }
    //melee weapons has no limited use
    @Override public String getUsesLeftText() {
        return "";
    }
}
