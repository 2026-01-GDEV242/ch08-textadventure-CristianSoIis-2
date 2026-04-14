/**
 * Item is used to keep track of the name and weight of an Item and to get the name and weight
 * whenever it is needed
 *
 * @author Cristian Solis
 * @version 2026.04.13
 */
public class Item
{
    // instance variables
    private String name;
    private int weight;

    /**
     * Constructor for objects of class Item
     * @param text Name of Item
     * @param pounds Weight of the Item
     */
    public Item(String text, int pounds)
    {
        name = text;
        weight = pounds;
    }
    
    /**
     * Returns the name of Item.
     * @return name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the weight of Item.
     * @return weight.
     */
    public int getWeight()
    {
        return weight;
    }    
}