import java.util.Scanner;


public class UserInterface {
    //reads user input
    private final Scanner scanner;
    //sends game commands to controller (adventure class)
    private Adventure adventure;


    //constructor
    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
        this.scanner = new Scanner(System.in);
    }


    //starts command loop
    public void startProgram() {
        welcome();


        while (true) {
            handleCommand();
        }
    }


    // Prints welcome message:
    private void welcome() {
        System.out.println("WELCOME TO");
        System.out.println("\u001B[1m\u001B[94m");
        System.out.println("████████╗██╗███╗   ███╗███████╗   ███╗   ███╗ █████╗ ███████╗███████╗");
        System.out.println("╚══██╔══╝██║████╗ ████║██╔════╝   ████╗ ████║██╔══██╗╚══███╔╝██╔════╝");
        System.out.println("   ██║   ██║██╔████╔██║█████╗     ██╔████╔██║███████║  ███╔╝ █████╗");
        System.out.println("   ██║   ██║██║╚██╔╝██║██╔══╝     ██║╚██╔╝██║██╔══██║ ███╔╝  ██╔══╝");
        System.out.println("   ██║   ██║██║ ╚═╝ ██║███████╗   ██║ ╚═╝ ██║██║  ██║███████╗███████╗");
        System.out.println("\u001B[0m");
        System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");


        System.out.println(
                "It is the year 4,000 BC. It is just another normal day, and you are out hunting for food for your clan.\n" +
                        "You spot your prey and carefully make your way through the wilderness.\nEverything seems peaceful..." + "\u001B[3mThen suddenly—\u001B[0m\n\n" +
                        "⟩❭› CRACK ‹❬⟨" +
                        "\n\nThe ground disappears beneath your feet, and you fall into darkness. Everything goes black...\n" +
                        "When you open your eyes again, you are somewhere completely unfamiliar.\n\nYou find yourself deep inside a massive underground cave!\n" +
                        "In front of you lies a strange compass. You pick it up. The needle spins wildly!\n" + "You search for a way out. But the endless tunnels only lead you deeper into the unknown.\n\n" +
                        "Then you hear a strange humming sound. You follow it and discover something impossible...\n\n" + "\u001B[3mWHAT WILL YOU DO?\u001B[0m");
        System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
        System.out.println("\u001B[36m\t• Type [start] to begin your journey  •  Type [exit] to leave the maze  •\u001B[0m\n");


    }


    // shows room:
    private void rooms(Room room) {
        System.out.println("\n[ " + room.getRoomNum() + " ]\t\u001B[1m" + room.getName() + "\u001B[0m");
        System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
        if (!room.isDiscoveredRoom()) {


            // Room description and items:
            System.out.println(room.getDescription());
            room.setDiscoveredRoom(true);
        } else {
            System.out.println("You return to " + room.getName());
        }
        showItems(room);
        showEnemies(room);


        System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
        System.out.println("\u001B[36m\n\t• " + room.getGuide() + " •\u001B[0m");
        System.out.println("\u001B[36m\t• Type [n] to move North  •  Type [e] to move East  •  Type [s] to move South  •  Type [w] to move West •\u001B[0m\n");
    }


    // reads and handles commands:
    private void handleCommand() {
        String command = scanner.nextLine().toLowerCase();


        if (command.startsWith("go ")) {
            command = command.substring(3);
        }


        if (command.contains("mammoth") || command.contains("falcon") || command.contains("monkey")) {


            switch (command) {
                case "mammoth, falcon, monkey", "mammoth, monkey, falcon" -> {
                    System.out.println("\n\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
                    System.out.println("The engines roar to life, and the space station begins to shake.\n" +
                            "A bright flash fills the room as the ship tears through time and space.\n" +
                            "When the light fades, you find yourself back in your own timeline.\n" +
                            "You return to your clan, but nobody believes the incredible journey you have just been through.\n" +
                            "To them, you were only gone for a short while, but you know you have travelled through time, explored strange worlds and escaped the Time Maze.\n" +
                            "You made it home!");
                    System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
                    System.out.println("\u001B[1m\u001B[92m");
                    System.out.println("██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗ ██████╗ ███╗   ██╗");
                    System.out.println("╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██╔═══██╗████╗  ██║");
                    System.out.println(" ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║   ██║██╔██╗ ██║");
                    System.out.println("  ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║   ██║██║╚██╗██║");
                    System.out.println("   ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝╚██████╔╝██║ ╚████║");
                    System.out.println("\u001B[0m");
                    System.out.println("\n\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
                    System.out.println(
                            "\n\t\t\t\t\t\t\t\t\t\t\t\tThank you for playing!" +
                                    "\n\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t\tGAME DEVELOPERS\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t  Lærke Wendel Søgaard-Jensen\n" +
                                    "\t\t\t\t\t\t\t\t\t\t   Frederik Valdemar Nordahl Nielsen\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\tAjla Moco\n");
                    System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
                    System.exit(0);
                }
                case "falcon, monkey, mammoth", "falcon, mammoth, monkey" -> {
                    System.out.println("\n\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
                    System.out.println("The ship powers up, but something feels wrong.\n" +
                            "The screens flicker, and the space station begins to spin out of control.\n" +
                            "Maybe the animals were supposed to be entered in a different order to escape the maze?\n" +
                            "Before you can figure it out, the alarms grow louder, and suddenly, everything goes black.\n" +
                            "When you open your eyes, you find yourself back at the beginning of the Time Maze.\n" +
                            "Your journey starts all over again…");
                    System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
                    System.out.println("\u001B[1m\u001B[93m");
                    System.out.println("███████╗████████╗ █████╗ ██████╗ ████████╗    ██████╗ ██╗   ██╗███████╗██████╗");
                    System.out.println("██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝   ██╔═══██╗██║   ██║██╔════╝██╔══██╗");
                    System.out.println("███████╗   ██║   ███████║██████╔╝   ██║      ██║   ██║██║   ██║█████╗  ██████╔╝");
                    System.out.println("╚════██║   ██║   ██╔══██║██╔══██╗   ██║      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗");
                    System.out.println("███████║   ██║   ██║  ██║██║  ██║   ██║      ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║");
                    System.out.println("\u001B[0m");
                    this.adventure = new Adventure();
                    rooms(adventure.getCurrentRoom());
                }
                case "monkey, mammoth, falcon", "monkey, falcon, mammoth" -> {
                    System.out.println("\n\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
                    System.out.println("You enter the code, and the control panel begins to flash red.\n" +
                            "A loud alarm echoes through the space station as the engines overheat.\n" +
                            "Before you can react, the ship explodes in a blinding flash.\n" +
                            "Your journey through time has come to a fatal end.");
                    System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
                    System.out.println("\u001B[1m\u001B[91m");
                    System.out.println(" ██████╗  █████╗ ███╗   ███╗███████╗    ██████╗ ██╗   ██╗███████╗██████╗");
                    System.out.println("██╔════╝ ██╔══██╗████╗ ████║██╔════╝   ██╔═══██╗██║   ██║██╔════╝██╔══██╗");
                    System.out.println("██║  ███╗███████║██╔████╔██║█████╗     ██║   ██║██║   ██║█████╗  ██████╔╝");
                    System.out.println("██║   ██║██╔══██║██║╚██╔╝██║██╔══╝     ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗");
                    System.out.println("╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗   ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║");
                    System.out.println("\u001B[0m");
                    System.out.println("\n\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
                    System.out.println(
                            "\n\t\t\t\t\t\t\t\t\t\t\t\tThank you for playing!" +
                                    "\n\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t\tGAME DEVELOPERS\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t  Lærke Wendel Søgaard-Jensen\n" +
                                    "\t\t\t\t\t\t\t\t\t\t   Frederik Valdemar Nordahl Nielsen\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\tAjla Moco\n");
                    System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
                    System.exit(0);
                }
                default -> System.out.println("\nYou entered the animals, but the order or format seems wrong. Try again like: falcon, monkey, mammoth");
            }
            return;
        }


        // Splits the input into command and item name:
        String[] parts = command.split(" ", 2);


        command = parts[0];


        String itemName = parts.length > 1 ? parts[1] : "";


        // Available commands:
        switch (command) {
            case "start" -> rooms(adventure.getCurrentRoom());
            case "n", "north", "go north", "e", "east", "go east", "s", "south", "go south", "w", "west", "go west" ->
                    moveDirection(command);
            case "look" -> lookAround();
            case "take" -> takeItem(itemName);
            case "drop" -> dropItem(itemName);
            case "eat" -> eatFood(itemName);
            case "attack" -> attack(itemName);
            case "equip" -> equipWeapon(itemName);
            case "health" -> showHealth();
            case "i", "inventory" -> showInventory();
            case "help" -> showHelp();
            case "exit" -> {
                System.out.println("\n\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
                System.out.println(
                        "\n\t\t\t\t\t\t\t\t\t\t\t\tThank you for playing!\n" +
                                "\t\t\t\t\t\t\t\t\u001B[3mUntil next time, time traveler... The maze will be waiting.\u001B[0m" +
                                "\n\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t\t\tGAME DEVELOPERS\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t  Lærke Wendel Søgaard-Jensen\n" +
                                "\t\t\t\t\t\t\t\t\t\t   Frederik Valdemar Nordahl Nielsen\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tAjla Moco\n");
                System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
                System.exit(0);
            }
            default -> System.out.println(
                    "\u001B[3m\nHmm... that doesn't seem to work here!\u001B[0m" + "\n\n\u001B[36m\t• Type [help] to see what you can do •\u001B[0m\n");
        }
    }


    // Info for player moves:
    private void moveDirection(String direction) {


        boolean moving = adventure.go(direction);


        if (moving) {
            Room currentRoom = adventure.getCurrentRoom();
            rooms(currentRoom);
        } else {
            System.out.println("\u001B[1m\u001B[35m\nWHOOSH! The portal sends you straight back. Try another path!\u001B[0m\n");
        }
    }


    // Eat food:
    private void eatFood(String foodName) {
        EatOutcome outcome = adventure.eat(foodName);


        switch (outcome.getResult()) {
            case NOT_FOUND ->
                    System.out.println("\nThere is nothing like '" + outcome.getItemName() + "' to eat around here.\n");
            case NOT_FOOD -> System.out.println("\nYou cannot eat the " + outcome.getItemName() + "\n");
            case EATEN -> {
                System.out.println("\nYou ate the " + outcome.getItemName() + "\n");
                if (outcome.getHealthChange() > 0) {
                    System.out.println("\nYou feel better.\n");
                } else if (outcome.getHealthChange() < 0) {
                    System.out.println("\nThat was a mistake\n");
                }
                System.out.println("\nYour health is now: " + adventure.getHealth() + "\n");


                if (!adventure.isPlayerAlive()) {
                    System.out.println("\nThe food was deadly. You died. Game over.\n");
                    System.exit(0);
                }
            }
        }
    }


    // shows players health:
    private void showHealth() {
        System.out.print("\nHEALTHPOINTS: ");


        int h = adventure.getHealth();


        if (h >= 100) {
            System.out.println(adventure.getHealth() +" [ \u001B[31m♥ ♥ ♥ ♥\u001B[0m ] \u001B[3myou are in perfect health!\u001B[0m\n");


        } else if (h >= 50) {
            System.out.println(adventure.getHealth() +" [ \u001B[31m♥ ♥ ♥\u001B[0m ♡ ] \u001B[3myou are in good health, but avoid fighting right now\u001B[0m\n");


        } else if (h >= 25) {
            System.out.println(adventure.getHealth() +" [ \u001B[31m♥ ♥\u001B[0m ♡ ♡ ] \u001B[3myou are wounded - find something healthy to eat\u001B[0m\n");


        } else if (h >= 1) {
            System.out.println(adventure.getHealth() +" [ \u001B[31m♥\u001B[0m ♡ ♡ ♡ ] \u001B[3myou are barely alive\u001B[0m\n");


        } else {
            System.out.println("adventure.getHealth() +[ ♡ ♡ ♡ ♡ ] \u001B[3myou should be dead...\u001B[0m\n");


        }


    }


    // Take item
    private void takeItem(String itemName) {


        Item item = adventure.takeItem(itemName);


        if (item == null) {
            System.out.println("\nThere is no " + itemName + " to take here.\n");
        } else {
            System.out.println("\nYou picked up the " + item.getItemName() + "\n");
        }
    }


    // Drop item:
    private void dropItem(String itemName) {
        Item item = adventure.dropItem(itemName);


        if (item == null) {
            System.out.println("\nYou do not have " + itemName + " in your inventory\n");
        } else {
            System.out.println("\nYou dropped the " + item.getItemName() + "\n");
        }
    }


    //Show items in room
    private void showItems(Room room) {
        if (room.getItems().isEmpty()) {
            System.out.println("\nThere are no items in this room.\n");
            return;
        }
        System.out.println("\u001B[3m\nYOU ALSO DISCOVER\n\u001B[0m");
        for (Item item : room.getItems()) {
            System.out.println("\t✦ " + item.getItemName() + " - \u001B[3m" + item.getItemDescription() + "\u001B[0m");
        }
    }


    // Shows inventory:
    private void showInventory() {
        System.out.println("\u001B[1m\nINVENTORY\u001B[0m");
        System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");


        if (adventure.getInventory().isEmpty()) {
            System.out.println("\u001B[3mYour inventory is empty. Explore the maze, find useful items, and take them with you.\u001B[0m");
        } else {
            for (Item item : adventure.getInventory()) {
                System.out.println("✢ " + item.getItemName());
            }
        }
        Weapon equippedWeapon = adventure.getEquippedWeapon();
        if (equippedWeapon == null) {
            System.out.println("\nNO WEAPON EQUIPPED");
        } else {
            System.out.println("\nEQUIPPED WEAPON: " + equippedWeapon.getItemName());
        }
        System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
    }


    // tells posibilites of equip:
    private void equipWeapon(String weaponName) {


        EquipResult result = adventure.equip(weaponName);
        switch (result) {
            case NOT_FOUND -> System.out.println("\nYou do not have '" + weaponName + "' in your inventory.\n");
            case NOT_WEAPON ->
                    System.out.println("\nYou cannot equip the " + weaponName + " because it is not a weapon.\n");
            case EQUIPPED -> System.out.println("\nYou equip the " + adventure.getEquippedWeapon().getItemName() + "\n");
        }
    }


    //Tells the weapons last use and ammunition
    private void showWeaponStatus(Weapon weapon) {
        String usesLeftText = weapon.getUsesLeftText();
        if (!usesLeftText.isBlank()) {
            System.out.println(usesLeftText);
        }
        if (!weapon.canUse()) {
            System.out.println("\nThat was the weapon's last use.\n");
        }
    }


    //Outputs rooms description again
    private void lookAround() {
        System.out.println(adventure.look());
    }


    //show enemies in current room
    private void showEnemies(Room room) {
        if (room.getEnemies().isEmpty()) {
            System.out.println("\nThere are no enemies in this room.");
            return;
        }
        System.out.println("\nEnemies in this room:");
        for (Enemy enemy : room.getEnemies()) {
            System.out.println("\n\t!" + enemy.getShortName() + " - " + enemy.getLongName() + "\n\t" + enemy.getDescription());
        }
    }


    // Sends attack command and prints result:
    private void attack(String enemyName) {


        AttackOutcome outcome = adventure.attack(enemyName);
        AttackResult result = outcome.getPlayerAttackResult();
        Enemy enemy = outcome.getEnemy();
        Weapon weapon = adventure.getEquippedWeapon();


        switch (result) {
            case ENEMY_NOT_FOUND -> System.out.println("\nThere is no enemy named '" + enemyName + "' here.\n");
            case NO_WEAPON -> System.out.println("\nYou have no weapon equipped.\n");
            case WEAPON_EMPTY -> System.out.println("\nYour weapon can no longer be used.\n");
            case EMPTY_AIR -> {
                System.out.println("\nThere are no enemies here. You " + weapon.getAttackVerb() + " the " + weapon.getItemName() + " at the empty air.\n");
                showWeaponStatus(weapon);
            }
            case ENEMY_HIT -> {
                System.out.println("\nYou " + weapon.getAttackVerb() + " the " + weapon.getItemName() + " at " + enemy.getLongName() + " for " + weapon.getDamage() + " damage.\n");
                showWeaponStatus(weapon);
                System.out.println("\n" + enemy.getLongName() + " has " + enemy.getHealth() + " health left.\n");
                showEnemyAttack(outcome);
            }
            case ENEMY_DIED -> {
                System.out.println("\nYou " + weapon.getAttackVerb() + " the " + weapon.getItemName() + " at " + enemy.getLongName() + " for " + weapon.getDamage() + " damage.\n");
                showWeaponStatus(weapon);
                System.out.println("\n" + enemy.getLongName() + " dies and drops the " + enemy.getWeapon().getItemName() + "\n");
            }
            default -> {
            }
        }
    }


    // Prints enemy counterattack result:
    private void showEnemyAttack(AttackOutcome outcome) {
        Enemy enemy = outcome.getEnemy();
        AttackResult result = outcome.getEnemyAttackResult();


        switch (result) {
            case WEAPON_EMPTY ->
                    System.out.println("\n" + enemy.getLongName() + " cannot attack because its weapon is empty.\n");
            case PLAYER_HIT -> {
                System.out.println("\n" + enemy.getLongName() + " attacks you for " + enemy.getWeapon().getDamage() + " damage.\n");
                System.out.println("\nYou have " + adventure.getHealth() + " health left.\n");
            }
            case PLAYER_DIED -> {
                System.out.println("\n" + enemy.getLongName() + " attacks you for " + enemy.getWeapon().getDamage() + " damage.\n");
                System.out.println("\u001B[1m\u001B[90m");
                System.out.println("██╗   ██╗ ██████╗ ██╗   ██╗    ██████╗ ██╗███████╗██████╗ ██╗");
                System.out.println("╚██╗ ██╔╝██╔═══██╗██║   ██║    ██╔══██╗██║██╔════╝██╔══██╗██║");
                System.out.println(" ╚████╔╝ ██║   ██║██║   ██║    ██║  ██║██║█████╗  ██╔══██╗██║");
                System.out.println("  ╚██╔╝  ██║   ██║██║   ██║    ██║  ██║██║██╔══╝  ██║  ██║╚═╝");
                System.out.println("   ██║   ╚██████╔╝╚██████╔╝    ██████╔╝██║███████╗██████╔╝██╗");
                System.out.println("\u001B[0m");
                System.out.println("\n\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
                System.out.println(
                        "\n\t\t\t\t\t\t\t\t\t\t\t\tThank you for playing!" +
                                "\n\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t\t\tGAME DEVELOPERS\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t  Lærke Wendel Søgaard-Jensen\n" +
                                "\t\t\t\t\t\t\t\t\t\t   Frederik Valdemar Nordahl Nielsen\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tAjla Moco\n");
                System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
                System.exit(0);
            }
            default -> {
            }
        }
    }


    // Show help - list of commands:
    public void showHelp() {
        System.out.println("\u001B[1m\nAVAILABLE COMMANDS\u001B[0m");
        System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m");
        System.out.println("[start]                 ➤   Start the game");
        System.out.println("[n] [north] [go north]  ➤   Move north");
        System.out.println("[e] [east] [go east]    ➤   Move east");
        System.out.println("[s] [south] [go south]  ➤   Move south");
        System.out.println("[w] [west] [go west]    ➤   Move west");
        System.out.println("[eat + food]            ➤   Adds or removes health");
        System.out.println("[attack + enemy]        ➤   Attacks the enemy");
        System.out.println("[health]                ➤   Show health points");
        System.out.println("[equip]                 ➤   Equips the weapon");
        System.out.println("[take + item]           ➤   Add item to inventory");
        System.out.println("[drop + item]           ➤   Remove item from inventory");
        System.out.println("[i] [inventory]         ➤   See your inventory");
        System.out.println("[look]                  ➤   Get room description");
        System.out.println("[exit]                  ➤   Close the game");
        System.out.println("\u001B[90m─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\u001B[0m\n");
    }
}



