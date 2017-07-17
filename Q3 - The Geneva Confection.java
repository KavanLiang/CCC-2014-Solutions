import java.util.*;
/**
 *
 * @author kavan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    private static Stack<Integer> branch; 
    private static Stack<Integer> mountain;
    private static LinkedList<String> solution;
    private static int search;
    private static Scanner sc;
    private static int T;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        T = sc.nextInt();
        solution = new LinkedList();
        for(int x = 0; x < T; x++)
            test();
        for(int x = 0; x < solution.size(); x++)
            System.out.println(solution.get(x));
        // TODO code application logic here
    }
    
    public static void test()
    {
        mountain = new Stack();
        branch = new Stack();
        int N = sc.nextInt();
        for(int x = 0; x < N; x++)
        {
            mountain.push(sc.nextInt());
        }
        search = 1;
        shift();
    }
    public static void shift()
    {
        if(mountain.isEmpty() && branch.isEmpty())
        {
            solution.add("Y");
        }
        else if(!branch.isEmpty() && mountain.isEmpty())
        {
            if(branch.peek() == search)
            {
                branch.pop();
                search++;
                shift();
            }
            else
                solution.add("N");
        }
        else if(!mountain.isEmpty())
        {
            if(mountain.peek() == search)
            {
                mountain.pop();
                search++;
            }
            else if(!branch.isEmpty() && branch.peek() == search)
            {
                branch.pop();
                search++;
            }
            else
                branch.push(mountain.pop());
            shift();
        }
    }
}
