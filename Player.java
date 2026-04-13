
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables 
    private Room currentRoom;
    private Item item;


    /**
     * Constructor for objects of class Player
     */
    public Player(Room startRoom)
    {
       currentRoom = startRoom;
    }
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room spot)
    {
        currentRoom = spot;
    }

    
    
    
    
}