package DataStructures.tree;

public class BinaryTreeDemo
{

	public static void main(String[] args)
	{
		//创建二叉树
		BinaryTree binaryTree = new BinaryTree();
		
	}

}
//定义二叉树
class BinaryTree
{
	private HeroNode root;
	
	public HeroNode getRoot()
	{
		return root;
	}
	public void setRoot(HeroNode root)
	{
		this.root = root;
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
	public HeroNode preOrdersearch(int no) 
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
	public HeroNode infixOrdersearch(int no) 
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
	public HeroNode postOrdersearch(int no) 
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
//先创建节点
class HeroNode
{
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	public HeroNode(int no, String name)
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
	public HeroNode getLeft()
	{
		return left;
	}
	public void setLeft(HeroNode left)
	{
		this.left = left;
	}
	public HeroNode getRight()
	{
		return right;
	}
	public void setRight(HeroNode right)
	{
		this.right = right;
	}
	@Override
	public String toString()
	{
		return "HeroNode [no=" + no + ", name=" + name + "]";
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
	public HeroNode preOrdersearch(int no) 
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
	public HeroNode infixOrdersearch(int no) 
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
	public HeroNode postOrdersearch(int no) 
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