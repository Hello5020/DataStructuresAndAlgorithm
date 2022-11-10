package DataStructures.sort;

import java.util.Arrays;

public class HeapSort
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] arr = {4,6,8,5,9};
		heapSort(arr);
	}
	public static void heapSort(int arr[]) 
	{
		int temp = 0;
		for (int i = arr.length / 2 - 1; i >= 0; i--)
		{
			adjustHeap(arr, i, arr.length);
		}
		for (int j = arr.length - 1; j >= 0; j--)
		{
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
	}
	//将一个数组调整成大顶堆
	public static  void adjustHeap(int arr[],int i,int length) 
	{
		//i表示最后一个非叶子节点在数组中的索引
		int temp = arr[i];
		for (int j = i * 2 + 1; j < length; j = j * 2 + 1 )
		{
			if(j + 1 < length && arr[j] < arr[j + 1]) 
			{
				j++;
			}
			if(arr[j] > temp) 
			{
				arr[i] = arr[j];
				i = j;
			}else 
			{
				break;
			}
		}
		arr[i] = temp;
		System.out.println(Arrays.toString(arr));
	}
}
