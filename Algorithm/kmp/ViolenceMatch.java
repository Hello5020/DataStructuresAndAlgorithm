package Algorithm.kmp;

public class ViolenceMatch
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	public static int violenceMatch(String str1, String str2 ) 
	{
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int s1Len = s1.length;
		int s2Len = s2.length;
		int i = 0; 
		int j = 0;
		while(i < s1Len && j < s2Len) //作用为保证数组不越界
		{
			if(s1[i] == s2[j]) 
			{
				i++;
				j++;
			}else 
			{
				i = i - (j - 1);
				j = 0;
			}
		}
		if(j == s2Len) 
		{
			return i - j;
		}else 
		{
			return 0;
		}
	}
}
