import java.util.ArrayList;

public class Map {

    // Variables declaration:
    private Room startRoom;
    private Room r1, r2, r3, r4, r5, r6, r7, r8, r9;

    public Map() {

    // Create Rooms:
        r1 = new Room("ROOM 01", "THE DARK CAVE", "You find yourself deep inside a massive underground cave, dark and cold.");
        r2 = new Room("ROOM 02", "THE SUNKEN ATLANTIS", "You suddenly find yourself beneath the ocean, surrounded by the ruins of Atlantis.");
        r3 = new Room("ROOM 03", "THE FROZEN WASTELAND", "You end up in a frozen wasteland, surrounded by endless snow and towering walls of ice.");
        r4 = new Room("ROOM 04", "THE ANCIENT PYRAMIDS", "You emerge inside an ancient pyramid, surrounded by hieroglyphs, statues and flickering torches.");
        r5 = new Room("ROOM 05", "THE SPACE STATION", "You suddenly appear aboard a massive space station, floating silently above an unknown planet.");
        r6 = new Room("ROOM 06", "THE JUNGLE TEMPLE", "You stumble into a forgotten temple, hidden deep within a wild jungle of vines and ancient ruins.");
        r7 = new Room("ROOM 07", "THE JURASSIC WORLD", "You step into a prehistoric jungle, where towering trees surround you and dinosaurs roar in the distance.");
        r8 = new Room("ROOM 08", "THE ENCHANTED FOREST", "You wander into an enchanted forest, where glowing plants and strange creatures surround you.");
        r9 = new Room("ROOM 09", "THE CYBER CITY", "You arrive in a futuristic city, surrounded by neon lights, towering skyscrapers and flying vehicles.");

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

    // Wrong directions:
        r1.setWest(null); r1.setNorth(null);
        r2.setNorth(null); r2.setSouth(null);
        r3.setNorth(null); r3.setEast(null);
        r4.setEast(null); r4.setWest(null);
        r5.setWest(null); r5.setEast(null); r5.setNorth(null);
        r6.setEast(null); r6.setWest(null);
        r7.setSouth(null); r7.setWest(null);
        r8.setSouth(null);
        r9.setEast(null); r9.setSouth(null);

    // Start Room:
        this.startRoom = r1;

    // Create Items:
        Item sword = new Item("Pharaoh’s Sword", "Wield this to slay your enemies.");
        Item yeti = new Item("Friendly Yeti", "This gentle giant will help protect you.");
        Item scubaGear = new Item("Scuba gear", "Use this to dive and breathe underwater.");
        Item armor = new Item("Warrior’s Armor", "This grants you strength and boosts your health.");
        Item dinoBone = new Item("Dinosaur bone", "This is probably useless...");
        Item spaceSuit = new Item("Spaces suit", "Wear this to survive in space.");

    // Add Items to Rooms:
        r2.addItem(scubaGear);
        r3.addItem(yeti);
        r4.addItem(sword);
        r5.addItem(spaceSuit);
        r7.addItem(dinoBone);
        r8.addItem(armor);
    }

    // Constructor:
    public Room getStartRoom() {
        return startRoom;
    }
}