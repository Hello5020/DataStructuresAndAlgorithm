package DataStructures.hashTable;

import java.util.Scanner;

//电话号码、用户名、地址；从键盘输入各记录，分别以电话号码和用户名为关键字建立散列表
public class HashTableDemo
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		int size =0;
		System.out.print("输入需要创建的散列表大小:");
		size = scanner.nextInt();
		HashTable hashTable = new HashTable(size);
		String key = "";
		System.out.print("输入选择关键词(name/Tel):");
		key = scanner.next();
		while(true) 
		{
			System.out.println("add:"+"添加用户");
			System.out.println("list:"+"遍历用户");
			System.out.println("find:"+"查找用户");
			System.out.println("delete:"+"删除用户");
			System.out.println("exit:"+"退出");
			switch (key)
			{
			case "Tel":
				System.out.print("输入所需方法:");
				key = scanner.next();
				switch (key)
				{
				case "add":
					System.out.print("输入电话:");
					int Tel = scanner.nextInt(20);
					System.out.print("输入名字:");
					String name = scanner.next();
					System.out.print("输入地址:");
					String adress = scanner.next();
					Customer customer = new Customer(Tel, name, adress);
					hashTable.addByTel(customer);
					break;
				case "list":
				hashTable.list();
				break;
				case"find":
					System.out.print("输入要查找用户的电话:");
					Tel = scanner.nextInt(20);
					hashTable.findCumByTel(Tel);
				break;
				case"exit":
					scanner.close();
					System.exit(0);
				default:
					break;
				}
				break;
			case "name":
				System.out.print("输入所需方法:");
				key = scanner.next();
				switch (key)
				{
				case "add":
					System.out.print("输入电话:");
					int Tel = scanner.nextInt(20);
					System.out.print("输入名字:");
					String name = scanner.next();
					System.out.print("输入地址:");
					String adress = scanner.next();
					Customer customer = new Customer(Tel, name, adress);
					hashTable.addByName(customer);
					break;
				case "list":
				hashTable.list();
				case"find":
					System.out.print("输入要查找用户的电话:");
					name = scanner.next();
					hashTable.findCumByName(name);
				break;
				case"exit":
					scanner.close();
					System.exit(0);
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
	}

}
class HashTable
{
	private CustomerLinkList[] customerLinkLists;
	private int size;

	public HashTable(int size)
	{
		this.size = size;
		customerLinkLists = new CustomerLinkList[size];
		//分别初始化每一条链表
		for (int i = 0; i < size; i++)
		{
			customerLinkLists[i] = new CustomerLinkList();
		}
	}
	//添加
	public void addByTel(Customer customer) 
	{
		//根据电话
		int customerLinkListNo = hashFun(customer.Tel);
		customerLinkLists[customerLinkListNo].add(customer);
		
	}
	public void addByName(Customer customer) 
	{
		//根据电话
		int customerLinkListNo = hashFun(customer.name);
		customerLinkLists[customerLinkListNo].add(customer);
		
	}
	public void list() 
	{
		for (int i = 0; i < customerLinkLists.length; i++)
		{
			customerLinkLists[i].list(i);
		}
	}
	public void findCumByTel(int Tel) 
	{
		int customerLinkListNo = hashFun(Tel);
		Customer customer = customerLinkLists[customerLinkListNo].findCumByTel(Tel);
		if(customer != null) 
		{
			System.out.println("在第" + (customerLinkListNo+1) + "找到该用户");
		}else 
		{
			System.out.println("没有找到该用户");
		}
	}
	public void deleteByTel(int Tel) 
	{
		int customerLinkListNo = hashFun(Tel);
		customerLinkLists[customerLinkListNo].deleteByTel(Tel);
	}
	public void deleteByName(String name) 
	{
		int customerLinkListNo = hashFun(name);
		customerLinkLists[customerLinkListNo].deleteByName(name);
	}
	public void findCumByName(String name) 
	{
		int customerLinkListNo = hashFun(name);
		Customer customer = customerLinkLists[customerLinkListNo].findCumByName(name);
		if(customer != null) 
		{
			System.out.println("在第" + (customerLinkListNo+1) + "找到该用户");
		}else 
		{
			System.out.println("没有找到该用户");
		}
	}
	//散列函数
	public int hashFun(String str) 
	{
		return Integer.parseInt(str) % size;
		
	}
	public int hashFun(int str) 
	{
		return str % size;
		
	}
}
class Customer
{
	public  int Tel;
	public String name;
	public String adress;
	public Customer next;
	public Customer(int tel, String name, String adress)
	{
		super();
		Tel = tel;
		this.name = name;
		this.adress = adress;
	}

	
}
class CustomerLinkList
{
	//头指针直接指向用户,无头结点
	private Customer head;
	//添加用户,尾插法
	public void add(Customer customer) 
	{
		//添加第一个用户
		if(head == null) 
		{
			head = customer;
			return;
		}
		//如果不是最后一个直接添加到最后
		Customer temp = head;
		while(true) 
		{
			if(temp.next == null) 
			{
				break;
			}
			temp = temp.next;//后移
		}
		temp.next = customer;
	}
	public void list(int i) 
	{
		if(head == null) 
		{
			System.out.println("第" + (i + 1) + "链表为空");
			return;
		}
		Customer temp = head;
		while(true) 
		{
			System.out.println("电话:" + temp.Tel + "姓名:" + temp.name + "住址" + temp.adress);
			if(temp.next == null) 
			{
				return;
			}
			temp = temp.next;
		}

	}
	public Customer findCumByTel(int Tel) 
	{
		if(head == null) 
		{
			System.out.println("链表为空");
			return null;
		}
		Customer temp = head;
		while(true) 
		{
			if(temp.Tel == Tel)
			{
				break;
			}
			if(temp.next == null) 
			{
				return null;
			}
			temp = temp.next;
		}
		return temp;
	}
	public Customer findCumByName(String name) 
	{
		if(head == null) 
		{
			System.out.println("链表为空");
			return null;
		}
		Customer temp = head;
		while(true) 
		{
			if(temp.name.equals(name))
			{
				break;
			}
			if(temp.next == null) 
			{
				return null;
			}
			temp = temp.next;
		}
		return temp;
	}
	public void deleteByTel(int Tel) 
	{
		if(head == null) 
		{
			System.out.println("链表为空");
			return;
		}
		Customer temp = head;
		while(true) 
		{
			if(temp.next.Tel == Tel)
			{
				break;
			}
			if(temp.next == null) 
			{
				return;
			}
			temp = temp.next;
		}
		if(temp.next.next != null)
		temp.next = temp.next.next;
		else 
		{
			temp.next = null;
		}
	}
	public void deleteByName(String name) 
	{
		if(head == null) 
		{
			System.out.println("链表为空");
			return;
		}
		Customer temp = head;
		while(true) 
		{
			if(temp.next.name.equals(name))
			{
				break;
			}
			if(temp.next == null) 
			{
				return;
			}
			temp = temp.next;
		}
		if(temp.next.next != null)
		temp.next = temp.next.next;
		else 
		{
			temp.next = null;
		}
	}
}