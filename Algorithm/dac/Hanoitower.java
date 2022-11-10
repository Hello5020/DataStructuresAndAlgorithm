package Algorithm.dac;

public class Hanoitower
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	//汉罗塔移动方法
	public static void hanoiTower(int num ,char a,char b,char c) 
	{
		if(num == 1) 
		{
			System.out.println( a + "->" + c );
		}else 
		{
			hanoiTower(num - 1, a, c, b);
			System.out.println( a + "->" + c );
			hanoiTower(num - 1, b, a, c);
		}
		
	}
}
