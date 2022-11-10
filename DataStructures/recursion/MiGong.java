package DataStructures.recursion;

public class MiGong
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//创建一个二维数组模拟迷宫
		int[][] map = new int[8][7];
		//用一表示边界
		for(int i = 0; i < 7; i++) 
		{
			map[0][i] = 1;
			map[7][i] = 1;
		}	
		for (int i = 0; i < 8; i++)
		{
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		setway(map,1,1);
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
			
		}
	}
	
	//map为地图
		//i,j表示出发位置
		//如果小球能到map[6][5]位置则表示找到终点
		//当地图的map[i][j]为0时表示该路径为探索,为3时表示走不通,2时表示可以走
		public static boolean setway(int[][] map, int i, int j) 
		{
			if(map[6][5]  == 2) 
			{
				return true;
			}else if(map[i][j] == 0) 
			{
				map[i][j] = 2;
				if(setway(map,i++,j)) 
				{
					return true;
				}else if(setway(map,i,j++))
				{
					return true;
				}else if(setway(map,i--,j))
				{
					return true;
				}else if(setway(map,i,j--))
				{
					return true;
				}else 
				{
					map[i][j] = 3;
					return false;
				}
			}else 
			{
				return false;
			}
		
		}
		
}
