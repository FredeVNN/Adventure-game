public class EatOutcome {

    //stores result data returned by Player eat method
    private final EatResult result;
    private final String itemName;
    private final int healthChange;

    //constructor
    public EatOutcome(EatResult result, String itemName, int healthChange) {
        this.result = result;
        this.itemName = itemName;
        this.healthChange = healthChange;
    }
    //gets eat result
    public EatResult getResult() {
        return result;
    }
    //gets item name
    public String getItemName() {
        return itemName;
    }
    //gets health change
    public int getHealthChange() {
        return healthChange;
    }
}