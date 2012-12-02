import java.util.*;

public class Poll
{
    String title;
    String question;
    ArrayList item;
    
    public Poll(FileReader fRead, String name, String quest) throws IOException
    {
        Scanner scan = new Scanner(fRead);
        title = name;
        question = quest;
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
    
    public boolean Query(String first, String second)
    {
        System.out.println(question);
        System.out.println("(1) " + first + " or (2) " + second + "?")
        int response = scan.nextInt();
        while (response != 1 || response != 2)
        {
            System.out.println("Please select (1) or (2).");
            int response = scan.nextInt();
        }
        if (response == 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public String toString()
    {
        return title;
    }
    
    // Quicksort algorithm (from Java Foundations)
    public static void quickSort(ArrayList data, int min, int max)
    {
        int pivot;
        if(min < max)
        {
            pivot = partition(data, min, max);
            quickSort(data, min, pivot-1);
            quickSort(data, pivot+1, max);
        }
    }
    
    private static int partition(ArrayList data, int min, int max)
    {
        String partitionValue = data.get(min).toString();
        int left = min;
        int right = max;
        while (left < right)
        {
            while(Query(data.get(left)), partitionValue && left < right)
            {
                left++;
            }
            while(!Query(data.get(right), partitionValue))
            {
                right--;
            }
            if(left < right)
            {
                swap(data, left, right);
            }
        }
        swap(data, min, right);
        return right;
    }
    
    public static void swap(ArrayList data, int index1, int index2)
    {
        String temp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, temp);
    }
}