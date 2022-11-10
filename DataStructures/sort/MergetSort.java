package DataStructures.sort;

public class MergetSort
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		int[] arr = {8,4,5,7,1,3,6,2};

	}
	public static void margeSort(int[] arr, int left,int right,int[] temp) 
	{
		if(left < right) 
		{
			int mid = (left + right) / 2;
			margeSort(arr, left, mid, temp);
			margeSort(arr, mid, right, temp);
			marge(arr, left, mid, right, temp);
		}
	}
	public static void marge(int[] arr, int left, int mid ,int right,int[] temp) 
	{
		int i = left;//左边有序序列的初始索引
		int j = mid + 1;//右边有序序列的初始索引
		int t = 0;//指向合并数组的索引(即temp)
		//先把左右两边(有序)的数据按规则依次填充到temp
		//直到有一边没有数据为止
		while(i <= mid && j <= right) 
		{
			if(arr[i] <= arr[j]) 
			{
				temp[t] = arr[i];
				i++;
				t++;
			}else 
			{
				temp[t] = arr[j];
				j++;
				t++;
			}
		}
		//把剩余数据全部输入temp数组中
		while(i <= mid) 
		{
			temp[t] = arr[i];
			t++;
			i++;
		}
		
		while(j <= right) 
		{
			temp[t] = arr[j];
			t++;
			j++;
		}
		//把temp拷贝到arr中
		t = 0;
		int templeft = left;
		while(templeft <= right) 
		{
			arr[templeft] = temp[t];
			t++;
			templeft++;
		}
		
	}
}
