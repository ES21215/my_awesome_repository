import java.util.ArrayList;

public class Trees 
{
static int myTree [] = {10,4,6,2,3,1,17,12,15,20,8};
static int leftLink [] = new int [11];
static int rightLink [] = new int [11];
static ArrayList <Integer> stack = new ArrayList <Integer>();

	public static void buildTree()
	{
	int root = myTree[0];
	int parent = 0;
	int currentPtr = 0;
	for(int i = 1; i<myTree.length;i++)
	{
		currentPtr = myTree[i];
		parent = root;
		while(true) {
		if(currentPtr<=parent)
		{
			if(leftLink[findIndex(parent)] == 0)
			{
				leftLink[findIndex(parent)] = findIndex(currentPtr);
				break;
			}
			else
			{
				parent = myTree[leftLink[findIndex(parent)]];
			}
		}
		else if(currentPtr>parent)
		{
			if(rightLink[findIndex(parent)] == 0)
			{
				rightLink[findIndex(parent)] = findIndex(currentPtr);
				break;
			}
			else
			{
				parent = myTree[rightLink[findIndex(parent)]];
			}
		}
	}
	}
	}
	public static int findIndex(int num)
	{
		for(int i= 0; i<myTree.length; i++)
		{
			if(myTree[i] == num)
			{
				return i;
			}
		}
		return -1;
	}
	public static void traversal()
	{
		int currentPtr = myTree[0];
		while(true)
		{
			while(leftLink[findIndex(currentPtr)] > 0)
			{
				push(currentPtr);
				currentPtr = myTree[leftLink[findIndex(currentPtr)]];
			}
			System.out.print(currentPtr + " ");
			if((leftLink[findIndex(currentPtr)] == 0) && (rightLink[findIndex(currentPtr)] == 0))
			{
				if(stack.isEmpty())
				{
					break;
				}
			
			currentPtr = pop();
			System.out.print(currentPtr + " ");
			}
			if(rightLink[findIndex(currentPtr)]>0)
			{
				currentPtr = myTree[rightLink[findIndex(currentPtr)]];
			}
				
		}}
	public static void push(int currentPtr)
	{
		stack.add(currentPtr);
	}
	public static int pop()
	{
		int pop = stack.get(stack.size()-1); 
		stack.remove(stack.get(stack.size()-1));
		return pop; 	
	}
public static void main(String[] args) {
	buildTree();
	traversal();
	}
}
	