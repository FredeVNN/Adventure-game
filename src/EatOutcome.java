public class EatOutcome {

    // Constructor:
    private final EatResult result;
    private final String itemName;
    private final int healthChange;

    public EatOutcome(EatResult result, String itemName, int healthChange) {
        this.result = result;
        this.itemName = itemName;
        this.healthChange = healthChange;
    }
}