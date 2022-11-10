package DataStructures.linkedlist;

import java.util.Scanner;

public class Josepfu
{

	public static void main(String[] args)
	{
		CricleSingleLinkedList cricleSingleLinkedList = new CricleSingleLinkedList();
		cricleSingleLinkedList.addBoy(7);
		cricleSingleLinkedList.countBoy(1, 6, 7);
	}

}
//创建一个环形的单向链表
class CricleSingleLinkedList
{
	//创建一个first节点
	private Boy first = null;
	Scanner scanner = new Scanner(System.in);
	//添加小孩节点构成环形链表
	public void addBoy(int nums) 
	{
		if(nums < 1) 
		{
			System.out.println("nums的值不正确");
			return;
		}
		Boy curBoy = null;//辅助变量 
		//使用for循环来构建一个环形链表
		for (int i = 1; i <= nums; i++)
		{
			System.out.print("输入(编号为" + i + ")的密码:");
			int pwd = scanner.nextInt();
			Boy boy = new Boy(i,pwd);
			//如果i=1
			if(i == 1) 
			{
				first = boy;
				first.setNext(first);
				curBoy = first;
			}else 
			{
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}
	//遍历链表
	public void list() 
	{
		if(first ==null) 
		{
			System.out.println("无小孩");
			return;
		}
		Boy curBoy = first;
		while(true) 
		{
			System.out.println(curBoy.getNo());
			if(curBoy.getNext() == first) 
			{
				break;
			}
			curBoy = curBoy.getNext();
		}
	}
	//根据用户的输入,计算出出圈的顺序
	public void countBoy(int startNo, int countNum, int nums) 
	{
		if(first == null || startNo < 1 || startNo > nums) 
		{
			System.out.println("参数输入有误");
			return;
		}
		//创建一个辅助指针
		Boy helper = first;
		while(true) 
		{
			if(helper.getNext() == first) 
			{
				break;
			}
			helper = helper.getNext();
		}
//		for (int i = 0; i < startNo - 1; i++)
//		{
//			first = first.getNext();
//			helper = helper.getNext();
//		}
		while(true) 
		{
			if(helper == first) 
			{
				System.out.print(first.getNo());
				break;
			}
			for (int i = 0; i < countNum - 1; i++)
			{
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.print(first.getNo());
			countNum = first.getPwd();
			first = first.getNext();
			helper.setNext(first);			 
		} 
		
	}
}
//创建一个Boy类表示一个节点
class Boy
{
	private int no;//编号
	private Boy next;//指向下一个节点
	private int pwd;
	public int getNo()
	{
		return no;
	}
	public void setNo(int no)
	{
		this.no = no;
	}
	public Boy getNext()
	{
		return next;
	}
	public void setNext(Boy next)
	{
		this.next = next;
	}
	public Boy(int no,int pwd)
	{
		super();
		this.no = no;
		this.pwd = pwd;
	}
	public int getPwd()
	{
		return pwd;
	}
	public void setPwd(int pwd)
	{
		this.pwd = pwd;
	}
	
}