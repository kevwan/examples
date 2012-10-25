package self.edu.examples;

public class MemorySearch
{
	private static final int[][] a = {
			{ 1 },
			{ 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9, 10}
	};

	public static void main(String[] args)
	{
		System.out.println(f(3, 3, a));
	}

	private static int f(int i, int j, int[][] a)
	{
		int f1, f2, tmp = 0, k;
		if (i == 0 || j == 0)
			return a[0][0];
		if (j == i)
		{
			for (k = 0; k <= i; k++)
				tmp += a[k][k];
			return tmp;
		}
		f1 = f(i-1, j, a);
		f2 = f(i, j-1, a);
		return f1 < f2 ? f2 + a[i][j] : f1 + a[i][j];
	}
}
