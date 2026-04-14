import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author Cristian Solis
 * @version 2026.04.13
 */

public class Room 
{
    private String description;
    private HashMap <String, Room> exits; // stores exits of this room.
    private HashMap <String, Integer> item;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        item = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room.
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room, if HashMap item has an item or more prints the items
     * else prints it normally without trying to print items.
     */
    public String getLongDescription()
    {
        if(item.size() != 0)
        {
           return "You are " + description + ".\n" + getExitString() + ".\nYou see: " + showItem(); 
        }
        
        else
        {
            return "You are " + description + ".\n" + getExitString();
        }
    }

    /**
     * Return a string describing the room's exits, for example.
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Puts in a item inside the HashMap item with a String and int that will autocast to Integer
     * @param object Name of the Item. 
     * @param pounds Weight of the Item.
     * 
     */
    public void setItem(String object, int pounds)
    {
        item.put(object, pounds);
    }
    
    /**
     * Prints out the items in a room by going through item and using the key to get the Integer that will autocast to int.
     * @return String text of the items and the name and weight of it.
     */
    public String showItem()
    {
        String returnItem = "";
        Set<String> keys = item.keySet();
        for(String items : keys) {
            returnItem += items + " weight " + item.get(items)+ ", ";
        }
        return returnItem;
    }
    
    /**
     * Gets the Integer in item with doing the key. Checks to see if the weight exists, so not 
     * returns null else prints the name of Item showing it was found
     * @param itemToFind Name of Item were trying to find.
     * @return null if itemWeight == null else itemToFind
     */
    public String getItem(String itemToFind)
    {
        Integer itemWeight = null;
        itemWeight = item.get(itemToFind);
        if(itemWeight == null)
        {
            return null;
        }
        
        else
        {
            return itemToFind;
        }
    }
}