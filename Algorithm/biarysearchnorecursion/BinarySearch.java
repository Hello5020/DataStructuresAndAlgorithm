package Algorithm.biarysearchnorecursion;

public class BinarySearch
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	public static int binarySearch(int[] arr, int target) 
	{
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) 
		{
			int mid = (left + right) / 2;
			if(arr[mid] == target) 
			{
				return mid;
			}else if(arr[mid] > target) 
			{
				right = mid - 1;
			}else 
			{
				left = mid + 1;
			}
		}
		return 0;
	}
}
