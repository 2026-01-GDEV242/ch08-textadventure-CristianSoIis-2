import java.util.Stack;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author Cristian Solis
 * @version 2026.04.13
 */

public class Game 
{
    private Parser parser;
    private Player player;
    private Stack<Room> text;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        text = new Stack<>();
    }

    /**
     * Create all the rooms and link their exits together. 
     * Along with adding items in the rooms.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setItem("Apple", 3);

        theater.setExit("west", outside);
        theater.setItem("Chair", 25);

        pub.setExit("east", outside);
        pub.setItem("Hamburger", 2);
        pub.setItem("Hotdog", 4);

        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setItem("Book", 10);

        office.setExit("west", lab);
        office.setItem("Tests", 5);

        player = new Player(outside);  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (!finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord)
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case LOOK:
                look();
                break;
                     
            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case BACK:
                 goBack(command);
                 break;
                 
            case TAKE:
                 take(command);
                 break;
                 
            case DROP:
                 break;
        }
        return wantToQuit;
    }

    // implementations of user commands:
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction, otherwise print an erro. If there is an exit, enter the new
     * room and before changing room locaction, add the current spot in stack textr message. 
     * @param command The command to be processed.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        
        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExit(direction);
        
        if (nextRoom == null) 
        {
            System.out.println("There is no door!");
        }
        
        else 
        {
            text.push(player.getCurrentRoom());
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
    }
    
    /**
     * Prints what is around in the room along with the exits, like if we just enter the room
     */
    private void look()
    {
        System.out.println(player.getCurrentRoom().getLongDescription());
    }
    
    /**
     * Checks if a second word was typed and if so asks to only do it once and prints the current room info.
     * If the stack text has a value, set's the players spot to that room and prints the current room info.
     * Else says we are at the starting point and prints the current rooms info.
     * @param command The command to be processed.
     */
    private void goBack(Command command)
    {
        if(command.hasSecondWord() == true)
        {
            System.out.println("If you want to go back, please only enter back once");
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
        
        if(!text.isEmpty())
        {
                player.setCurrentRoom(text.pop());
                System.out.println(player.getCurrentRoom().getLongDescription());
        }
        else
        {
                System.out.println("You have reach the starting point with no way to go back");
                System.out.println(player.getCurrentRoom().getLongDescription());
        }
    }

     /*public ___ drop() Didn't do just from time and ya
    {
        
    }
    */
    
    /**
     * Checks if there is a second word after command, if so gets the second word and stores it in a String value.
     * Then checks if the current room has the item with weight to check for the item from a HashMap.
     * If found prints we found it else prints we didn't. If there is no second word prints to put a second word.
     * @param command The command to be processed.
     */
    public void take(Command command)
    {
        if(command.hasSecondWord() == true)
        {
             String itemToGet = command.getSecondWord();
             if(player.getCurrentRoom().getItem(itemToGet) != null)
             {
                 System.out.println("The item " + itemToGet + " was found and stored");
             }
             
             else
             {
                 System.out.println("Item can't be found in the room");
             }
        }
        else
        {
            System.out.println("Please enter in another word so we can check if that item is here");
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @param command The command to be processed.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
