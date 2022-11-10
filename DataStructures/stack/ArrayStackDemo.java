package DataStructures.stack;

public class ArrayStackDemo
{

	public static void main(String[] args)
	{
		

	}

}
class ArrayStack
{
	private int MaxSize;//栈的大小
	private int[] stack;//数组模拟栈,数据就放在数组里
	private int top = -1;//top表示栈底,初始化为-1
	//构造器
	public ArrayStack(int MaxSize) 
	{
		this.MaxSize = MaxSize;
	}
	//判断栈满
	public boolean isFull() 
	{
		return top ==MaxSize - 1;
	}
	//判断栈空
	public boolean isEmpty() 
	{
		return top == -1;
	}
	//入栈push
	public void push(int value) 
	{
		//先判断栈是否满
		if(isFull()) 
		{
			return;
		}
		top++;
		stack[top] = value;
	}
	public int pop() 
	{
		if(isEmpty()) 
		{
			throw new RuntimeException("栈空");
		}
		int value = stack[top];
		top--;
		return value;
	}
	public void list() 
	{
		if(isEmpty()) 
		{
			System.out.println("栈为空");
		}
		for (int i = top; i >= 0; i--)
		{
			System.out.println(stack[i]);
		}
	}
}