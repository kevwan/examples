package self.edu.examples;

public class SubsetSum
{
	public static void main(String[] args)
	{
		int n = 20;
		int[] dyn = new int[1024];

		int s = n * (n + 1);
		if (s % 4 != 0)
		{
			System.out.println(0);
			return;
		}
		s /= 4;
		int i, j;
		dyn[0] = 1;
		for (i = 1; i <= n; ++i)
		{
			for (j = s; j >= i; --j)
			{
				dyn[j] += dyn[j - 1];
			}
			System.out.println(dyn[s] >> 1);
		}
	}
}
