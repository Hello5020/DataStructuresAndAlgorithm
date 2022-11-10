package DataStructures.sort;

import java.util.Arrays;

public class SelectSort
{

	public static void main(String[] args)
	{
		int[] arr = {101,34,119,1}; 
		selectSort(arr);

	}
	public static void selectSort(int[] arr) 
	{
		for (int j = 0; j < arr.length-1; j++)
		{int index = j;
		int min = arr[j];
		for (int i = j+1; i < arr.length; i++)
		{
			if(min > arr[i])// 从大到小改为min < arr[i]
			{
				min = arr[i];
				index = i;
			}
		}
		
		arr[index] = arr[j];
		arr[j] = min;
		System.out.println(Arrays.toString(arr));
		}
	}
}
