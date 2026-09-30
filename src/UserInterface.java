import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    // Prints welcome message:
    public void welcome() {
        System.out.println("WELCOME TO\n");
        System.out.println("────────────────────────────⟪ TIME MAZE ⟫────────────────────────────\n");
        System.out.println("It is the year 4,000 BC. You are a caveman out hunting when suddenly—\n" + ">>>CRACK<<<\n" + "The ground disappears beneath your feet, and you fall into darkness.\n");
        System.out.println("You find yourself deep inside a massive underground cave!\n" + "In front of you lies a strange compass. You pick it up. The needle spins wildly!\n");
        System.out.println("You search for a way out. But the endless tunnels only lead you deeper into the unknown.\n" + "Then you hear a strange humming sound.\n" + "You follow it and discover something impossible...\n");
        System.out.println("WHAT WILL YOU DO?\n");
        System.out.println("\t• Type [start] to begin your journey  •  Type [exit] to leave the maze  •\n");    }

    public void rooms(Room room) {

        // Room number and name:
        System.out.println("\n[ " + room.getRoomNum() + " ]" + "\t\t>> " + room.getName() + " <<");
        System.out.println("─".repeat(room.getRoomNum().length() + room.getName().length() + 15));

        // Discover room:
        if (!room.isDiscoveredRoom()) {

            // Room description and items:
            System.out.println(room.getDescription());
            if (!room.getItems().isEmpty()) {
                System.out.println("In here you find:");
                for (Item item : room.getItems()) {
                    System.out.println("\n\t > " + item.getItemName() + " (" + item.getItemDescription() + ")");
                }
            }
            room.setDiscoveredRoom(true);
        }
        System.out.println("\n\t• Type [n] to move North  •  Type [e] to move East  •  Type [s] to move South  •  Type [w] to move West •");    }

    // Handles commands:
    public void handleCommand(Player player) {
        String command = scanner.nextLine().toLowerCase();

        // Splits the input into command and item name:
        String[] parts = command.split(" ", 2);

        // Stores the command:
        command = parts[0];

        // Stores the item name:
        String itemName = parts.length > 1 ? parts[1] : "";

        // Available commands:
        switch (command) {
            case "start" -> rooms(player.getCurrentRoom());
            case "n", "e", "s", "w" -> moveDirection(player, command);
            case "take" -> takeItem(player, itemName);
            case "drop" -> dropItem(player, itemName);
            case "eat" -> eatFood(player, itemName);
            case "health" -> showHealth(player);
            case "i" -> showInventory(player);
            case "help" -> showHelp();
            case "exit" -> {
                System.out.println("See you next time!");
                System.exit(0);
            }
            default -> System.out.println(
                    "\nHmm... that doesn't seem to work here!" + "\n\ndsa<x\t• Type [help] to see what you can do •\n"
            );
        }
    }

    // Shows direction moved:
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
            System.out.println("\nWHOOSH! The portal sends you straight back. Try another path!");        }
    }

    // Eat item:
    public void eatFood(Player player, String foodName) {
        Room currentRoom = player.getCurrentRoom();

        Item item = currentRoom.findItemByName(foodName);
        Food food = null;

        if(item instanceof Food) {
            food = (Food) item;
        }

        if (food != null) {
            currentRoom.removeItem(food);
            player.addToInventory(food);
            player.health = player.health + food.getHealthPoints();

            System.out.println("You ate the " + food.getItemName() + "." + " Now your health is: " + player.health);
        } else {
            System.out.println("You cant eat the  " + item.getItemName() + ".");
        }
    }

    public void showHealth(Player player) {
        System.out.println("Your healthpoints are: " + player.health);
    }

    // Take item:
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

    // Drops an item from the inventory into the current room:
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

    // Shows inventory:
    public void showInventory(Player player) {
        System.out.println("\n⟨ INVENTORY ⟩");
        System.out.println("─────────────");

        if (player.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty. Explore the maze, find useful items, and take them with you.");
            return;
        }
        for (Item item : player.getInventory()) {
            System.out.println("+ " + item.getItemName());
        }
    }

    // Show help - list of commands:
    public void showHelp() {
        System.out.println("\nAVAILEBLE COMMANDS");
        System.out.println("───────────────────");
        System.out.println("➤ start         Start the game");
        System.out.println("➤ n             Move north");
        System.out.println("➤ e             Move east");
        System.out.println("➤ s             Move south");
        System.out.println("➤ w             Move west");
        System.out.println("➤ take 'item'   Add item to your inventory");
        System.out.println("➤ drop 'item'   Remove item from your inventory");
        System.out.println("➤ eat  'item'   Adds or removes health");
        System.out.println("➤ i             See your inventory");
        System.out.println("➤ exit          Close the game\n");
    }
}