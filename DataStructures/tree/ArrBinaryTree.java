package DataStructures.tree;

public class ArrBinaryTree
{

	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7};
		ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
		arrayBinaryTree.preOrder();
	}

}
//编写一个ArrayBinaryTree,实现顺序存储二叉树
class ArrayBinaryTree
{
	private int[] arr;

	public ArrayBinaryTree(int[] arr)
	{
		super();
		this.arr = arr;
	}
	//前序
	public void preOrder() 
	{
		//如果数组为空或者arr.length为0
		if(arr == null || arr.length == 0) 
		{
			System.out.println("数组为空不能按照二叉树前序遍历");
		}
		this.preOrder(0);
	}
	public void preOrder(int index) 
	{
		System.out.println(arr[index]);
		if((index * 2 + 1) < arr.length) 
		{
			this.preOrder(index * 2 + 1);
		}
		if((index * 2 + 2) < arr.length) 
		{
			this.preOrder(index * 2 + 2);
		}
	}
}
