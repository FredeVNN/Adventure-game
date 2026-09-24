import java.util.Scanner;

public class UserInterface {

    private Adventure adventure;
    //private static Scanner scanner;

    public UserInterface() {
        this.adventure = adventure;
    }

    static void start() {

        System.out.println(
                "\t\t\t\t  Welcome to\n" +
                        "\t\t\t\t───────────────\n" +
                        "\t\t\t\t>> TIME MAZE <<\n" +
                        "\t\t\t\t───────────────");

        System.out.println(
                "\nIt is the year 4,000 BC. You are a caveman out hunting when suddenly—\n"
                        + "CRACK!\n"
                        + "The ground disappears beneath your feet, and you fall into darkness.\n"
                        + "You find yourself deep inside a massive underground cave. \n"
                        + "In front of you lies a strange compass. You pick it up. The needle spins wildly.\n"
                        + "You search for a way out, but the endless tunnels only lead you deeper into the unknown.\n"
                        + "Then you hear a strange humming sound.\n"
                        + "You follow it and discover something impossible - \n\n"
                        + "\t* (Type ‘start’ to continue) or (Type 'exit' to close the game) *\n");

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().trim().toLowerCase();

        command = scanner.nextLine().trim().toLowerCase();

        do {
            System.out.println("\tPlease enter a valid input!\n\t* (Type ‘start’ to continue) or (Type 'exit' to close the game) *");
            command = scanner.nextLine().trim().toLowerCase();
        }
        while (!command.equals("start") && !command.equals("exit"));
        //System.out.println(command);

        if (command.equals("start")) {
            Player.currentRoom();

        } else if (command.equals("exit")) {
            System.out.println("Goodbye!");

        }
    }

    //input
    //Get name+description room
    public static void printRoom1Title() {
        printRoomTitle("01", "THE DARK CAVE");
    }

    public static void printRoom1Description() {
        printRoomDescription("You find yourself deep inside a massive underground cave, dark and cold.\n" +
                "Ahead, you can see mysterious portals glowing in the darkness, each leading to an unknown time.");
    }

    public static void printRoom2Title() {
        printRoomTitle("02", "THE SUNKEN ATLANTIS");
    }

    public static void printRoom2Description() {
        printRoomDescription("You suddenly find yourself beneath the ocean, surrounded by the ruins of Atlantis. You can’t breathe!\n" +
                "Through the murky water, you spot ancient portals shimmering above the sunken city.");
    }

    public static void printRoom3Title() {
        printRoomTitle("03", "THE FROZEN WASTELAND");
    }

    public static void printRoom3Description() {
        printRoomDescription("You end up in a frozen wasteland, surrounded by endless snow and towering walls of ice.\n" +
                "In the distance, you notice icy gateways rising from the snow, glowing beneath the pale sky.");
    }

    public static void printRoom4Title() {
        printRoomTitle("04", "THE ANCIENT PYRAMIDS");
    }

    public static void printRoom4Description() {
        printRoomDescription("You emerge inside an ancient pyramid, surrounded by hieroglyphs, statues and flickering torches.\n" +
                "Between the ancient walls, you discover golden portals covered in mysterious Egyptian symbols.");
    }

    public static void printRoom5Title() {
        printRoomTitle("05", "THE SPACE STATION");
    }

    public static void printRoom5Description() {
        printRoomDescription("You suddenly appear aboard a massive space station, floating silently above an unknown planet.\n" +
                "Across the control room, you notice futuristic gateways flickering with strange colours and digital patterns.");
    }

    public static void printRoom6Title() {
        printRoomTitle("06", "THE JUNGLE TEMPLE");
    }

    public static void printRoom6Description() {
        printRoomDescription("You stumble into a forgotten temple, hidden deep within a wild jungle of vines and ancient ruins.\n" +
                "Beyond the temple pillars, you spot glowing gateways surrounded by strange carvings and symbols.");
    }

    public static void printRoom7Title() {
        printRoomTitle("07", "THE JURASSIC WORLD");
    }

    public static void printRoom7Description() {
        printRoomDescription("You step into a prehistoric jungle, where towering trees surround you and dinosaurs roar in the distance.\n" +
                "Through the thick jungle, you catch sight of shimmering gateways among the ferns.");
    }

    public static void printRoom8Title() {
        printRoomTitle("08", "THE ENCHANTED FOREST");
    }

    public static void printRoom8Description() {
        printRoomDescription("You wander into an enchanted forest, where glowing plants and strange creatures surround you.\n" +
                "Between the glowing trees, you discover magical gateways floating among sparkling lights and twisting vines.");
    }

    public static void printRoom9Title() {
        printRoomTitle("09", "THE CYBER CITY");

    }

    public static void printRoom9Description() {
        printRoomDescription("You arrive in a futuristic city, surrounded by neon lights, towering skyscrapers and flying vehicles.\n" +
                "Above the crowded streets, you spot holographic gateways pulsing with different electric colours.");
    }

    private static void printRoomTitle(String roomNumber, String roomName) {

        System.out.println("\n[ ROOM " + roomNumber + " ] >> " + roomName + " <<");
        System.out.println("─".repeat((roomName.length()) + (roomNumber.length()) + 16));
    }

    private static void printRoomDescription(String roomDescription) {
        System.out.println("> " + roomDescription);
    }
}