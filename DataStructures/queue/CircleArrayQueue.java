package DataStructures.queue;

public class CircleArrayQueue
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
class CircleArray
{
	private int MaxSize;
	private int front;
	private int rear;
	private int[] arr;
	public CircleArray(int arrMaxSize)
	{
		MaxSize = arrMaxSize;
		arr = new int[arrMaxSize];
	}
	public boolean isFull() 
	{
		return (rear + 1) % MaxSize == front;
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
		arr[rear] = n;
		rear = (rear + 1) % MaxSize;
	}
	public int getQueue() 
	{
		if(isEmpty()) 
		{
			throw new RuntimeException("队列为空");
		}
		int num = arr[front];
		front = (front + 1) % MaxSize;
		return num;
	}
	public void showQueue() 
	{
		if(isEmpty()) 
		{
			return;
		}
		for (int i = front; i <= front + (rear + MaxSize - front) % MaxSize; i++)
		{
			System.out.println(arr[i % MaxSize]);
		}
	}
}