package self.edu.examples;

import java.util.Random;

public class LCS
{
	// 取得定长随机字符串
	public static String GetRandomStrings(int length)
	{
		StringBuffer buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++)
		{
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		// 设置字符串长度
		int substringLength1 = 20;
		int substringLength2 = 20; // 具体大小可自行设置
		// 随机生成字符串
//		String x = GetRandomStrings(substringLength1);
//		String y = GetRandomStrings(substringLength2);
		String x = "hcjkhsndpdxaborewdnd";
		String y = "mvqemxiwggijlvybeyav";
		Long startTime = System.nanoTime();
		// 构造二维数组记录子问题x[i]和y[i]的LCS的长度
		int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];
		// 动态规划计算所有子问题
		for (int i = substringLength1 - 1; i >= 0; i--)
		{
			for (int j = substringLength2 - 1; j >= 0; j--)
			{
				if (x.charAt(i) == y.charAt(j))
					opt[i][j] = opt[i + 1][j + 1] + 1; // 参考上文我给的公式。
				else
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]); // 参考上文我给的公式。
			}
		}
		System.out.println("substring1:" + x);
		System.out.println("substring2:" + y);
		System.out.print("LCS:");
		int i = 0, j = 0;
		while (i < substringLength1 && j < substringLength2)
		{
			if (x.charAt(i) == y.charAt(j))
			{
				System.out.print(x.charAt(i));
				i++;
				j++;
			}
			else if (opt[i + 1][j] >= opt[i][j + 1])
				i++;
			else
				j++;
		}
		Long endTime = System.nanoTime();
		System.out.println(" Totle time is " + (endTime - startTime) + " ns");
	}
}