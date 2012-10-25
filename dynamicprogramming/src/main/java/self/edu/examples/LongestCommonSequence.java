package self.edu.examples;


public class LongestCommonSequence
{
	public static void main(String[] args)
	{
//		char[] a = new char[] { 'a', 'b', 'c', 'd', 'e' };
//		char[] b = new char[] { 'a', 'c', 'e', 'f' };
		char[] a = "hcjkhsndpdxaborewdnd".toCharArray();
		char[] b = "mvqemxiwggijlvybeyav".toCharArray();

//		char[] a = "abcadef".toCharArray();
//		char[] b = "bcde".toCharArray();
//		System.out.println(lcs_len(a, b));
		int[][] cache = new int[a.length][b.length];
		for (int i = 0; i < cache.length; ++i)
		{
			for (int j = 0; j < cache[0].length; ++j)
			{
				cache[i][j] = -1;
			}
		}
		System.out.println(f(a, b, a.length-1, b.length-1, cache));
	}

	private static void display(int[][] b, char[] x, int i, int j)
    {
        if (b[i][j] == 1)
        {
        	System.out.print(x[i] + " ");
        	if (i != 0 && j != 0)
        		display(b, x, i-1, j-1);
        }
        else if(b[i][j] == 0)
        {
        	if (i != 0 && j != 0)
        		display(b, x, i-1, j);
        }
        else if(b[i][j] == -1)
        {
        	if (i != 0 && j != 0)
        		display(b, x, i, j-1);
        }
    }

	private static int f(char[] a, char[] b, int i, int j, int[][] cache)
	{
		if (i < 0 || j < 0)
		{
			return 0;
		}
		if (i == 0 && j == 0)
		{
			return same(a, b, 0, 0);
		}
		if (cache[i][j] != -1)
		{
			return cache[i][j];
		}
		cache[i][j] = Math.max(Math.max(f(a, b, i-1, j-1, cache) + same(a, b, i, j), f(a, b, i-1, j, cache)), f(a, b, i, j-1, cache));
		return cache[i][j];
	}

    private static int lcs_len(char[] a, char[] b)
	{
		Long startTime = System.nanoTime();
		int len1 = a.length;
		int len2 = b.length;
		int[][] len = new int[len1][len2];
		int[][] route = new int[len1][len2];
		for (int i = 0; i < len1; ++i)
		{
			for (int j = 0; j < len2; ++j)
			{
				if (a[i] == b[j])
				{
					len[i][j] = i == 0 || j == 0 ? 1 : len[i-1][j-1] + 1;
					route[i][j] = 1;
				}
				else
				{
					len[i][j] = i == 0 || j == 0 ? 0 : len[i][j-1] >= len[i-1][j] ? len[i][j-1] : len[i-1][j];
					route[i][j] = i == 0 || j == 0 ? 0 : len[i][j-1] >= len[i-1][j] ? -1 : 0;
				}
			}
		}
//		print(a, b, len);
//		printLCS(a, route);
//		print(a, b, route);
		display(route, a, len1-1, len2-1);
		System.out.println(" Totle time is " + (System.nanoTime() - startTime) + " ns");
		return len[len1-1][len2-1];
	}

	private static void print(char[] a, char[] b, int[][] lcs)
	{
		System.out.print("  ");
		for (char element : a)
		{
			System.out.print(element);
			System.out.print(' ');
		}
		System.out.println();
		for (int i = 0; i < b.length; ++i)
		{
			System.out.print(b[i]);
			System.out.print(' ');
			for (int j = 0; j < a.length; ++j)
			{
				System.out.print(lcs[j][i]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	private static void printLCS(char[] s, int[][] route)
	{
		for (int i = 0; i < route.length; ++i)
		{
			for (int j = 0; j < route[0].length; ++j)
			{
				if (route[i][j] == 1)
				{
					System.out.print(s[i]);
				}
			}
		}
		System.out.println();
	}

	private static void printRoute(int[][] route)
	{
		for (int[] element : route)
		{
			for (int j = 0; j < route[0].length; ++j)
			{
				System.out.print(element[j] + " ");
			}
			System.out.println();
		}
	}

	private static int same(char[] a, char[] b, int i, int j)
	{
		return a[i] == b[j] ? 1 : 0;
	}
}
