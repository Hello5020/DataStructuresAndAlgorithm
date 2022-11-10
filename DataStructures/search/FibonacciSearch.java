package DataStructures.search;

import java.util.Arrays;

public class FibonacciSearch
{
	public static int maxSize = 20;
	public static void main(String[] args)
	{
		int[] arr = {1,8,10,89,1000,1234}; 
		fibonacciSearch(arr, 8);
		
	}
	//因为查找方法中要用到斐波那契数列所以需要先构建斐波那契数列
	public static int[] fibonacci() 
	{
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < f.length; i++)
		{
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}
	public static int  fibonacciSearch(int[] arr,int fingVal)
	{
		int low = 0;
		int high = arr.length - 1;
		int k = 0;//表示斐波那契分割数值的下标
		int mid = 0;
		int[] f = fibonacci();
		while(high > f[k] - 1) 
		{
			k++;
		}
		//因为f[k]的值可能大于arr的长度,因此我们需要使用Arrays类,构造一个新的数组,并指向arr[]
		//不足的部分用0补充
		int[] temp = Arrays.copyOf(arr, f[k]);
		//需要使用arr数组的最后一个数来填充temp
		for (int i = high + 1; i < temp.length; i++)
		{
			temp[i] = arr[high];
		}
		while(low <= high) 
		{
			mid = low + f[k - 1] - 1;
			if(fingVal < temp[mid]) 
			{
				high = mid - 1;
				//全部元素 = 前面元素 + 后面元素
				//f[k] = f[k - 1] + f[k - 2]
				//因为前面有f[k - 1]个元素,所以可以继续拆分f[k - 1] = f[k - 2] + f[k - 3]
				//即在f[k - 1]的前面继续查找k--
				//即下次循环 mid = f[k-1-1]-1
				k--;
			}else if(fingVal > temp[mid]) 
			{
				low = mid + 1;
				//全部元素 = 前面元素 + 后面元素
				//f[k] = f[k - 1] + f[k - 2]
				//因为后面有f[k - 2]个元素,所以可以继续拆分f[k - 2] = f[k - 3] + f[k - 4]
				//即在f[k - 2]的前面继续查找k-=2
				//即下次循环 mid = f[k-1-2]-1
				k -= 2;
			}else 
			{
				//需要确定返回的是那个下标
				if(mid <= high) 
				{
					return mid;
				}else
				{
					return high;
				}
			}
		}
		return -1;
	}
}
