package DataStructures.sparsearray;

public class SarseArray
{

	public static void main(String[] args)
	{
		//先创建一个原始的二维数组
		//0:表示没有子	1:表示黑子 2:表示白子
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		//输出原始数组
		for(int[] row : chessArr1) 
		{
			for(int data : row) 
			{
				System.out.print(data + "\t");
			}
			System.out.println();
		}
		//先遍历二维数组遍历有多少不为零的个数
		int sum = 0;
		for (int i = 0; i < chessArr1.length; i++)
		{
			for (int j = 0; j < chessArr1[11].length; j++)
			{
				if(chessArr1[i][j] != 0) 
				{
					sum++;
				} 
			}
		}
		//创建对应的稀疏数组
		int sparseArray[][] = new int [sum + 1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		//遍历二维数组将其中值放入稀疏数组中
		int count = 0;
		for (int i = 0; i < chessArr1.length; i++)
		{
			for (int j = 0; j < chessArr1[11].length; j++)
			{
				if(chessArr1[i][j] != 0) 
				{
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chessArr1[i][j];
				} 
			}
		}
		//根据稀疏数组读取出二维数组
		int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
		for (int i = 1; i < sparseArray.length; i++)
		{
			chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
	}

}
