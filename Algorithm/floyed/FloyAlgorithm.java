package Algorithm.floyed;

import java.util.Arrays;

public class FloyAlgorithm
{
	public static void main(String[] args)
	{
		// 测试看看图是否创建成功
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		//创建邻接矩阵
		int[][] matrix = new int[vertex.length][vertex.length];
		final int N = 65535;
		matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
		matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
		matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
		matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
		matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
		matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
		matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };
		
		//创建 Graph 对象
		Graph graph = new Graph( vertex, vertex.length, matrix);
		//调用弗洛伊德算法
		graph.floyed();
		graph.show();
	}
}
class Graph
{
	private char[] vretex;
	private int[][]  dis;//保存各个顶点出发到其他顶点的距离
	private int[][] pre;//到达各个顶点的前驱
	public Graph(char[] vretex,int length, int[][] matrix)
	{
		super();
		this.vretex = vretex;
		this.dis = matrix;
		this.pre = new int[length][length];
		//pre里记录的是下标
		for (int i = 0; i < length; i++)
		{
			Arrays.fill(pre[i], i);
		}
	}
	public void show() 
	{
		//为了显示便于阅读，我们优化一下输出
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		for (int k = 0; k < dis.length; k++) 
		{
			// 先将pre数组输出的一行
			for (int i = 0; i < dis.length; i++) {
				System.out.print(vertex[pre[k][i]] + " ");
			}
			System.out.println();
			// 输出dis数组的一行数据
			for (int i = 0; i < dis.length; i++) {
				System.out.print("("+vertex[k]+"到"+vertex[i]+"的最短路径是" + dis[k][i] + ") ");
			}
			System.out.println();
			System.out.println();
		}
	}
	public void floyed() 
	{
		int len = 0;
		//对中间顶点的遍历
		for (int k = 0; k < dis.length; k++)
		{
			//从i顶点开始出发
			for (int i = 0; i < dis.length; i++)
			{
				//遍历终点
				for (int j = 0; j < dis.length; j++)
				{
					len = dis[i][k] + dis[k][j];
					if(len < dis[i][j]) 
					{
						dis[i][j] = len;//更新距离
						pre[i][j] = pre[k][j];//更新前驱

					}
					
				}
			}
		}
	}
	
}