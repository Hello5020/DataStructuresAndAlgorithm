package DataStructures.sort;

import java.util.Arrays;

public class ShellSort
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] arr = {8,9,1,7,2,3,5,4,6,0};
		shellSort2(arr);
	}
	//使用逐步推导的方式来写
	public static void shellSort(int[] arr) 
	{
		int temp = 0;
		//第一轮排序是将10个数据分为5组
		for (int gap = arr.length / 2; gap > 0; gap /= 2)
		{
			for(int i = gap; i< arr.length; i++) 
			{
				for (int j = i - gap; j >= 0; j -= gap)
				{
					//如果当前元素小于步长后元素
					if(arr[j] > arr[j + gap]) 
					{
						 temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					} 
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	//优化
	public static void shellSort2(int[] arr) 
	{
		int temp = 0;
		//第一轮排序是将10个数据分为5组
		for (int gap = arr.length / 2; gap > 0; gap /= 2)
		{
			for(int i = gap; i< arr.length; i++) 
			{
				int j = i;
				temp = arr[j];
					while(j - gap >= 0 && temp < arr[j - gap]) 
					{
						arr[j] = arr[j - gap];
						j -= gap;
					}
					arr[j] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
