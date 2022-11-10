package DataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolamdNotation
{

	public static void main(String[] args)
	{
		//先定义给逆波兰表达式
		//(3+4)*5-6
		//说明为了方便,将逆波兰式的数字和符号使用空格隔开
		String suffixExpression = "3 4 + 5 * 6 -";
		//将表达式放到,ArraryList中
		//将ArraryList传给一个方法配合栈完成
		

	}
	//将中缀表达式转换成对应的List
	public static List<String> toInfixExpressionList(String s)
	{
		List<String> list = new ArrayList<String>();
		int i = 0;//扫描定位指针
		String str;
		char c;
		do 
		{
			if(((c = s.charAt(i)) < 48) && ((c = s.charAt(i)) > 57)) 
			{
				list.add(c + "");
				i++;
			}else 
			{
				str = "";
				while(((c = s.charAt(i)) >= 48) && ((c = s.charAt(i)) <= 57)) 
				{
					str += c;
					i++;
				}
				list.add(str);
			}
		}while( i < s.length());
		return list;
	}
	//将得到的中缀表达式转换成后缀表达式的list
	public static List<String> parseSuffixExpreesionList(List<String> ls)
	{
		Stack<String> s1 = new Stack<String>();
		//因为算式栈在转换过程中没有弹出操作,所以可用List
		List<String> s2 = new ArrayList<String>();
		for(String item : ls) 
		{
			if(item.matches("\\d+"))
			{
				s2.add(item);
			}else if(item.equals("(")) 
			{
				s1.push(item);
			}else if(item.equals(")")) 
			{
				while(s1.peek().equals("("))
						{
							s2.add(s1.pop());
						}
				s1.pop();
			}else 
			{
				while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) 
				{
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}
		while(s1.size() != 0) 
		{
			s2.add(s1.pop());
		}
		return s2;
	}
	//将逆波兰表达式依次放到ArraryList中
	public static List<String> getLIstString(String suffixExpression)
	{
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele : split) 
		{
			list.add(ele);
		}
			return list;
	}
	//运算
	public static int calculate(List<String> Is) 
	{
		//创建栈
		Stack<String> stack = new Stack<String>();
		//遍历
		for(String item: Is) 
		{
			//使用正则表达式进行数字的判断
			if(item.matches("\\d+")) 
			{
				//入栈
				stack.push(item);
			}else 
			{
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				int res = 0;
				if(item.equals("+")) 
				{
					res = num2 + num1;
				}else if(item.equals("-")) 
				{
					res = num2 - num1;
				}else if(item.equals("*")) 
				{
					res = num2 * num1;
				}else if(item.equals("/")) 
				{
					res = num2 / num1;
				}else 
				{
					throw new RuntimeException("运算符有误");
				}
				stack.push(res + "");
			}
		}
		return Integer.parseInt(stack.pop());
	}

}
class Operation
{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	public static int getValue(String operation) 
	{
		int result = 0;
		switch (operation)
		{
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
		break;
		default:
			break;
		}
		return result;
	}
	
}