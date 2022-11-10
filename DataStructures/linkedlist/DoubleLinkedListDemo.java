package DataStructures.linkedlist;

public class DoubleLinkedListDemo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
//创建一个双向链表的类
class DoubleLinkedList
{
	private HeroNode2 head = new HeroNode2(0, null, null);
	
	public HeroNode2 getHead()
	{
		return head;
	}
	public void list() 
	{
		if(head.next == null) 
		{
			return;
		}
		//因为头节点,不能动,因此我们需要一个辅助变量来遍历
		HeroNode2 temp = head.next;
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
	//添加节点
		public void add(HeroNode2 heroNode) 
		{
			HeroNode2 temp = head;
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
			heroNode.pre = temp;
		}
		public void update(HeroNode2 NewheroNode) 
		{
			if(head.next == null) 
			{
				return;
			}
			HeroNode2 temp = head.next;
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
			if(head.next == null) 
			{
				return;
			}
			HeroNode2 temp = head.next;
			boolean flag =false;
			while(true) 
			{
				if(temp == null) 
				{
					break;
				}
				if(temp.no == no) 
				{
					 flag = true;
					 break;
				}
				temp =temp.next;
			}
			if(flag) 
			{
				temp.pre.next = temp.next;
				if(temp.next != null)
				temp.next.pre = temp.pre;
			}
		}
}
class HeroNode2
{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;
	public HeroNode2(int no, String name, String nickname)
	{
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	@Override
	public String toString()
	{
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}