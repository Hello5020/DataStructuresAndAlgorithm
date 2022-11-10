package DataStructures.sort;


public class RadicSort
{

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		int arr[] = {53,3,542,748,14,214};

	}
	public static void radixSort(int[] arr)
	{
		//定义一个二维数组表示十个桶
		//为了防止溢出,每个桶的大小都定义为arr.length
		int[][] bucket = new int[10][arr.length];
		//每个桶都应该有一个索引,来记录其中有多少个有效数据
		int[] bucketElementCounts = new int[10];
		//得到数组中位数最大的数
		int max = arr[0];
		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i] > max) 
			{
				max = arr[i];
			}
		}
		//得到位数
		int maxLength = (max + "").length();
		for(int l = 0,n = 1; l < maxLength; l++,n *= 10 ) {
		for (int i = 0; i < bucketElementCounts.length; i++)
		{
			//取出每个元素的个位
			int digitOfElement = arr[i] / n % 10;
			//放入到对应桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
			bucketElementCounts[digitOfElement]++;
		}
		//按桶的顺序将数取出放到原数组
		int index = 0;
		for (int k = 0; k < bucketElementCounts.length; k++)
		{
			//如果桶里有数据才取出
			if(bucketElementCounts[k] != 0) 
			{
				for (int j = 0; j < bucketElementCounts[k]; j++)
				{
					arr[index] = bucket[k][j];
					index++;
				}
				//进行一次处理后需要将bucketElementCounts[i]置为0
				bucketElementCounts[k] = 0;
			}
		}
	}
		}
}
