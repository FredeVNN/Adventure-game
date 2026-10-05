public class BowAndArrow extends Weapon{

        private int ammunition;

        public BowAndArrow(String weaponName, String weaponDescription, int damage, int ammunition) {
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
}

