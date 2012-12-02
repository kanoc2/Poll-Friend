import java.util.*;

public class PollFriend
{
    public static void main (String[] args)
    {
        boolean admin = false;
        Scanner sc = new Scanner(System.in);
        String select;
        int pollNo;

        System.out.print("User Name: ");
        String user = sc.next();
	
        Poll[] allPolls;
        Poll currentPoll;

        if (user.equals("admin");
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
                System.out.println();
                System.out.println("Thank you for taking " + currentPoll.toString());
            }

            System.out.print("User Name: ");
            user = sc.next();
        }
	
        System.out.println();
        System.out.println("Which poll would you like to view?");
        select = sc.next();
        pollNo = -1;
        for (int k = 0; k < allPolls.length; k++)
        {
            if (select.equals(allPolls[j].toString()))
                pollNo = k;
        }

        if(pollNo == -1)
            System.out.println("Good-bye");
        else
            allPolls[pollNo].aggregate();
    }
}