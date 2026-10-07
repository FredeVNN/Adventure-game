public class Food extends Item {
    //health change:
    private final int healthPoints;
    //constructor
    public Food(String itemName, String itemDescription, int healthPoints) {
        super(itemName, itemDescription);
        this.healthPoints = healthPoints;
    }
    //gets health points
    public int getHealthPoints() {
        return healthPoints;
    }
}