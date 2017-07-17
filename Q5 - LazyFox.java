import java.util.*;

public class Main {

	public static int[][] points;
	public static int distances[][];
	public static int size;
	public static Scanner sc;
	public static final int ORIGIN = 0;
	
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		lazyFox();
	}
	
	public static void initialize()
	{
		size = sc.nextInt();
		sc.nextLine();
		points = new int[size + 1][2];
		distances = new int[points.length * (points.length - 1) /2][3];
		for(int x = 1; x < points.length; x++){
			String[] s = sc.nextLine().split(" ");
			points[x][0] = Integer.valueOf(s[0]);
			points[x][1] = Integer.valueOf(s[1]);
		}
		int currentEdge = 0;
		for(int i = 0; i < points.length; i++)
		{
			for(int j = i + 1; j < points.length; j++)
			{
				int dx = points[i][0] - points[j][0];
				int dy = points[i][1] - points[j][1];
				distances[currentEdge][0] = dx*dx + dy*dy;
				distances[currentEdge][1] = i;
				distances[currentEdge][2] = j;
				currentEdge++;
			}
		}
		Arrays.sort(distances, new Comparator<int[]>()
		{
			public int compare(int[] i, int[] j){
				return i[0] - j[0];
			}
		});
	}
	public static void lazyFox()
	{
		initialize();
		int[][] dp = new int[points.length][2];
		int[] maxPath = new int[points.length];
		for(int path = 0; path < distances.length; path++)
		{
			int a = distances[path][1];
			int b = distances[path][2];
			int currA = dp[a][0];
			int prevA = dp[a][1];
			int currB = dp[b][0];
			int prevB = dp[b][1];
			if(a == ORIGIN)
			{
				dp[a][0] = Math.max(currA, 1 + currB);
			}
			else
			{
				if(maxPath[b] < distances[path][0])
				{
					if(currA <= currB)
						dp[a][0] = 1 + currB;
					dp[b][1] = currB;
				}
				else
				{
					if(currA <= prevB)
						dp[a][0] = 1 + prevB;
				}
				if(maxPath[a] < distances[path][0])
				{
					if(currB <= currA)
						dp[b][0] = 1 + currA;
					dp[a][1] = currA;
				}
				else
				{
					if(currB <= prevA)
					{
						dp[b][0] = 1 + prevA;
					}
				}
			}
			maxPath[a] = maxPath[b] = distances[path][0];
		}
		System.out.println(dp[0][0]);	
	}
}
