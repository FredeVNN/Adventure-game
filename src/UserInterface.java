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
                + "\t* Type: ‘start’ to continue or 'exit' to close the game *\n"
                + "\t* Type: 'help' to see available commands");

    }

    public void rooms(Room room) {
        System.out.println("\n[ " + room.getRoomNum() + " ]" + "\t\t>> " + room.getName() + " <<");
        System.out.println("─".repeat(room.getRoomNum().length() + room.getName().length() + 15));
        System.out.println(room.getDescription());
        if (!room.getItems().isEmpty()) {
            System.out.println("Items: ");

            for (Item item : room.getItems()) {
                System.out.println("- " + item.getItemDescription());
            }
        }
    }

    //Handles commands
    public void handleCommand(Player player) {
        System.out.println("\n\t* Type: 'n' to move north - 'e' to move east - 's' to move south - 'w' to move west");
        String command = scanner.nextLine().toLowerCase();
        //available commands
        switch (command) {
            case "start" -> rooms(player.getCurrentRoom());
            case "n", "e", "s", "w" -> moveDirection(player, command);
            case "inventory" -> showInventory(player);
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
        }
        else {
            System.out.println("You cannot go that way! Choose another path.");
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

    //Showhelp - list of commands
    public void showHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("- start       Start the game");
        System.out.println("- n           Move north");
        System.out.println("- e           Move east");
        System.out.println("- s           Move south");
        System.out.println("- w           Move west");
        System.out.println("- inventory   See your inventory");
        System.out.println("- help        Show all commands");
        System.out.println("- exit        Close the game");
    }
}

