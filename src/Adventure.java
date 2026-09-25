public class Adventure {
    static void main() {

        Adventure adventure = new Adventure();

        //Map creator:
        Map map = new Map();

        //Player creator:
        Player player = new Player(map.getStartRoom());

        //User connection:
        UserInterface ui = new UserInterface();

        //Runningtime:
        boolean running = true;

        //GameStart:
        ui.welcome(player);

    }
}

