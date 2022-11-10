package DataStructures.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree
{

	public static void main(String[] args)
	{
	 int arr[] = {13,7,8,3,29,6,1};
	 Node root = createHuffTree(arr);
	 preOrder(root);
	}
	public static void preOrder(Node root) 
	{
		if(root != null) 
		{
			root.preOrder();
		}else 
		{
			return;
		}
	}
	public static Node createHuffTree(int[] arr) 
	{
		List<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < arr.length; i++)
		{
			nodes.add(new Node(arr[i]));
		}
		while(nodes.size() > 1){
		//排序
		Collections.sort(nodes);
		Node leftNode = nodes.get(0);
		Node rightNode = nodes.get(1);
		Node parent = new Node(leftNode.value + rightNode.value);
		parent.left = leftNode;
		parent.right = rightNode;
		nodes.remove(rightNode);
		nodes.remove(leftNode);
		nodes.add(parent);
		}
		return nodes.get(0);
	}
}
//创建节点
//为了让Node对象实现Collections集合排序
//让Node实现Comparable接口
class Node implements Comparable<Node>
{
	int value;//权值
	Node left;
	Node right;
	public void preOrder()
	{
			System.out.println(this);
			if(this.left != null) 
			{
				this.left.preOrder();
			}
			if(this.right != null) 
			{
				this.right.preOrder();
			}
		
	}
	public Node(int value)
	{
		super();
		this.value = value;
	}
	@Override
	public String toString()
	{
		return "Node [value=" + value + "]";
	}
	@Override
	public int compareTo(Node o)
	{
		// TODO Auto-generated method stub
		//从小到大
		return this.value - o.value;
	}
	
}