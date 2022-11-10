package DataStructures.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
//定义一个SingleLinkedList来管理英雄
class SingleLinkedList
{
	private HeroNode head = new HeroNode(0, null, null);
	//添加节点
	public void add(HeroNode heroNode) 
	{
		HeroNode temp = head;
		while(true) 
		{
			//找到链表的最后
			if(temp.next == null) 
			{
				break;
			}
			//如果没有将其后移
			temp = temp.next ;
		}
		temp.next = heroNode;
	}
	public void addByoder(HeroNode heroNode) 
	{
		//因为头节点不能动,所以需要使用一个辅助
		HeroNode temp = head;
		boolean flag = false;//用来检验编号是否存在
		while(true) 
		{
			if(temp.next == null) 
			{
				break;
			}
			if(temp.next.no > heroNode.no) 
			{
				//位置找到了
				break;
			}else if(temp.next.no == heroNode.no) 
			{
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//判断flag的值
		if(flag) 
		{
			System.out.println("编号已存在无法添加\n");
		}else 
		{
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}
	//根据 NewheroNode来修改
	public void update(HeroNode NewheroNode) 
	{
		if(head.next == null) 
		{
			return;
		}
		HeroNode temp = head.next;
		boolean flag = false;//用来检验编号是否存在
		while(true) 
		{
			//找到链表的最后
			if(temp == null) 
			{
				break;
			}
			if(temp.no == NewheroNode.no) 
			{
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) 
		{
			temp.name = NewheroNode.name;
			temp.nickname = NewheroNode.nickname;
		}else 
		{
			System.out.println("编号不存在无法添加\n");
		}
	}
	//删除节点
	public void delete(int no) 
	{
		HeroNode temp = head ;
		boolean flag = false;
		while(true) 
		{
			if(temp.next == null) 
			{
				break;
			}
			if(temp.next.no == no) 
			{
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) 
		{
			temp.next = temp.next.next;
		}
	}
	public static void reversePrint(HeroNode head) 
	{
		if(head.next == null) 
		{
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode temp = head.next;
		//将链表的所有节点压入栈中
		while(temp != null) 
		{
			stack.push(temp);
			temp = temp.next;
		}
		while(stack.size() > 0) 
		{
			System.out.println(stack.pop());
		}
	}
	//将单链表进行反转
	public static void reversetList(HeroNode head) 
	{
		if(head.next == null || head.next.next == null) 
		{
			return;
		}
		HeroNode temp = head.next;
		HeroNode next = null;//指向当前节点的下一个节点
		HeroNode reverseHead = new HeroNode(0, null, null);
		while(temp != null) 
		{
			next = temp.next;
			temp.next = reverseHead.next;
			reverseHead.next = temp;
			temp = next;
		}
		head.next = reverseHead.next;
	}
	public void list() 
	{
		if(head.next == null) 
		{
			return;
		}
		//因为头节点,不能动,因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		while(true) 
		{
			//找到链表的最后
			if(temp == null) 
			{
				break;
			}
			System.out.println(temp);
			temp = temp.next ;
		}
	}
	public static int getLength(HeroNode head) 
	{
		if(head.next == null) 
		{
			return 0;
		}
		int length = 0;
		HeroNode temp = head.next;
			while(temp != null) 
			{
				length++;
				temp = temp.next;
			}
			return length;
	}
	//查找单链表的倒数第K(index)个节点
	public static HeroNode findLastNode(int index,HeroNode head) 
	{
		if(head.next == null) 
		{
			return null;
		}
		int size = getLength(head);
		//先做一个数据的校验
		if(index <= 0|| index >size) 
		{
			return null;
		}
		HeroNode temp = head.next;
		for(int i = 0;i <size - index;i ++) 
		{
			temp =temp.next;
		}
		return temp;
	}
}
class HeroNode
{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	public HeroNode(int no, String name, String nickname)
	{
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	@Override
	public String toString()
	{
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + ", next=" + next + "]";
	}
	
}