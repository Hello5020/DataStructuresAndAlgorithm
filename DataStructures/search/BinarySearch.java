package DataStructures.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] arr = {1,8,10,89,1000,1234};
		int index = binarySearch(arr, 0, arr.length - 1, 10);
		System.out.println(index);
	}
 public static int binarySearch(int[] arr,int left,int right,int findVal) 
 {
	 int mid = (left + right) / 2;
	 int midVal = arr[mid];
	 if(left > right) 
	 {
		 return -1;
	 }
	 if(findVal > midVal) 
	 {
		 return binarySearch(arr, mid + 1, right, findVal);
	 }else if(findVal < midVal)
	 {
		 return binarySearch(arr, left, mid - 1, findVal);
	 }else 
	 {
		 return mid;
	 }
 }
 //可查找多个的方法
 public static ArrayList<Integer> binarySearch2(int[] arr,int left,int right,int findVal) 
 {
	 int mid = (left + right) / 2;
	 int midVal = arr[mid];
	 if(left > right) 
	 {
		 return null;
	 }
	 if(findVal > midVal) 
	 {
		 return binarySearch2(arr, mid + 1, right, findVal);
	 }else if(findVal < midVal)
	 {
		 return binarySearch2(arr, left, mid - 1, findVal);
	 }else 
	 {
		 List<Integer> resIndexlist = new ArrayList<Integer>();
		 int temp = mid - 1;
		 while(true) 
		 {
			 if(temp < 0 || arr[temp] != findVal) 
			 {
				 break;
			 }
			 resIndexlist.add(temp);
			 temp--;
		 }
		 resIndexlist.add(mid);
		 while(true) 
		 {
			 if(temp > arr.length || arr[temp] != findVal) 
			 {
				 break;
			 }
			 resIndexlist.add(temp);
			 temp++;
		 }
		 return (ArrayList<Integer>) resIndexlist;
	 }
 }
}
