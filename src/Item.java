
public class Item {
//item information
    private String itemName;
    private String itemDescription;

    // Constructor:
    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    // Gets item name:
    public String getItemName() {
        return itemName;
    }
    //gets item description
    public String getItemDescription() {
        return itemDescription;
    }
}