import java.util.*;

public class Poll
{
    String title;
    String question;
    ArrayList item;
    
    public Poll(FileReader fRead, String name) throws IOException
    {
        Scanner scan = new Scanner(fRead);
        title = name;
        item = new ArrayList();
        
        while (scan.hasNext())
        {
            item.add(scan.next());
        }

        System.out.println(item);
    }
    
    public void Run()
    {
        
    }
    
    public String toString()
    {
        return title;
    }
}