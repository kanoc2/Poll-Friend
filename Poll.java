import java.util.*;
import java.io.*;

public class Poll
{
    String title;
    String question;
    ArrayList<String> item;
    Scanner scan;
    ArrayList<ArrayList> fullLists = new ArrayList<ArrayList>();
    
    public Poll(File inF, String name, String quest) throws IOException
    {
	FileReader fRead = new FileReader(inF);
        scan = new Scanner(fRead);
        title = name;
        question = quest;
        item = new ArrayList<String>();
        
        while (scan.hasNext())
        {
            item.add(scan.next());
        }

       // System.out.println(item);
    }
    
    public void run()
    {
        quickSort(item, 0, item.size()-1, 1);
        ArrayList sortedForUser = item;
        System.out.println("Your ratings are :");
        for (int i = 0; i < sortedForUser.size(); i++)
            System.out.println(sortedForUser.get(i));
        fullLists.add(sortedForUser);
    }
    
    public void aggregate()
    {
        quickSort(item, 0, item.size()-1, 2);
        ArrayList fullSort = item;
        System.out.println("The full ratings are :");
        for (int i = 0; i < fullSort.size(); i++)
            System.out.println(fullSort.get(i));
    }
    
    public boolean query(String first, String second, int type)
    {
	scan = new Scanner(System.in);

        if(type == 1)
        {
            System.out.println(question);
            System.out.println("(1) " + first + " or (2) " + second + "?");
            int response = scan.nextInt();
		
            while (response != 1 && response != 2)
            {
                System.out.println("Please select (1) or (2).");
                response = scan.nextInt();
            }
		
            if (response == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            int firstIsGreater = 0;
            for (int i = 0; i < fullLists.size(); i++)
            {
                if(fullLists.get(i).indexOf(first) > fullLists.get(i).indexOf(2))
                    firstIsGreater++;
            }
            if (firstIsGreater <= fullLists.size()/2)
                return false;
            else
                return true;
        }
    }
    
    public String toString()
    {
        return title;
    }
    
    // Quicksort algorithm (from Java Foundations)
    public void quickSort(ArrayList<String> data, int min, int max, int type)
    {
        int pivot;
        if(min < max)
        {
            pivot = partition(data, min, max, type);
            quickSort(data, min, pivot-1, type);
            quickSort(data, pivot+1, max, type);
        }
    }
    
    private int partition(ArrayList<String> data, int min, int max, int type)
    {
        String partitionValue = data.get((min + max)/2).toString();
        int left = min;
        int right = max;
        while (left < right)
        {
            while(!query(data.get(left), partitionValue, type) && left < right)
            {
                left++;
            }
            while(query(data.get(right), partitionValue, type))
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
    
    public void swap(ArrayList<String> data, int index1, int index2)
    {
        String temp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, temp);
    }
}
