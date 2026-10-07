import java.util.Scanner;

public class UserInterface {
    //reads user input
    private final Scanner scanner;
    //sends game commands to controller (adventure class)
    private final Adventure adventure;

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
        System.out.println("WELCOME TO\n");
        System.out.println("\u001B[1m\u001B[34m──────────────⟪ TIME MAZE ⟫──────────────────────────────────────────────────────────────────────\n\u001B[0m");
        System.out.println("It is the year 4,000 BC. You are a caveman out hunting when suddenly—\n" + ">>>CRACK<<<\n" + "The ground disappears beneath your feet, and you fall into darkness.\n");
        System.out.println("You find yourself deep inside a massive underground cave!\n" + "In front of you lies a strange compass. You pick it up. The needle spins wildly!\n");
        System.out.println("You search for a way out. But the endless tunnels only lead you deeper into the unknown.\n" + "Then you hear a strange humming sound.\n" + "You follow it and discover something impossible...\n");
        System.out.println("\u001B[3mWHAT WILL YOU DO?\n\u001B[0m");
        System.out.println("\u001B[1m\u001B[35m\t• Type [start] to begin your journey  •  Type [exit] to leave the maze  •\n\u001B[0m");
    }

    // shows room:
    private void rooms(Room room) {
        System.out.println("\n[ " + room.getRoomNum() + " ]" + "\t\t>> " + room.getName() + " <<");
        System.out.println("─".repeat(room.getRoomNum().length() + room.getName().length() + 15));

        if (!room.isDiscoveredRoom()) {

            // Room description and items:
            System.out.println(room.getDescription());
            room.setDiscoveredRoom(true);
        }
        else {
            System.out.println("You return to " + room.getName());
        }
        showItems(room);
        showEnemies(room);

        System.out.println("─".repeat(room.getDescription().length()));
        System.out.println("\u001B[1m\u001B[35m\n\t• " + room.getGuide() + " •\u001B[0m");
        System.out.println("\u001B[1m\u001B[35m\t• Type [n] to move North  •  Type [e] to move East  •  Type [s] to move South  •  Type [w] to move West •\u001B[0m");
    }

    // reads and handles commands:
    private void handleCommand() {
        String command = scanner.nextLine().toLowerCase();

        if (command.startsWith("go ")) {
            command = command.substring(3);
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
                System.out.println("See you next time!");
                System.exit(0);
            }
            default -> System.out.println(
                    "\nHmm... that doesn't seem to work here!" + "\n\n\t• Type [help] to see what you can do •\n"
            );
        }
    }

    // info for player moves:
    private void moveDirection(String direction) {

        boolean moving = adventure.go(direction);

        if (moving) {
            Room currentRoom = adventure.getCurrentRoom();
            rooms(currentRoom);

            if (currentRoom.getRoomNum().equals("ROOM 05")) {
                System.out.println("\nCongratulations!");
                System.out.println("You reached the final room.");
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        } else {
            System.out.println("\nWHOOSH! The portal sends you straight back. Try another path!");
        }
    }

    // Eat food:
    private void eatFood(String foodName) {
        EatOutcome outcome = adventure.eat(foodName);

        switch (outcome.getResult()) {
            case NOT_FOUND ->
                    System.out.println("There is nothing like '" + outcome.getItemName() + "' to eat around here.");
            case NOT_FOOD -> System.out.println("You cannot eat the " + outcome.getItemName());
            case EATEN -> {
                System.out.println("You ate the " + outcome.getItemName());
                if (outcome.getHealthChange() > 0) {
                    System.out.println("You feel better.");
                } else if (outcome.getHealthChange() < 0) {
                    System.out.println("That was a mistake");
                }
                System.out.println("Your health is now: " + adventure.getHealth());

                if (!adventure.isPlayerAlive()) {
                    System.out.println("The food was deadly. You died. Game over.");
                    System.exit(0);
                }
            }
        }
    }

    // shows players health:
    private void showHealth() {
        System.out.println("Your healthpoints are: " + adventure.getHealth());

        int h = adventure.getHealth();

        if(h >= 100){
            System.out.println("you are in perfect health");
        } else if (h >= 50) {
            System.out.println("you are in good health, but avoid fighting right now");
        } else if (h >= 25) {
            System.out.println("you are wounded - find something healthy to eat");
        } else if (h >= 1) {
            System.out.println("you are barely alive");
        } else {System.out.println("you should be dead");
        }
    }

    // Take item
    private void takeItem(String itemName) {

        Item item = adventure.takeItem(itemName);

        if (item == null) {
            System.out.println("There is no " + itemName + " to take here.");
        }
        else {
            System.out.println("You picked up the " + item.getItemName());
        }
    }

    // Drop item:
    private void dropItem(String itemName) {
        Item item = adventure.dropItem(itemName);

        if (item == null) {
            System.out.println("You do not have " + itemName + " in your inventory");
        }
        else {
            System.out.println("You dropped the " + item.getItemName());
        }
    }
    //Show items in room
    private void showItems (Room room) {
        if (room.getItems().isEmpty()) {
            System.out.println("\nThere are no items in this room.");
            return;
        }
        System.out.println("\nYou also discover: ");
        for (Item item: room.getItems()) {
            System.out.println("\n\t* " + item.getItemName() + " - " + item.getItemDescription());
        }
    }

    // Shows inventory:
    private void showInventory() {
        System.out.println("\n⟨ INVENTORY ⟩");
        System.out.println("─────────────");

        if (adventure.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty. Explore the maze, find useful items, and take them with you.");
        }
        else {
            for (Item item : adventure.getInventory()) {
                System.out.println("+ " + item.getItemName());
            }
        }
        Weapon equippedWeapon = adventure.getEquippedWeapon();
        if (equippedWeapon == null) {
            System.out.println("\nEquipped: nothing");
        }
        else {
            System.out.println("\nEquipped: " + equippedWeapon.getItemName());
        }
    }

    // tells posibilites of equip:
    private void equipWeapon(String weaponName) {

        EquipResult result = adventure.equip(weaponName);
        switch(result) {
            case NOT_FOUND -> System.out.println("You do not have '" + weaponName + "' in your inventory.");
            case NOT_WEAPON -> System.out.println("You cannot equip the " + weaponName + " because it is not a weapon.");
            case EQUIPPED -> System.out.println("You equip the " + adventure.getEquippedWeapon().getItemName());
        }
    }
    //Tells the weapons last use and ammunition
    private void showWeaponStatus (Weapon weapon) {
        String usesLeftText = weapon.getUsesLeftText();
        if (!usesLeftText.isBlank()) {
            System.out.println(usesLeftText);
        }
        if (!weapon.canUse()) {
            System.out.println("That was the weapon's last use.");
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
            System.out.println("\n\t!" + enemy.getShortName() + " - " + enemy.getLongName() + "\n\t" + enemy.getDescription() );
        }
    }
    // Sends attack command and prints result:
    private void attack(String enemyName) {

        AttackOutcome outcome = adventure.attack(enemyName);
        AttackResult result = outcome.getPlayerAttackResult();
        Enemy enemy = outcome.getEnemy();
        Weapon weapon = adventure.getEquippedWeapon();

        switch (result) {
            case ENEMY_NOT_FOUND -> System.out.println("There is no enemy named '" + enemyName + "' here.");
            case NO_WEAPON -> System.out.println("You have no weapon equipped.");
            case WEAPON_EMPTY -> System.out.println("Your weapon can no longer be used.");
            case EMPTY_AIR -> {System.out.println("There are no enemies here. You " + weapon.getAttackVerb() + " the " + weapon.getItemName() + " at the empty air.");
                showWeaponStatus(weapon);
            }
            case ENEMY_HIT -> {System.out.println("You " + weapon.getAttackVerb() + " the " + weapon.getItemName() + " at " + enemy.getLongName() + " for " + weapon.getDamage() + " damage.");
                showWeaponStatus(weapon);
                System.out.println(enemy.getLongName() + " has " + enemy.getHealth() + " health left.");
                showEnemyAttack(outcome);
            }
            case ENEMY_DIED -> {System.out.println("You " + weapon.getAttackVerb() + " the " + weapon.getItemName() + " at " + enemy.getLongName() + " for " + weapon.getDamage() + " damage.");
                showWeaponStatus(weapon);
                System.out.println(enemy.getLongName() + " dies and drops the " + enemy.getWeapon().getItemName());
            }
            default -> {}
        }
    }
    // Prints enemy counterattack result:
    private void showEnemyAttack(AttackOutcome outcome) {
        Enemy enemy = outcome.getEnemy();
        AttackResult result = outcome.getEnemyAttackResult();

        switch (result) {
            case WEAPON_EMPTY -> System.out.println(enemy.getLongName() + " cannot attack because its weapon is empty.");
            case PLAYER_HIT -> {System.out.println(enemy.getLongName() + " attacks you for " + enemy.getWeapon().getDamage() + " damage.");
                System.out.println("You have " + adventure.getHealth() + " health left.");
            }
            case PLAYER_DIED -> {System.out.println(enemy.getLongName() + " attacks you for " + enemy.getWeapon().getDamage() + " damage.");
                System.out.println("You died. Game over.");
                System.exit(0);
            }
            default -> {}
        }
    }


    // Show help - list of commands:
    public void showHelp() {
        System.out.println("─────────────────────────────────────────────────────────");
        System.out.println("AVAILABLE COMMANDS\n");
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
        System.out.println("─────────────────────────────────────────────────────────\n");
    }
}

