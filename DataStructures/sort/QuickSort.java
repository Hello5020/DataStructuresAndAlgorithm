package DataStructures.sort;

public class QuickSort
{

	public static void main(String[] args)
	{
		

	}
	public static void quickSort(int[] arr,int left,int right) 
	{
		int l = left;
		int r = right;
		//pivot是中轴
		int pivot = arr[(left + right) / 2];
		int temp = 0;
		while(l < r) //循环目的是进行分组
		{
			while(arr[l] < pivot) 
			{
				l++;
			}
			while(arr[r] > pivot) 
			{
				r--;
			}
			if( l >= r) 
			{
				break;
			}
			//交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			if(arr[l] == pivot) 
			{
				r--;
			}
			if(arr[r] == pivot) 
			{
				l++;
			}
		}
		if(l == r) 
		{
			l++;
			r--;
		}
		if(left < r) 
		{
			quickSort(arr, left, r);
		}
		if(right > l) 
		{
			quickSort(arr, l, right);
		}
	}

}
