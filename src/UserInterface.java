import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    //prints welcome message
    public void welcome() {
        System.out.println("\t\t\t\t  Welcome to\n" + "\t\t\t\t───────────────\n" + "\t\t\t\t>> TIME MAZE <<\n" + "\t\t\t\t───────────────");
        System.out.println("\nIt is the year 4,000 BC. You are a caveman out hunting when suddenly—\n"
                + ">>>CRACK<<<\n"
                + "The ground disappears beneath your feet, and you fall into darkness.\n"
                + "You find yourself deep inside a massive underground cave. \n"
                + "In front of you lies a strange compass. You pick it up. The needle spins wildly.\n"
                + "You search for a way out, but the endless tunnels only lead you deeper into the unknown.\n"
                + "Then you hear a strange humming sound.\n"
                + "You follow it and discover something impossible - \n\n"
                + "\t* (Type ‘start’ to continue) or (Type 'exit' to close the game) *\n");
    }

    public void rooms(Room room) {
        // Room number and name:
        System.out.println("\n[ " + room.getRoomNum() + " ]" + "\t\t>> " + room.getName() + " <<");
        System.out.println("─".repeat(room.getRoomNum().length() + room.getName().length() + 15));

        // Discover room:
        if (!room.isDiscoveredRoom()) {

            // Room description and items:
            System.out.println(room.getDescription());
            if (!room.getItems().isEmpty()) {
                System.out.println("Here you find");
                for (Item item : room.getItems()) {
                    System.out.println(" + " + item.getItemName() + " (" + item.getItemDescription() + ")");
                }
            }
            room.setDiscoveredRoom(true);
        }
        System.out.println("\n\t* (Type 'n' to move north - 'e' to move east - 's' to move south - 'w' to move west) *");
        System.out.println("\t\t\t\t\t\t* (Type 'help' to see available commands) *");
    }

    //Handles commands
    public void handleCommand(Player player) {
        String command = scanner.nextLine().toLowerCase();
// Splits the input into command and item name
        String[] parts = command.split(" ", 2);

        // Stores the command
        command = parts[0];

        // Stores the item name
        String itemName = parts.length > 1 ? parts[1] : "";

        //available commands
        switch (command) {
            case "start" -> rooms(player.getCurrentRoom());
            case "n", "e", "s", "w" -> moveDirection(player, command);
            case "take" -> takeItem(player, itemName);
            case "drop" -> dropItem(player, itemName);
            case "i" -> showInventory(player);
            case "help" -> showHelp();
            case "exit" -> {
                System.out.println("See you next time!");
                System.exit(0);
            }
            default -> System.out.println("\t* Please enter a valid input! or (Type 'help' to see all commands) *");
        }
    }

    //shows direction moved
    public void moveDirection(Player player, String direction) {

        boolean moving = player.move(direction);

        if (moving) {
            Room currentRoom = player.getCurrentRoom();
            rooms(currentRoom);

            if (currentRoom.getRoomNum().equals("ROOM 05")) {
                System.out.println("\nCongratulations!");
                System.out.println("You reached the final room.");
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        } else {
            System.out.println("You cannot go that way! Choose another path.");
        }
    }

    //Take item:
    public void takeItem(Player player, String itemName) {

        Room currentRoom = player.getCurrentRoom();

        Item item = currentRoom.findItemByName(itemName);

        if (item != null) {
            currentRoom.removeItem(item);
            player.addToInventory(item);

            System.out.println("You picked up the " + item.getItemName() + ".");
        } else {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    // Drops an item from the inventory into the current room
    public void dropItem(Player player, String itemName) {

        Room currentRoom = player.getCurrentRoom();

        Item item = null;

        for (Item inventoryItem : player.getInventory()) {
            if (inventoryItem.getItemName().equalsIgnoreCase(itemName)) {
                item = inventoryItem;
                break;
            }
        }

        if (item != null) {
            player.removeFromInventory(item);
            currentRoom.addItem(item);
            System.out.println("You dropped the " + item.getItemName() + ".");
        } else {
            System.out.println("You don't have " + itemName + " in your inventory.");
        }
    }

    //Shows inventory
    public void showInventory(Player player) {
        System.out.println("Inventory:");

        if (player.getInventory().isEmpty()) {
            System.out.println("- empty");
            return;
        }
        for (Item item : player.getInventory()) {
            System.out.println("- " + item.getItemName());
        }
    }

    //Show help - list of commands
    public void showHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("- start       Start the game");
        System.out.println("- n           Move north");
        System.out.println("- e           Move east");
        System.out.println("- s           Move south");
        System.out.println("- w           Move west");
        System.out.println("- i           See your inventory");
        System.out.println("- help        Show all commands");
        System.out.println("- exit        Close the game");
    }
}

