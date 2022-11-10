package DataStructures.search;

public class SeqSearch
{

	public static void main(String[] args)
	{
		int arr[] = {9,1,11,-1,34,89};
		int index = seqSearch(arr, 11);
		System.out.println(index);
	}
	public static int seqSearch(int[] arr,int value) 
	{
		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i] == value) 
			{
				return i;
			}
		}
		return -1;
	}
}
