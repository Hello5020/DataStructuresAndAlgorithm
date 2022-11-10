package DataStructures.stack;

public class Calculator
{

	public static void main(String[] args)
	{
		String expression  = "3+2*6-2";
		//创建两个栈,一个为数栈,一个为符号栈
		ArrayStack2 numStack= new ArrayStack2(10);
		ArrayStack2 operStack= new ArrayStack2(10);
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";
		while(true) 
		{
			//一个一个对输入表达式进行读取
			ch = expression.substring(index, index + 1).charAt(0);
			//取出后进行判断
			if(operStack.isOper(ch)) 
			{
				if(!operStack.isEmpty()) 
				{
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())) 
					{
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						numStack.push(res);
						operStack.push(ch);
					}else 
					{
						operStack.push(ch);
					}
						
				}else 
				{
					operStack.push(ch);
				}
			}else 
			{
				//numStack.push(ch - 48);
				keepNum += ch;
				if(index == expression.length() - 1) 
				{
					numStack.push(Integer.parseInt(keepNum));
				}else {
				if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))) 
				{
					numStack.push(Integer.parseInt(keepNum));
					keepNum = "";
				}
			}
				
			}
			index++;
			if(index == expression.length()) 
			{
				break;
			}
		}
		while(true) 
		{
			if(operStack.isEmpty()) 
			{
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			numStack.push(res);
		}
		System.out.println(numStack.pop());
	}

}
class ArrayStack2
{
	private int MaxSize;//栈的大小
	private int[] stack ;//数组模拟栈,数据就放在数组里
	private int top = -1;//top表示栈底,初始化为-1
	//构造器
	public ArrayStack2(int MaxSize) 
	{
		this.MaxSize = MaxSize;
		stack = new int[this.MaxSize];
	}
	public int peek() 
	{
		return stack[top];
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
	//返回运算符的优先级
	public int priority(int oper) 
	{
		if(oper == '*' || oper == '/' )
		{
			return 1;
		}else if(oper == '+' || oper == '-') 
		{
			return 0;
		}else 
		{
			return -1;
		}
	}
	//判断是不是一个运算符
	public boolean isOper(char val) 
	{
		return val == '+' || val == '-' || val == '/' || val == '*';
	}
	public int cal(int num1,int num2,int oper) 
	{
		int res = 0;
		switch (oper)
		{
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num1 - num2;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
}