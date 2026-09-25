import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void welcome(Player player) {
        System.out.println("\t\t\t\t  Welcome to\n" +
                "\t\t\t\t───────────────\n" +
                "\t\t\t\t>> TIME MAZE <<\n" +
                "\t\t\t\t───────────────");
        System.out.println("\nIt is the year 4,000 BC. You are a caveman out hunting when suddenly—\n"
                + "CRACK!\n"
                + "The ground disappears beneath your feet, and you fall into darkness.\n"
                + "You find yourself deep inside a massive underground cave. \n"
                + "In front of you lies a strange compass. You pick it up. The needle spins wildly.\n"
                + "You search for a way out, but the endless tunnels only lead you deeper into the unknown.\n"
                + "Then you hear a strange humming sound.\n"
                + "You follow it and discover something impossible - \n\n"
                + "\t* (Type ‘start’ to continue) or (Type 'exit' to close the game) *\n");

        String userImput = chooseCommand(this.commands);

        if (userImput.equalsIgnoreCase("exit")) {
            System.out.println("See you next time!");
            System.exit(0);
        } else if (userImput.equalsIgnoreCase("start")) {
            rooms(player.getCurrentRoom());
        }
    }

    public void rooms(Room room) {
        System.out.print("[" + room.getName() + "]  ");
        System.out.println(">>> " + room.getDescription() + " <<<");
    }
    public void moveDirection (Player player){
        System.out.println("Type 'n' to move north - Type 'e' to move east - Type 's' to move south - Type 'w' to move west");
        String direction = scanner.nextLine();

        boolean moving = player.move(direction);

        if(moving){
            rooms(player.getCurrentRoom());
        } else {
            System.out.println("You cannot go that way! Choose another path..");
        }
    }

    public String[] commands = {"start", "exit", "help"};

    private String chooseCommand(String[] commands) {
        while (true) {
            String command = scanner.nextLine();
            for (int i = 0; i < commands.length; i++) {
                if (commands[i].equalsIgnoreCase(command)) {
                    return commands[i];
                }
            }
            System.out.println("\tPlease enter a valid input!\n\t Type 'help' to see all commands");
        }
    }
}