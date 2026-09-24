public class Map {
    // Variables declaration:

    private Room r1, r2, r3, r4, r5, r6, r7, r8, r9;
    private Room startRoom;
    private Room lastRoom;

    //Constructor:

    public Map() {

        // Creates Room:

        Room r1 = new Room("Room 1", "Cave");

        Room r2 = new Room("Room 2", "Atlantis");

        Room r3 = new Room("Room 3", "Antarctica");

        Room r4 = new Room("Room 4", "The Pyramids");

        Room r5 = new Room("Room 5", "Space Station");

        Room r6 = new Room("Room 6", "Jungle Temple");

        Room r7 = new Room("Room 7", "Jurassic World");

        Room r8 = new Room("Room 8", "Magical Forrest");

        Room r9 = new Room("Room 9", "Futuristic Tokyo");


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

        startRoom = r1;

        // Finish Line:

        lastRoom = r5;
    }
}
