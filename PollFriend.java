import java.util.*;
import java.io.*;

public class PollFriend
{
    public static void main (String[] args) throws IOException
    {
        boolean admin = false;
        Scanner sc = new Scanner(System.in);
        String select;
        int pollNo;

        System.out.print("User Name: ");
        String person = sc.next();
	user csuser;

        Poll[] allPolls;
        Poll currentPoll = null;

	allPolls = new Poll[3];
	allPolls[0] = new Poll(new File("sportsData.txt"), "Sports", "Which is more fun?");
	allPolls[1] = new Poll(new File("fruitData.txt"), "Fruit", "Which tastes better?");
	allPolls[2] = new Poll(new File("socialNetworkData.txt"), "Web", "Which wastes more time?");

	File f = new File(person + ".txt");
	if (f.exists())
		csuser = new user(person);
	else
		csuser = new user(); 
		
	
        if (person.equals("admin"))
            admin = true;
	
        while (!admin)
        {
            System.out.println("Which poll would you like to take?");
            for (int i = 0; i < allPolls.length; i++)
                System.out.println("\t" + allPolls[i].toString());
	    
            select = sc.next();
            pollNo = -1;

            for (int j = 0; j < allPolls.length; j++)
            {
                if (select.equals(allPolls[j].toString()))
                    pollNo = j;
            }

            if (pollNo == -1)
            {
                System.out.println("That is not the name of a poll currently in our database.");
                System.out.println("Please e-mail us and complain.");
            }
            else
            {
                currentPoll = allPolls[pollNo];
                currentPoll.run();
                System.out.println("Thank you for taking " + currentPoll.toString());
                System.out.println();
            }

            System.out.print("User Name: ");
            person = sc.next();
	    
            f = new File(person + ".txt");
            if (f.exists())
		csuser = new user(person);
	    else
		csuser = new user();
        }
	
        System.out.println();
        System.out.println("Which poll would you like to view?");
        select = sc.next();
        pollNo = -1;
        for (int k = 0; k < allPolls.length; k++)
        {
            if (select.equals(allPolls[k].toString()))
                pollNo = k;
        }

        if(pollNo == -1)
            System.out.println("Good-bye");
        else
            allPolls[pollNo].aggregate();
    }
}
