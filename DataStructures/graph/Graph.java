package DataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph
{
	private ArrayList<String> vertexList;//存储顶点的集合
	private int[][] edges;//存贮图的对应矩阵
	private int numOfEdges;//边的数目
	//定义一个Boolean[],记录某个节点是否被访问过
	private boolean[] isVisited;
	public static void main(String[] args)
	{
		
	}
	//构造器
	public Graph(int n)
	{
		edges = new int[n][n];
		vertexList = new  ArrayList<String>(n);
		numOfEdges = 0;
		isVisited = new boolean[n];
	}
	//得到一个邻接结点的下标
	public int getFirstNeighbor(int index) 
	{
		for (int i = 0; i < vertexList.size(); i++)
		{
			if(edges[index][i] > 0) 
			{
				return i;
			}
		}
		return -1;
	}
	//根据前一个邻接结点的下标来获取下一个邻接结点
	public int getNextNeighbor(int v1,int v2)
	{
		for (int i = v2 + 1; i < vertexList.size(); i++)
		{
			if(edges[v1][i] > 0)
			{
				return i;
			}	
		}
		return -1;
	}
	//对一个节点深度优先遍历
	public void DFS(boolean[] isVisited, int i) 
	{
		System.out.println(getVauleByIndex(i));
		isVisited[i] = true;
		int w =getFirstNeighbor(i);
		while(w != -1) 
		{
			if(!isVisited[w]) 
			{
				DFS(isVisited,w);
			}
			w = getNextNeighbor(i, w);
		}
	}
	
	public void DFS() 
	{
		for (int i = 0; i < getNumOfVertex(); i++)
		{
			if(!isVisited[i]) 
			{
				DFS(isVisited, i);
			}
		}
	}
	//对一个节点进行广度优先遍历的方法
	public void BFS(boolean[] isVisited, int i) 
	{
		int u;//表示队列的头节点对应下标
		int w;//邻接结点w
		//队列,纪录节点访问的顺序
		LinkedList queue = new LinkedList();
		System.out.print(getVauleByIndex(i));
		isVisited[i] = true;
		//将节点加入队列
		queue.addLast(i);
		while(!queue.isEmpty()) 
		{
			u = (Integer)queue.removeFirst();
			w = getFirstNeighbor(u);
			while(w != -1) 
			{
				if(!isVisited[w]) 
				{
					System.out.print(getVauleByIndex(w));
					isVisited[w] = true;
					queue.addLast(w);
				}
				w = getNextNeighbor(u, w);
			}
		}
	}
	public void BFS()
	{
		for (int i = 0; i < getNumOfVertex(); i++)
		{
			if(!isVisited[i]) 
			{
				BFS(isVisited, i);
			}
		}
	}
	//显示图
	public void showGraph() 
	{
		for(int[] link : edges) 
		{
			System.out.println(Arrays.toString(link));
		}
	}
	//返回节点的个数
	public int getNumOfVertex() 
	{
		return vertexList.size(); 
	}
	//返回边的数目
	public int getNumOfEdges()
	{
		return numOfEdges;
	}
	//返回节点i(下标)对应的数据
	public String getVauleByIndex(int i) 
	{
		return vertexList.get(i);
	}
	//返回v1和v2的权值
	public int getWeight(int v1,int v2) 
	{
		return edges[v1][v2];
	}
	//加入顶点
	public void insertVertes(String vertes) 
	{
		vertexList.add(vertes);
	}
	//添加边
	public void insertEdge(int v1,int v2,int weight) 
	{
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
}
