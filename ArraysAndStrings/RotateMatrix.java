package ArraysAndStrings;

public class RotateMatrix {
int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
public static void main(String[] args) {
	RotateMatrix ro=new RotateMatrix();
	ro.display();
	//ro.rotateByLeft();
	//ro.display();
	System.out.println();
	/*ro.rotateByRight();
	ro.display();*/
	System.out.println();    //13951 141062 151173 161284
	ro.rotateInPlace();
	ro.display();
}
public void rotateInPlace()
{
	for(int i=0;i<matrix.length/2;i++)
	{
		int start=i;
		int end=matrix.length-1-i;
		for(int k=start;k<end;k++)
		{
			int offset=k-start;
			int top=matrix[start][k];
			matrix[start][k]=matrix[end-offset][start];//left-top
			matrix[end-offset][start]=matrix[end][end-offset];//bottom-left
			matrix[end][end-offset]=matrix[k][end];//right-bottom
			matrix[k][end]=top;//top-right
		}
	}
}
/*void rotate()
{
	for(int i=0;i<matrix.length/2;i++)
	{
		int start=i;
		int end=matrix.length-1-i;
		for(int k=start;k<end;k++)
		{
			int offset=k-start;
			int top=matrix[start][k];
			
		}
	}
}*/
void rotateByRight()
{
	swapRows();
	transpose();
}
void rotateByLeft()
{
	transpose();
	swapRows();
}
void transpose()
{
	int[][] temp=new int[matrix[0].length][matrix.length];
	for(int i=0;i<matrix.length;i++)
	{
		for(int j=0;j<matrix[0].length;j++)
		{
			temp[j][i]=matrix[i][j];
		}
	}
	matrix=temp;
}
void swapRows()
{
	for(int i=0,k=matrix.length-1;i<k;i++,k--)
	{
		int[] temp=matrix[i];
		matrix[i]=matrix[k];
		matrix[k]=temp;
	}
}
void display()
{
	/*System.out.println(matrix.length);
	System.out.println(matrix[0].length);*/
	for(int i=0;i<matrix.length;i++)
	{ System.out.println();
		for(int j=0;j<matrix[i].length;j++)
		{
			System.out.print(matrix[i][j]);
		}
	}	
}
}
