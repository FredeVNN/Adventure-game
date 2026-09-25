public class Adventure {
    static void main() {

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

        while(running){
            Room currentRoom = player.getCurrentRoom();
            ui.rooms(currentRoom);

            String inputs = ui.input();

            if(inputs.equals("exit")){
                ui.stop();
                running = false;
            } else if (inputs.equals("n") || inputs.equals("s") || inputs.equals("e") || inputs.equals("w")) {
                Room nextRoom = currentRoom.getExit(inputs);

                if (nextRoom != null){
                    player.setCurrentRoom(nextRoom);
                } else {
                    ui.errors("You got send back! You cannot go that way...");
                }
            } else {
                ui.errors("I dont recognise that command!");
            }
        }
    }
}

