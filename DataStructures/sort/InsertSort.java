package DataStructures.sort;

import java.util.Arrays;

public class InsertSort
{

	public static void main(String[] args)
	{
		int[] arr = {101,34,224,23,56,76};
		insertSort(arr);

	}
	public static void insertSort(int[] arr) 
	{
		//定义待插入的数
		for (int i = 1; i < arr.length; i++)
		{
		int insertVal = arr[i];
		int insertIndex = i - 1;
		while(insertIndex >= 0 && insertVal < arr[insertIndex]) 
		{
			arr[insertIndex + 1] = arr[insertIndex];
			insertIndex--;
		}
		if(insertIndex + 1 != 1) //优化:如果该数位置没变则不用重复赋值
		{
			arr[insertIndex + 1] = insertVal;
		}
		//arr[insertIndex + 1] = insertVal;
		System.out.println(Arrays.toString(arr));
		}
	}

}
