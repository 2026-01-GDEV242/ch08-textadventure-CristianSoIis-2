/**
 * Write a description of class Player here.
 *
 * @author Cristian Solis
 * @version 2026.04.13
 */
public class Player
{
    // instance variables 
    private Room currentRoom;
    private Item item;

    /**
     * Constructor for objects of class Player.
     * @param startRoom Room where we start in.
     */
    public Player(Room startRoom)
    {
       currentRoom = startRoom;
    }
    
    /**
     * Returns the currentRoom were in.
     * @return currentRoom.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * Has param Room spot and sets that Room to the currentRoom.
     * @param spot New Room we go to.
     */
    public void setCurrentRoom(Room spot)
    {
        currentRoom = spot;
    }
}