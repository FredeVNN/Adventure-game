public class Map {

    // Variables declaration:
    private Room startRoom;
    private Room r1, r2, r3, r4, r5, r6, r7, r8, r9;


    public Map() {

        // Creates Room:
        r1 = new Room("ROOM 01", "THE DARK CAVE", "You find yourself deep inside a massive underground cave, dark and cold.\n" + "Ahead, you can see mysterious portals glowing in the darkness, each leading to an unknown time.");
        r2 = new Room("ROOM 02", "Atlantis","h" );
        r3 = new Room("ROOM 03", "Antarctica", "h");
        r4 = new Room("ROOM 04", "The Pyramids","h");
        r5 = new Room("ROOM 05", "Space Station","h");
        r6 = new Room("ROOM 06", "Jungle Temple","h");
        r7 = new Room("ROOM 07", "Jurassic World","h");
        r8 = new Room("ROOM 08", "Magical Forest","h");
        r9 = new Room("ROOM 09", "Futuristic Tokyo","h");

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

        // Wrong direction:
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
    }
    //Constructor:
    public Room getStartRoom() {return startRoom;}
   // public Room getCurrentRoom(){
       // return getCurrentRoom();
    //}
}
