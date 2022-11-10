package Algorithm.kmp;

public class KMPAlgorithm
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	//获取到一个字符串(子串)的部分匹配值
	public static int[] kmpNext(String dest)
	{
		//创建一个next数组用于返回与存放结果
		int[] next = new int[dest.length()];
		next[0] = 0;//如果字符串长度为1 部分匹配值就是0
		for (int i = 1,j = 0; i < dest.length(); i++)
		{
			//当dest.charAt(i) != dest.charAT(j),我们需要从next[j-1]获取新的j
			//直到我们发现有dest.charAt(i) == dest.charAt(j)时停止
			while(dest.charAt(i) != dest.charAt(j) && j > 0) //kmp算法的核心
			{
				j = next[j - 1];
			}
			if(dest.charAt(i) == dest.charAt(j)) 
			{
				j++;
			}
			next[i] = j;
		}
		return next;
	}
	public static int kmpSearch(String str1, String str2, int[] next) 
	{
		//遍历
		for (int i = 0,j = 0; i < str1.length(); i++)
		{
			while(str1.charAt(i) != str2.charAt(j) && j > 0) 
			{
				j = next[j - 1];
			}
			if(str1.charAt(i) == str2.charAt(j)) 
			{
				j++;
			}
			if(j == str2.length()) 
			{
				return i - j + 1;
			}
		}
		return -1;
	}
	
}
