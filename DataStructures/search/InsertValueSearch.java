package DataStructures.search;

public class InsertValueSearch
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = i + 1;
		}

	}
	public static int insertValueSearch(int[] arr,int left,int right,int findVal) 
	{
		if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) 
		{
			return -1;
		}
		int mid = left + (findVal - arr[left]) / (arr[right] - arr[left]) * (right - left);
		int midVal =  arr[mid];
		if(findVal > midVal) 
		 {
			 return insertValueSearch(arr, mid + 1, right, findVal);
		 }else if(findVal < midVal)
		 {
			 return insertValueSearch(arr, left, mid - 1, findVal);
		 }else 
		 {
			 return mid;
		 }
	}
}
