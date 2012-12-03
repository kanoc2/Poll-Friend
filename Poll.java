// Name: Ken Whittaker, Matt Kanoc, Brandon Lewis
// Course: CSC 470, Section 1
// Semester: Fall 2012
// Instructor: Dr. Pulimood
// Collaborative Project: Poll-Friend
// Description: Store all Poll organization and sorting features
// Filename: Poll.java
// Last modified on: 12/3/2012

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
    }
    
    public void run()
    {
        insertionSort(item, 1);
        ArrayList sortedForUser = item;
        System.out.println("Your ratings are :");
        for (int i = 0; i < sortedForUser.size(); i++)
            System.out.println(sortedForUser.get(i));
        fullLists.add(sortedForUser);
    }
    
    public void aggregate()
    {
        insertionSort(item, 2);
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
                return false;
            }
            else
            {
                return true;
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
                return true;
            else
                return false;
        }
    }
    
    public String toString()
    {
        return title;
    }
    
    public void insertionSort (ArrayList<String> data, int type)
    {
        for (int index = 1; index < data.size(); index++)
        {
            String key = data.get(index);
            int position = index;
            
            while (position > 0 && query(data.get(position-1), key, type))
            {
                data.set(position, data.get(position-1));
                position--;
            }
            data.set(position, key);
        }
    }
}
