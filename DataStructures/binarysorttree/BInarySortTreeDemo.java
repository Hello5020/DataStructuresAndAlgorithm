package DataStructures.binarysorttree;

public class BInarySortTreeDemo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
class BinarySortTree
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