
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
    private int weight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String text, int pounds)
    {
        name = text;
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
    public int getWeight()
    {
        return weight;
    }
    
    
    
}