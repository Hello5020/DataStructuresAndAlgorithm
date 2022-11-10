package Algorithm.dynamic;

public class KnapsackProbiem
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] w = {1,4,3};
		int[] val = {1500,3000,2000};
		int m = 4;
		int n = val.length;
		int[][] v = new int[n+1][m+1];
		for (int i = 0; i < v.length; i++)
		{
			v[i][0] = 0;
		}
		for (int i = 0; i < v[0].length; i++)
		{
			v[0][i] = 0;
		}
		for (int i = 1; i < v.length; i++)
		{
			for (int j = 1; j < v[0].length; j++)
			{
				if(w[i-1] > j) 
				{
					v[i][j] = v[i-1][j];
				}else 
				{
					if(v[i-1][j] > (v[i-1][j-w[i-1]] + val[i-1])) 
					{
						v[i][j] = v[i-1][j];
					}else 
					{
						v[i][j] = v[i-1][j-w[i-1]] + val[i-1];
					}
				}
			}
		}
		for (int i = 0; i < v.length; i++)
		{
			for (int j = 0; j < v[0].length; j++) 
			{
				System.out.print(v[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
