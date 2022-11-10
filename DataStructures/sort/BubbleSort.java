package DataStructures.sort;

import java.util.Arrays;

public class BubbleSort
{

	public static void main(String[] args)
	{
		//int[] arr = {3,  9, -1, 10, -2};
		int[] arr = {1,2,3,4,5,6};
		boolean flag = false;
		int temp = 0;
		for (int j = 0; j < arr.length - 1; j++)
		{
				flag = false;
		for (int i = 0; i < arr.length - 1; i++)
		{
			if(arr[i] > arr[i + 1]) 
			{
				flag = true;
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		System.out.println("第"+(j + 1)+"次排序后的数组:" + Arrays.toString(arr));
		if(flag == false) 
		{
			break;
		}
		}
		
	}
//		for (int i = 0; i < arr.length - 2; i++)
//		{
//			if(arr[i] > arr[i + 1]) 
//			{
//				temp = arr[i];
//				arr[i] = arr[i + 1];
//				arr[i + 1] = temp;
//			}
//		}
//		System.out.println("第2次排序后的数组:" + Arrays.toString(arr));
//		for (int i = 0; i < arr.length - 3; i++)
//		{
//			if(arr[i] > arr[i + 1]) 
//			{
//				temp = arr[i];
//				arr[i] = arr[i + 1];
//				arr[i + 1] = temp;
//			}
//		}
//		System.out.println("第3次排序后的数组:" + Arrays.toString(arr));
//		for (int i = 0; i < arr.length - 4; i++)
//		{
//			if(arr[i] > arr[i + 1]) 
//			{
//				temp = arr[i];
//				arr[i] = arr[i + 1];
//				arr[i + 1] = temp;
//			}
//		}
//		System.out.println("第4次排序后的数组:" + Arrays.toString(arr));
//	}
//	

}
