import java.util.*;
/**
 *
 * @author kavan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        String[] firstRow = sc.nextLine().split(" ");
        String[] secondRow = sc.nextLine().split(" ");
        checkPartners(firstRow, secondRow);
        
        // TODO code application logic here
    }
    
    public static void checkPartners(String[] first, String[] second)
    {
        for(int x = 0; x < N; x++)
        {
            String a = first[x];
            String c = second[x];
            for(int y = 0; y < N; y++)
            {
                String b = second[y];
                if(b.equals(a))
                {
                    int index = y;
                    if(index == x)
                    {
                        System.out.println("bad");
                        return;
                    }
                    else if(!first[index].equals(c))
                    {
                        System.out.println("bad");
                        return;
                    }
                }
            }
        }
        System.out.println("good");
    }
}
