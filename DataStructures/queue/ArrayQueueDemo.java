package DataStructures.queue;

public class ArrayQueueDemo
{

	public static void main(String[] args)
	{
		

	}

}
//编写一个叫做ArrayQueue的一个类
class ArrayQueue
{
	private int MaxSize;
	private int front;
	private int rear;
	private int[] arr;
	//创建队列的构造器
	public ArrayQueue(int arrMaxSize)
	{
		MaxSize = arrMaxSize;
		arr = new int[arrMaxSize];
		front = -1;//指向队列头部
		rear = -1;//指向队列尾
	}
	public boolean isFull() 
	{
		return rear == MaxSize - 1;
	}
	public boolean isEmpty() 
	{
		return front == rear;
	}
	public void addQ(int n) 
	{
		if(isFull()) 
		{
			return;
		}
		rear ++;
		arr[rear] = n;
	}
	public int getQueue() 
	{
		if(isEmpty()) 
		{
			throw new RuntimeException("队列为空");
		}
		front++;
		return arr[front];
	}
	public void showQueue() 
	{
		if(isEmpty()) 
		{
			return;
		}
		for (int i = ++front; i <= rear; i++)
		{
			System.out.println(arr[i]);
		}
	}
}