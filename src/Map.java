public class Map {

    // room variables
    private Room startRoom;
    private Room r1, r2, r3, r4, r5, r6, r7, r8, r9;
    //constructor:
    public Map() {

        // Create Rooms:
        r1 = new Room("ROOM 01", "THE DARK CAVE", "You find yourself deep inside a massive underground cave, dark and cold. Old cave paintings carved into the stone walls depict prehistoric hunters chasing a MAMMOTH.", "Type [eat + food name] to eat food and restore your strength");
        r2 = new Room("ROOM 02", "THE SUNKEN ATLANTIS", "You suddenly find yourself beneath the ocean, surrounded by the ruins of Atlantis.", "Type [take + item name] to pick up an item and add it to your inventory");
        r3 = new Room("ROOM 03", "THE FROZEN WASTELAND", "You end up in a frozen wasteland, surrounded by endless snow and towering walls of ice. A friendly yeti approaches you with a big smile and offers you a scoop of ice cream. Before you leave, the yeti tells you that you can always ask for help if you get lost or need guidance on your journey.", "Type [help] to see all available commands");
        r4 = new Room("ROOM 04", "THE ANCIENT PYRAMIDS", "You emerge inside an ancient pyramid, surrounded by hieroglyphs, statues and flickering torches. In the middle of the wall, a giant FALCON is carved within a large circle, surrounded by mysterious symbols.", "Type [take + item name] to pick up an item and add it to your inventory");
        r5 = new Room("ROOM 05", "THE SPACE STATION", "You suddenly appear aboard a massive space station, floating silently above an unknown planet. The control panel demands a secret code to activate the ship's engines. You remember seeing three animals carved into the walls of different places throughout the maze. Could they hold the key to your escape?", "");
        r6 = new Room("ROOM 06", "THE JUNGLE TEMPLE", "You stumble into a forgotten temple, hidden deep within a wild jungle of vines and ancient ruins. The entrance is shaped like a giant MONKEY head, with its mouth wide open, forming the gateway into the temple.", "Type [take + item name] to pick up an item and add it to your inventory");
        r7 = new Room("ROOM 07", "THE JURASSIC WORLD", "You step into a prehistoric jungle, where towering trees surround you and dinosaurs roar in the distance.", "Type [take + item name] to pick up an item and add it to your inventory");
        r8 = new Room("ROOM 08", "THE ENCHANTED FOREST", "You wander into an enchanted forest, where glowing plants and strange creatures surround you.", "Type [eat + food name] to eat food and restore your strength");
        r9 = new Room("ROOM 09", "THE CYBER CITY", "You arrive in a futuristic city, surrounded by neon lights, towering skyscrapers and flying vehicles.", "Type [eat + food name] to eat food and restore your strength");

        // Connection between Rooms:
        r1.setEast(r2); r1.setSouth(r4);
        r2.setWest(r1); r2.setEast(r3);
        r3.setWest(r2); r3.setSouth(r6);
        r4.setNorth(r1); r4.setSouth(r7);
        r5.setSouth(r8);
        r6.setNorth(r3); r6.setSouth(r9);
        r7.setNorth(r4); r7.setEast(r8);
        r8.setWest(r7); r8.setEast(r9); r8.setNorth(r5);
        r9.setNorth(r6); r9.setWest(r8);

        // Start Room:
        this.startRoom = r1;

        // Create Items:
        Item scubaGear = new Item("Scuba gear", "Use this to dive and breathe underwater.");
        Item armor = new Item("Warrior’s Armor", "This grants you strength and boosts your health.");
        Item dinoBone = new Item("Dinosaur bone", "This is probably useless...");
        Item spaceSuit = new Item("Spaces suit", "Wear this to survive in space.");

        // Add Items to Rooms:
        r2.addItem(scubaGear);
        r5.addItem(spaceSuit);
        r6.addItem(armor);
        r7.addItem(dinoBone);

        // Create FoodItems:
        Food meat = new Food("Hunted Meat", "Fresh from your prehistoric hunt. A perfect meal for a caveman.", 100);
        Food apple = new Food("Enchanted Apple", "A mysterious red apple found in the enchanted forest. Should you dare to take a bite?", -50);
        Food noodles = new Food("Turbo Noodles", "A bowl of futuristic noodles. Could this power you up?", -25);
        Food berries = new Food("Mystic Berries", "Strange glowing berries found deep in the enchanted forest. What magic could they hold?", 75);
        Food icecream = new Food("Yeti's Ice Cream", "A frozen treat offered by your friendly Yeti. A little kindness in the frozen wasteland.", 15);

        // Adds Food to Rooms:
        r1.addItem(meat);
        r3.addItem(icecream);
        r8.addItem(apple);
        r8.addItem(berries);
        r9.addItem(noodles);

        // Create weapons:
        Weapon huntersBow = new RangedWeapon("Hunters Bow", "From hunting earlier", 20, 3);
        Weapon PharaohsSword = new MeleeWeapon("Pharaoh's Sword", "Wield this to slay your enemies.", 15);
        Weapon ThrowingStars = new RangedWeapon("Throwing Stars", "Throw this at enemies", 30, 3);

        // Add weapons to rooms:
        r1.addItem(huntersBow);


        //Creates enemy
        Enemy mummy = new Enemy("Mummy", "The ancient mummy", "It rises from its sarcophagus", 30, PharaohsSword, r4);
        Enemy ninjas = new Enemy("ninjas","the cyber ninjas", "a futuristic group of ninjas blocks your path", 50, ThrowingStars, r9);

        //Add enemies to rooms
        r4.addEnemy(mummy);
        r9.addEnemy(ninjas);

    }
//gets start room
    public Room getStartRoom() {
        return startRoom;
    }
}