import java.util.ArrayList;

public class Item {

    private String itemName;
    private String itemDescription;

    // Constructor:
    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    // Getters:
    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}