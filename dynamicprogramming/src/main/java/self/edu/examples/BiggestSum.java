package self.edu.examples;

public class BiggestSum
{
	public static void main(String[] args)
	{
		int[][] triangle = new int[][] {
				{ 7 },
				{ 3, 8 },
				{ 8, 1, 0 },
				{ 2, 7, 4, 4 },
				{ 4, 5, 2, 6, 5 }
		};
		int[][] cache = new int[5][5];
//		path(triangle, 4, 0, cache);
//		path(triangle, 4, 1, cache);
//		path(triangle, 4, 2, cache);
//		path(triangle, 4, 3, cache);
//		path(triangle, 4, 4, cache);
//		for (int i = 0; i < 5; ++i)
//		{
//			System.out.println(cache[4][i]);
//		}
//
//		for (int[] element : cache)
//		{
//			for (int element2 : element)
//			{
//				System.out.print(element2 + " ");
//			}
//			System.out.println();
//		}

		System.out.println(pathFromBottom(triangle, 0, 0, cache));
	}

	private static int path(int[][] triangle, int i, int j, int[][] cache)
	{
		if (j > i || i < 0 || j < 0)
		{
			return 0;
		}
		if (i == 0 && j == 0)
		{
			cache[0][0] = triangle[0][0];
			return triangle[0][0];
		}
		if (cache[i][j] != 0)
		{
			return cache[i][j];
		}
		cache[i][j] = triangle[i][j] + Math.max(path(triangle, i-1, j-1, cache), path(triangle, i-1, j, cache));
		return cache[i][j];
	}

	private static int pathFromBottom(int[][] triangle, int i, int j, int[][] cache)
	{
		if (i == triangle.length - 1)
		{
			cache[i][j] = triangle[i][j];
		}
		else if (cache[i][j] == 0)
		{
			cache[i][j] = triangle[i][j] + Math.max(pathFromBottom(triangle, i+1, j, cache), pathFromBottom(triangle, i+1, j+1, cache));
		}
		return cache[i][j];
	}
}
