import java.util.*;
/**
 *
 * @author kavan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        partyInvitation();
        // TODO code application logic here
    }
    
    public static void partyInvitation()
    {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> r = new LinkedList();
        LinkedList<Integer> friendList = new LinkedList();
        for(int x = 0; x < m; x++)
            r.add(sc.nextInt());
        for(int x = 1; x <= k; x++)
            friendList.add(x);
        ListIterator<Integer> rIter = r.listIterator();
        while(rIter.hasNext())
        {
            int check = rIter.next();
            int count = 1;
            for(int x = 0; x < friendList.size(); x++)
            {
                if(count % check == 0)
                {
                    friendList.remove(x);
                    x = x - 1;
                }
                count++;
            }
        }
        for(int x = 0; x< friendList.size(); x++)
            System.out.println(friendList.get(x));
    }
    
}
