public class PharaohsSword extends Weapon{

    public PharaohsSword(String weaponName, String weaponDescription, int damage) {
        super(weaponName, weaponDescription, damage);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void use() {

    }
}
