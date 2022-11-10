package DataStructures.huffmancode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode
{

	public static void main(String[] args)
	{
		String str = "i like like like java do you like a java";
		byte[] strbyte = str.getBytes();
		preOrder(createHuffmanTree(getNodes(strbyte)));
		getCode(createHuffmanTree(getNodes(strbyte)), "", stringBuilder);
		System.out.println(huffmanCodes);
		System.out.println(Arrays.toString(zip(strbyte)));
	}
	private static List<Node> getNodes(byte[] bytes)
	{
		//创建一个ArrayList
		ArrayList<Node> nodes = new ArrayList<Node>();
		//存储bytes,统计每一个byte出现的次数 -> map[key,value]
		Map<Byte,Integer> counts = new HashMap<Byte, Integer>();
		for(byte b: bytes)
		{
			Integer count = counts.get(b);
			if(count == null) 
			{
				counts.put(b, 1);
			}else 
			{
				counts.put(b, count + 1);
			}
		}
		for(Map.Entry<Byte, Integer> entry : counts.entrySet()) 
		{
			nodes.add(new Node(entry.getKey(),entry.getValue() ));
		}
		return nodes;
	} 
	private static Node createHuffmanTree(List<Node> nodes) 
	{
		while(nodes.size() > 1) 
		{
			Collections.sort(nodes);
	
		Node leftnode = nodes.get(0);
		Node rightnode = nodes.get(1);
		Node parent = new Node(null, leftnode.weight + rightnode.weight);
		parent.left = leftnode;
		parent.right = rightnode;
		nodes.remove(leftnode);
		nodes.remove(rightnode);
		nodes.add(parent);	
		}
		return nodes.get(0);
	}
	private static void preOrder(Node root) 
	{
		if(root == null) 
		{
			return;
		}else 
		{
			root.preOrder();
		}
	}

	//生成赫夫曼树对应的赫夫曼编码
	static Map<Byte,String> huffmanCodes = new HashMap<Byte, String>();
	static StringBuilder stringBuilder = new StringBuilder();
	private static void getCode(Node node, String code, StringBuilder stringBuilder)
	{
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if(node != null) 
		{
			if(node.data == null) 
			{
				getCode(node.left, "0", stringBuilder2);
				getCode(node.right, "1", stringBuilder2);
			}else 
			{
				huffmanCodes.put(node.data,stringBuilder2.toString());
			}
		}
	}
	//返回压缩后数组
	private static byte[] zip(byte[] bytes) 
	{
		StringBuilder stringBuilder = new StringBuilder();
		for(byte b: bytes) 
		{
			stringBuilder.append(huffmanCodes.get(b));
		}
		//将字符串转成byte数组
		int len;
		if(stringBuilder.length() % 8 == 0) 
		{
			len = stringBuilder.length() / 8;
		}else 
		{
			len = stringBuilder.length() / 8 + 1;
		}
		byte[] by = new byte[len];
		int index = 0;
		for (int i = 0; i < stringBuilder.length(); i += 8)
		{
			String strByte;
			if((i+8) > stringBuilder.length())
			{
				strByte = stringBuilder.substring(i);
			}
			else 
			{
				strByte = stringBuilder.substring(i, i + 8);
			}
			by[index] = (byte)Integer.parseInt(strByte, 2);
			index++;
		}
		return by;
	}
	//将一个byte转换成一个二进制字符串(按补码返回)
	private static String byteToBitString(boolean flag,byte b) 
	{
		//使用变量b
		int temp = b;
		String str = Integer.toBinaryString(temp);//返回的是temp对应的二进制补码
		//正数补高位
		if(flag) 
		{
		temp |= 256;//即按位或256 -> 1 0000 0000 ,当传入为1时 1 0000 0000 | 0000 0001 = 1 0000 0001(二进制数相加)
		}
		if(flag)
		{
		return str.substring(str.length() - 8);
		}else
		{
			return str;
		}
	}
	//解码
	private static byte[] decose(Map<Byte, String> huffmanCodes ,byte[] huffmanBytes) 
	{
		//得到huffmanBytes对应的二进制字符串
		StringBuilder stringBuilder = new StringBuilder();
		//将byets[]转换成二进制字符串
		for (int i = 0; i < huffmanBytes.length; i++)
		{
			boolean flag = (i == huffmanBytes.length - 1);
			byteToBitString(!flag, huffmanBytes[i]);
		}
		Map<String,Byte > map = new HashMap<>();
		for(Map.Entry<Byte, String> entry: huffmanCodes.entrySet()) 
		{
			map.put(entry.getValue(),entry.getKey());
		}
		List<Byte> list = new ArrayList<>();
		for (int i = 0; i < stringBuilder.length(); i++)
		{
			int count = 1;
			boolean flag = true;
			Byte b = null;
			while(flag) 
			{
				String key = stringBuilder.substring(i, i + count);
				b = map.get(key);
				if(b == null) 
				{
					count++;
				}else 
				{
					flag = false;
				}
			}
			list.add(b);
			i += count;
		}
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; )
		{
			b[i] = list.get(i);
		}
		return b;
	}
	public static void zipFile(String srcFile, String dstFile) 
	{
		//srcFile文件路径
		//dstFile压缩后的存放路径
		FileInputStream is = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;
		try
		{
			//创建一个文件输入流
			is = new FileInputStream(srcFile);
			//创建一个和文件大小一样的byte[]
			byte[] b = new byte[is.available()];
			//读取文件
			is.read(b);
			//获取到文件对应的哈夫曼编码'
			byte[] huffBytes = zip(b);
			
			//创建文件的输出流
			os = new FileOutputStream(dstFile);
			oos = new ObjectOutputStream(os);
			oos.writeObject(huffBytes);;
			oos.writeObject(huffmanCodes);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{
			try
			{
				is.close();
				os.close();
				oos.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void unZipFile(String zipFile, String destFile) 
	{
		InputStream is = null;
		ObjectInputStream ois = null;
		OutputStream os = null;
		try
		{
			is = new FileInputStream(zipFile);
			ois = new ObjectInputStream(is);
			byte[] huffmanBytes = (byte[]) ois.readObject();
			@SuppressWarnings("unchecked")
			Map<Byte,String> huffmancodes = (Map<Byte,String>)ois.readObject();
			byte[] b = decose(huffmancodes, huffmanBytes);
			os = new FileOutputStream(destFile);
			os.write(b);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{
			
			try
			{
				os.close();
				ois.close();
				is.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class Node implements Comparable<Node>
{
	Byte data;//存放数据本身,比如'a' => 97
	int weight;//权值,表示字符出现的个数
	Node right;
	Node left;
	public Node(Byte data, int weight)
	{
		super();
		this.data = data;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o)
	{
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
	@Override
	public String toString()
	{
		return "Node [data=" + data + ", weight=" + weight + "]";
	}
	//前序
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
	
}
