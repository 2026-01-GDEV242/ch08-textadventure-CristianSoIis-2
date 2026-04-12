
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private String itemDescription;
    private int weight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name2, String text, int pounds)
    {
        name = name2;
        itemDescription = text;
        weight = pounds;
    }
    
    /**
     * 
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 
     */
    public String getItemDescription()
    {
        return itemDescription;
    }
    
    /**
     * 
     */
    public int getWeight()
    {
        return weight;
    }
    
    
    
}