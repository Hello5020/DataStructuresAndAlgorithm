package DataStructures.AVL;

public class AVLTreeDemo
{

	public static void main(String[] args)
	{
		int[] arr = {4,3,6,5,7,8};
		//创建一个AVLTree对象
		AVLTree avlTree = new AVLTree();
		for(int i = 0; i < arr.length; i++) 
		{
			avlTree.add(new Node(arr[i]));
		}
		
	}

}
class AVLTree
{
	private Node root;
	public void add(Node node) 
	{
		if(root == null)
			root = node;
		else
			root.add(node);
	}
	public void infixOrder(Node root) 
	{
		if(root != null) 
		{
			root.infixOrder();
		}else 
		{
			System.out.println("树为空");
		}
	}
	public Node search(int value) 
	{
		if(root == null) 
		{
			return null;
		}else 
		{
			return root.search(value);
		}
	}
	public Node searchParent(int value) 
	{
		if(root == null) 
		{
			return null;
		}else 
		{
			return root.searchParent(value);
		}
	}
	public int delRightTreeMin(Node node) 
	{
		//方法作用:返回以node为根节点的二叉排序树的最小节点的值,并删除这个值
		Node target = node;
		while(target.left != null) 
		{
			target = target.left;
		}
		delNode(target.value);
		return target.value;
	}
	public void delNode(int value) 
	{
		if(root == null) 
		{
			return;
		}else 
		{
			Node targetNode = search(value);
			if(targetNode == null) 
			{
				return ;
			}
			if(root.left == null && root.right == null) 
			{
				root = null;
				return;
			}
			//去查找targetNode的父节点
			Node ParentNode = searchParent(value);
			if(targetNode.left == null && targetNode.right == null) 
			{
				if(ParentNode.left != null && ParentNode.left.value == value) 
				{
					ParentNode.left = null;
				}else if(ParentNode.right != null && ParentNode.right.value == value) 
				{
					ParentNode.right = null;
				}
			}else if(targetNode.left != null && targetNode.right != null) 
				  {
						int minVal = delRightTreeMin(targetNode.right);
						targetNode.value = minVal;
				   }else 
					{
						if(targetNode.left != null)
						{
							if(ParentNode != null)
							{
								if(ParentNode.left.value == value) 
								{
									ParentNode.left = targetNode.left;
								}else 
								{
									ParentNode.right = targetNode.left;
								}
							}else 
							{
								root = targetNode.left;
							}
							
						}else 
						{
							if(ParentNode != null)
							{
								if(ParentNode.left.value == value) 
								{
									ParentNode.left = targetNode.right;
								}else 
								{
									ParentNode.right = targetNode.right;
								}
							}else
							{
								root = targetNode.right;
							}
						}
					}
		}
		
	}
}
class Node
{
	int value;
	Node right;
	Node left;
	public Node(int value)
	{
		super();
		this.value = value;
	}
	//返回当前节点的,高度,以该节点为根节点的高度
	public int height() 
	{
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}
	//左旋转
	public void leftRotate() 
	{
		//创建新节点
		Node newnode = new Node(value);
		newnode.left = left;
		newnode.right = right.left;
		value = right.value;
		right = right.right;
		left = newnode;
	}
	//右旋转
	public void rightRotate() 
	{
		//创建新节点
		Node newnode = new Node(value);
		newnode.right = right;
		newnode.left = left.right;
		value = left.value;
		left = left.left;
		right = newnode;
	}
	//返回左子树的高度
	public int leftHight() 
	{
		if(left == null) 
		{
			return 0;
		}
		return left.height();
	}
	//返回右子树的高度
	public int rightHight() 
	{
		if(right == null) 
		{
			return 0;
		}
		return right.height();
	}
	//添加节点
	public void add(Node node) 
	{
		if(node == null) 
		{
			return;
		}
		if(node.value < this.value) 
		{
			if(this.left == null) 
			{
				this.left = node;
			}else 
			{
				this.left.add(node);
			}
		}else 
		{
			if(this.right == null) 
			{
				this.right = node;
			}else 
			{
				this.right.add(node);
			}
		}
		//当添加完成后(右子树的高度 - 左子树的高度) > 1 ,左旋转
		if(rightHight() - leftHight() > 1) 
		{
			if(right != null && right.rightHight() < right.leftHight()) 
			{
				right.rightHight();
				leftHight();
			}else 
			{
				leftHight();
			}
			return;
		}
		//当添加完成后(左子树的高度 - 右子树的高度) > 1 ,右旋转
		if(leftHight() - rightHight() > 1) 
		{
			if(right != null && left.leftHight() < left.rightHight()) 
			{
				//先对当前节点的左节点进行左旋转
				left.leftRotate();
				rightRotate();
			}                 else 
			{
				rightRotate();
			}
		}
	}
	//中序
	public void infixOrder() 
	{
		if(this.left == null) 
		{
			return;
		}else 
		{
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right == null) 
		{
			return;
		}else 
		{
			this.right.infixOrder();
		}
	}
	//查找要删除的节点
	public Node search(int value) 
	{
		if(value == this.value) 
		{
			return this;
		}else if(value < this.value) 
		{
			if(this.left == null) 
			{
				return null;
			}
			this.left.search(value);
		}else 
		{
			if(this.right == null) 
			{
				return null;
			}
			this.right.search(value);
		}
		return null;
	}
	//查找要删除结点的父节点
	public Node searchParent(int value) 
	{
		if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) 
		{
			return this;
		}else 
		{
			if(value < this.value && this.left != null) 
			{
				return this.left.searchParent(value);
			}else if(value >= this.value && this.right != null) 
			{
				return this.right.searchParent(value);
			}else 
			{
				return null;
			}
		}
	}
}