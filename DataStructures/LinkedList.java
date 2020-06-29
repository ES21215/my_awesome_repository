public class LinkedList
{
static String[] listData = new String [25];
static int [] listIndex = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,-99};
static int myListLoc = -1;
static int freeListLoc = 0;


	public static void createList() //assigns value to listVal
	{
		myListLoc = freeListLoc;
		freeListLoc = listIndex[freeListLoc];
		listData[0] = "A";
		listIndex[0] = -99;
	}
	public static void printLinkedLists() //prints Linked List (Value, Pointer)
	{
		int currentPtr = myListLoc;
		System.out.println(listData[currentPtr] + ", " + listIndex[currentPtr]);
		while(listIndex[currentPtr] != -99)
		{
			currentPtr = listIndex[currentPtr];
			System.out.println(listData[currentPtr] + ", " + listIndex[currentPtr]);
		}
	}
	public static void addToFront(String data) //adds value/values to front of Linked List
	{
		int currentPtr = freeListLoc;
		freeListLoc = listIndex[freeListLoc];
		listIndex[currentPtr] = myListLoc;
		listData[currentPtr] = data;
		myListLoc = currentPtr;
	}
	
	public static void addToEnd(String data) //adds value/values to end of Linked List
	{
		int currentPtr = myListLoc;
		while(listIndex[currentPtr] != -99)
		{
			currentPtr = listIndex[currentPtr];
		}
		int nextPtr = freeListLoc;
		freeListLoc = listIndex[freeListLoc];
		listIndex[currentPtr] = nextPtr;
		listData[nextPtr] = data;
		listIndex[nextPtr] = -99;
	}
	
	public static void delFromFront() //deletes the number of items you send as a parameter
	{
		int currentPtr = myListLoc;
		myListLoc = listIndex[myListLoc];
		listData[currentPtr] = "null";
		listIndex[currentPtr] = freeListLoc;
		freeListLoc = currentPtr;
	}
	public static void delFromEnd()
	{
		int currentPtr = myListLoc;
		int prevPtr = -1;
		while(listIndex[currentPtr] != -99)
		{
			prevPtr = currentPtr;
			currentPtr = listIndex[currentPtr];	
		}
		listIndex[prevPtr] = -99;
		listData[currentPtr] = "null";
		listIndex[currentPtr] = freeListLoc;
		freeListLoc = currentPtr;
	}
	public static void beforeSpecificValue(String searchValue, String newValue)
	{
		{
			int value = searchList(searchValue);
			if(value == -1)
			{
				System.out.println("Error. This item could not be found in the List.");
			}
			else if(listIndex[value] == myListLoc-1)
			{
				addToFront(newValue);
			}
			else
			{
				int prevPtr = myListLoc;
				int currentPtr = listIndex[myListLoc];
				while (!(listData[currentPtr].equals(searchValue)))
				{
					prevPtr = currentPtr;
					currentPtr = listIndex[currentPtr];	
				}
				listData[freeListLoc] = newValue;
				listIndex[freeListLoc] = currentPtr;
				listIndex[prevPtr] = freeListLoc;
				freeListLoc+=1;
			}
		}
	}
	public static int searchList(String data)
	{
		int currentPtr = myListLoc;
		int myValLoc = -1;
		if(listData[currentPtr].equals(data))
		{
			myValLoc = currentPtr;
			return myValLoc;
		}
		while((listIndex[currentPtr] != -99))
		{
			currentPtr = listIndex[currentPtr];
			if(listData[currentPtr].equals(data))
			{
				myValLoc = currentPtr;
				break;
			}
		}
		return myValLoc;
	}
	public static void afterSpecificValue(String searchValue, String newValue)
	{
		int value = searchList(searchValue);
		if(value == -1)
		{
			System.out.println("Error. This item could not be found in the List.");
		}
		else if(listIndex[value] == -99)
		{
			addToEnd(newValue);
		}
		else
		{
			int newValIndex = listIndex[value];
			listIndex[value] = freeListLoc;
			listData[freeListLoc] = newValue;
			listIndex[freeListLoc] = newValIndex;
			freeListLoc+=1;
		}
	}
	public static void delFromMiddle(String searchValue)
	{
		int value = searchList(searchValue);
		if(value == -1)
		{
			System.out.println("Error. This item could not be found in the List.");
		}
		else if(listIndex[value] == myListLoc-1)
		{
			delFromFront();
		}
		else if(listIndex[value] == -99)
		{
			delFromEnd();
		}
		else
		{
			int prevPtr = myListLoc;
			int currentPtr = listIndex[myListLoc];
			while (!(listData[currentPtr].equals(searchValue)))
			{
				prevPtr = currentPtr;
				currentPtr = listIndex[currentPtr];	
			}
			listIndex[prevPtr] = listIndex[currentPtr];
			listData[currentPtr] = "null";
			listIndex[currentPtr] = freeListLoc;
		}
	}
	public static void main(String[] args) 
	{
		createList(); //assign values to listVal
		addToFront("B");
		addToFront("C");
		addToEnd("D");
		addToFront("W");
		addToFront("P");
		afterSpecificValue("A","M");
		beforeSpecificValue("A","Q");
		delFromFront();
		delFromEnd();
		delFromMiddle("A");
		printLinkedLists();
	}
}

