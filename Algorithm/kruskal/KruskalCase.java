package Algorithm.kruskal;

import java.util.Arrays;

public class KruskalCase
{
	private int edgeNum;//记录边的数目
	private char[] vertexs;
	private int[][] matrix;//邻接矩阵
	private static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args)
	{
		char[] vertexs = {'A','B','C','D','E','F','G'};
		int matrix[][] = {
			      /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
			/*A*/ {   0,  12, INF, INF, INF,  16,  14},
			/*B*/ {  12,   0,  10, INF, INF,   7, INF},
			/*C*/ { INF,  10,   0,   3,   5,   6, INF},
			/*D*/ { INF, INF,   3,   0,   4, INF, INF},
			/*E*/ { INF, INF,   5,   4,   0,   2,   8},
			/*F*/ {  16,   7,   6, INF,   2,   0,   9},
			/*G*/ {  14, INF, INF, INF,   8,   9,   0}}; 
			      //大家可以在去测试其它的邻接矩阵，结果都可以得到最小生成树.
			      
			      //创建KruskalCase 对象实例
			      KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
			      //输出构建的
			      kruskalCase.print();
			      kruskalCase.kruskal();

	}
	public KruskalCase(char[] vertexs, int[][] matrix)
	{
		int vlen = vertexs.length;
		this.vertexs = new char[vlen];
		for (int i = 0; i < vertexs.length; i++)
		{
			this.vertexs[i] = vertexs[i];
		}
		this.matrix = new int[vlen][vlen];
		for (int i = 0; i < vlen; i++)
		{
			for (int j = 0; j < vlen; j++)
			{
				this.matrix[i][j] = matrix[i][j];
			}
		}
		for (int i = 0; i < vlen; i++)
		{
			for (int j = i+1; j < vlen; j++)
			{
				if(this.matrix[i][j] != INF) 
				{
					edgeNum++;
					
				}
			}
		}
	}
	public void print() {
		System.out.println("邻接矩阵为: \n");
		for(int i = 0; i < vertexs.length; i++) {
			for(int j=0; j < vertexs.length; j++) {
				System.out.printf("%12d", matrix[i][j]);
			}
			System.out.println();//换行
		}
	}
	//对边进行排序
	private void sort(EData[] edges) 
	{
		for (int i = 0; i < edges.length; i++)
		{
			for (int j = 0; j < edges.length - 1 - i; j++)
			{
				if(edges[j].weight > edges[j+1].weight) 
				{
					EData temp = edges[j];
					edges[j] = edges[j+1];
					edges[j+1] = temp;
				}
			}
		}
	}
	private int getPosition(char ch) 
	{
		for (int i = 0; i < vertexs.length; i++)
		{
			if(vertexs[i] == ch) 
			{
				return i;
			}
		}
		return -1;
	}
	//获取图中的边,放到Edata数组中
	private EData[] getEdges() 
	{
		int index = 0;
		EData[] eages = new EData[edgeNum];
		for (int i = 0; i < vertexs.length; i++)
		{
			for (int j = i+1; j < vertexs.length; j++)
			{
				if(matrix[i][j] != INF) 
				{
					eages[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
					
				}
			}
		}
		return eages;
	}
	//获取下表为i的顶点的终点
	private int getEnd(int[] ends, int i) 
	{
		while(ends[i] != 0) 
		{
			i = ends[i];
		}
		return i;
	}
	public void kruskal() 
	{
		int index = 0;//表示最后结果数组的索引
		int[] ends = new int[edgeNum];//用于保存"已有最小生成树"中的每个顶点在最小生成树的终点
		//创建结果数组,保存最后的最小生成树
		EData[] rets = new EData[edgeNum];
		//获取图中所有的边的集合
		EData[] edges = getEdges();
		//按照边的权值大小进行排序
		sort(edges);
		//判断是否构成回路
		for (int i = 0; i < edgeNum; i++)
		{
			int p1 = getPosition(edges[i].start);
			int p2 = getPosition(edges[i].end);
			int m = getEnd(ends, p1);
			int n =getEnd(ends, p2);
			if(m != n) 
			{
				ends[m] = n;//设置其在最小生成树中的终点
				rets[index++] = edges[i];
			}
		}
		
		System.out.println(Arrays.toString(rets));
		
	}
}
//创建一个类Data,它的对象实例就表示一条边
class EData
{
	char start;//边的一个点
	char end;//边的另外一个点
	int weight;
	public EData(char start, char end, int weight)
	{
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	@Override
	public String toString()
	{
		return "EData [start=" + start + ", end=" + end + ", weight=" + weight + "]";
	}
	
}

