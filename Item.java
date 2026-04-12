
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemDescription;
    private int weight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String text, int pounds)
    {
        itemDescription = text;
        weight = pounds;
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