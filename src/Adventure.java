public class Adventure {
    static void main() {

        Adventure adventure = new Adventure();

        //Map creator:
        Map map = new Map();

        //Player creator:
        Player player = new Player(map.getStartRoom());

        //Item creator - laves om når 'take' er implementeret
        Item knife = new Item ("knife", "a knife");
                player.addToInventory(knife);

        //User connection:
        UserInterface ui = new UserInterface();

        //Runningtime:
        boolean running = true;




        //GameStart:
        ui.welcome();
        while (running){ ui.handleCommand(player); }
    }
}

