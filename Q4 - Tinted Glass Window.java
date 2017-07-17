import java.util.*;

public class Main {
	
	public static int T;
	public static int N;
	public static int rect[][];
	public static Scanner sc;
	public static final int NUM_DIMENSIONS = 5;
	public static Set<Integer> yValues;
	public static final int OFFSET = 1;
	public static long area;
	public static Iterator<Integer> xIter, yIter;
	
	
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		TGW();
	}
	
	public static void initialize()
	{
		area = 0;
		N = Integer.valueOf(sc.nextLine());
		T = Integer.valueOf(sc.nextLine());
		ArrayList<Integer> xVal = new ArrayList<>(2*N);
		ArrayList<Integer> yVal = new ArrayList<>(2*N);
		rect = new int[N][NUM_DIMENSIONS];
		for(int x = 0; x < rect.length; x++)
		{
			String[] s = sc.nextLine().split(" ");
			rect[x][0] = Integer.valueOf(s[0]);
			rect[x][1] = Integer.valueOf(s[1]);
			rect[x][2] = Integer.valueOf(s[2]);
			rect[x][3] = Integer.valueOf(s[3]);
			rect[x][4] = Integer.valueOf(s[4]);
			xVal.add(rect[x][0]);
			xVal.add(rect[x][2]);
			yVal.add(rect[x][1]);
			yVal.add(rect[x][3]);
		}
		Set<Integer> xValues = new LinkedHashSet<>();
		yValues = new LinkedHashSet<>();
		Collections.sort(xVal);
		Collections.sort(yVal);
		for(int x : xVal)
			xValues.add(x);
		for(int y : yVal)
			yValues.add(y);	
		xIter = xValues.iterator();
		yIter = yValues.iterator();
	}
	
	public static void TGW()
	{
		initialize();
		int bX = 0, aX = 0, bY = 0, aY = 0;
		while(xIter.hasNext())
		{
			aX = bX;
			bX = xIter.next();
			while(yIter.hasNext())
			{
				aY = bY;
				bY = yIter.next();
				int tintVal = 0;
				boolean done = false;
				for(int i = 0; i < rect.length && !done; i++)
				{
					if(rect[i][0] <= aX && rect[i][1] <= aY && aX < rect[i][2] && aY < rect[i][3])
					{
						tintVal += rect[i][4];
						if(tintVal >= T)
						{
							long dx = bX - aX;
							long dy = bY - aY;
							area += dy*dx;
							done = true;
						}
					}
				}
			}
			yIter = yValues.iterator();
		}
		System.out.println(area);
	}
	
}
