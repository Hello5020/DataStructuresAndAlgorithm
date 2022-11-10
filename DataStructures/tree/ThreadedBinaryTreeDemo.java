package DataStructures.tree;

public class ThreadedBinaryTreeDemo
{

	public static void main(String[] args)
	{
		

	}

}
class BinaryTree2
{
	private HeroNode2 root;
	//在递归进行线索化时,pre总是保存前驱节点
	private HeroNode2 pre = null;
	public HeroNode2 getRoot()
	{
		return root;
	}
	public void setRoot(HeroNode2 root)
	{
		this.root = root;
	}
	//遍历线索化二叉树
	public void threadList() 
	{
		//定义一个变量,储存当前遍历节点
		HeroNode2 node = root;
		while(node != null) 
		{
			while(node.getLeftType() == 0) 
			{
				node = node.getLeft();
			}
			System.out.println(node);
			while(node.getRightType() == 1) 
			{
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
	public void threadedNodes(HeroNode2 node) 
	{
		//为空不能线索化
		if(node == null) 
		{
			return;
		}
		threadedNodes(node.getLeft());
		if(node.getLeft() == null) 
		{
			node.setLeft(pre);
			node.setLeftType(1);
		}if(pre != null &&pre.getRight() == null) 
		{
			pre.setRight(node);
			pre.setRightType(1);
		}
		pre = node;
	}
	public void delNode(int no) 
	{
		if(this.root != null)
		{
			if(root.getNo() == no) 
			{
				root = null;
			}else 
			{
				root.delNode(no);
			}
		}
	}
	//前序
	public void preOrder() 
	{
		if(this.root != null)
		{
			this.root.preOrder();
		}else 
		{
			System.out.println("二叉树为空");
		}
	}
	public HeroNode2 preOrdersearch(int no) 
	{
		if(this.root != null)
		{
			return this.root.preOrdersearch(no);
		}else 
		{
			return null;
		}
	} 
	//中序
	public void infixOrder() 
	{
		if(this.root != null)
		{
			this.root.infixOrder();
		}else 
		{
			System.out.println("二叉树为空");
		}
	}
	public HeroNode2 infixOrdersearch(int no) 
	{
		if(this.root != null)
		{
			return this.root.infixOrdersearch(no);
		}else 
		{
			return null;
		}
	}
	//后序
	public void postOrder() 
	{
		if(this.root != null)
		{
			this.root.postOrder();
		}else 
		{
			System.out.println("二叉树为空");
		}
	}
	public HeroNode2 postOrdersearch(int no) 
	{
		if(this.root != null)
		{
			return this.root.postOrdersearch(no);
		}else 
		{
			return null;
		}
	}
}
//创建节点
class HeroNode2
{
	private int no;
	private String name;
	private HeroNode2 left;
	private HeroNode2 right;
	//说明
	//如果Type == 0 表示为子树,如果为1则为前驱或后驱
	private int leftType;
	private int rightType;
	public HeroNode2(int no, String name)
	{
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo()
	{
		return no;
	}
	public void setNo(int no)
	{
		this.no = no;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public HeroNode2 getLeft()
	{
		return left;
	}
	public void setLeft(HeroNode2 left)
	{
		this.left = left;
	}
	public HeroNode2 getRight()
	{
		return right;
	}
	public void setRight(HeroNode2 right)
	{
		this.right = right;
	}
	public int getLeftType()
	{
		return leftType;
	}
	public void setLeftType(int leftType)
	{
		this.leftType = leftType;
	}
	public int getRightType()
	{
		return rightType;
	}
	public void setRightType(int rightType)
	{
		this.rightType = rightType;
	}
	public String toString()
	{
		return "HeroNode2 [no=" + no + ", name=" + name + "]";
	}
	//删除节点
	public void delNode(int no) 
	{
		if(this.left.no == no && this.left != null) 
		{
			this.left = null;
			return;
		}
		if(this.right.no == no && this.right != null) 
		{
			this.right = null;
			return;
		}
		if(this.left != null) 
		{
			this.left.delNode(no);
		}
		if(this.right != null) 
		{
			this.right.delNode(no);
		}
	}
	//前序遍历
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
	//前序查找
	public HeroNode2 preOrdersearch(int no) 
	{
		if(this.no == no) 
		{
			return this;
		}
		if(this.left != null) 
		{
			this.left.preOrdersearch(no);
		}if (this.left.preOrdersearch(no) !=  null) 
		{
			return this.left.preOrdersearch(no);
		}
		if(this.right != null) 
		{
			this.right.preOrdersearch(no);
		}if (this.right.preOrdersearch(no) !=  null) 
		{
			return this.right.preOrdersearch(no);
		}
		return null;
	}
	//中序遍历
	public void infixOrder() 
	{
		if(this.left != null) 
		{
			this.left.infixOrder();
		}
		System.out.println(this);
		
		if(this.right != null) 
		{
			this.right.infixOrder();
		}
	}
	//中序查找
	public HeroNode2 infixOrdersearch(int no) 
	{
		if(this.left != null) 
		{
			this.left.infixOrdersearch(no);
		}if (this.left.infixOrdersearch(no) !=  null) 
		{
			return this.left.infixOrdersearch(no);
		}
		if(this.no == no) 
		{
			return this;
		}
		if(this.right != null) 
		{
			this.right.infixOrdersearch(no);
		}if (this.right.infixOrdersearch(no) !=  null) 
		{
			return this.right.infixOrdersearch(no);
		}
		return null;
	}
	//后序遍历
	public void postOrder() 
	{
		
		if(this.left != null) 
		{
			this.left.postOrder();
		}
		if(this.right != null) 
		{
			this.right.postOrder();
		}
		System.out.println(this);
	}
	//后序查找
	public HeroNode2 postOrdersearch(int no) 
	{
		if(this.left != null) 
		{
			this.left.postOrdersearch(no);
		}if (this.left.postOrdersearch(no) !=  null) 
		{
			return this.left.postOrdersearch(no);
		}
		if(this.right != null) 
		{
			this.right.postOrdersearch(no);
		}if (this.right.postOrdersearch(no) !=  null) 
		{
			return this.right.postOrdersearch(no);
		}
		if(this.no == no) 
		{
			return this;
		}
		return null;
	}
}