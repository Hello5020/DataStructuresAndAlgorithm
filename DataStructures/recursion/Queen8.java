package DataStructures.recursion;

public class Queen8
{
	//定义一个max表示有多少皇后
	int max = 8;
	//定义一个数组用于保存结果
	int[] array = new int[max]; 
	public static void main(String[] args)
	{
		

	}
	//当我们放置第n个皇后时判断其是否与前面n-1个皇后位置冲突
	private boolean judge(int n) 
	{
		for (int i = 0; i < n; i++)
		{
			if(array[i] == array[n] || Math.abs(n-1) == Math.abs(array[n] - array[i])) //行差等于列差,判断是否在一条斜线上
			{
				return false;
			}
		}
		return true;
	}
	private void check(int n) 
	{
		if(n == max) 
		{
			print();
			return;
		}
		for (int i = 0; i < max; i++)
		{
			array[n] = i;
			if(judge(n)) 
			{
				check(n++);
			}
		}
	}
	private void print() 
	{
		for (int i = 0; i < array.length; i++)
		{
		System.out.print(array[i] + " ");
		}System.out.println();
		
	}
}
