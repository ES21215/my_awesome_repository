//Etti Sherman
public class Matrices 
{
	private static void createMatrices(int [][] matrixA, int [][] matrixB)
	{
		int count = 1;
		for(int row = 0; row<matrixA.length; row++)
		{
			for(int col = 0; col<matrixA[0].length; col++)
			{
				matrixA[row][col] = count;
				matrixB[row][col] = 10-count;
				count++;
			}
		}
	}

	private static void printMatrix(int [][] matrix) 
	{
		for(int row = 0; row<matrix.length; row++)
		{
			for(int col = 0; col<matrix[0].length; col++)
			{
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println("");
		}
	}
	
	private static void addMatrix(int [][] matrixSum, int [][] matrixA, int [][] matrixB)	
	{
		for(int row = 0; row<matrixA.length; row++)
		{
			for(int col = 0; col<matrixA[0].length; col++)
			{
				matrixSum[row][col] = matrixA[row][col] + matrixB[row][col];
			}
		}
	}

	private static void subMatrix(int [][] matrixDifference, int [][] matrixA, int [][] matrixB)	
	{
		for(int row = 0; row<matrixA.length; row++)
		{
			for(int col = 0; col<matrixA[0].length; col++)
			{
				matrixDifference[row][col] = matrixA[row][col] - matrixB[row][col];
			}
		}
	}	

	private static void mulMatrix(int [][] matrixProduct, int [][] matrixA, int [][] matrixB)	
	{
		for(int set = 0; set<matrixA.length; set++)
		{
			for(int row = 0; row<matrixA.length; row++)
			{
				int product = 0;
				for(int col = 0; col<matrixA[0].length; col++)
				{	
					product = (matrixA[set][col] * matrixB[col][row]) + product;
				}
				matrixProduct[set][row] = product;	
			}
		}
	}

	public static final int SIZE = 3;
	public static void main (String[] args)
	{
		//variable for inputs
		int matrixA[][] = new int [SIZE][SIZE];
		int matrixB[][] = new int [SIZE][SIZE];
	
		//variables to store the results
		int matrixSum[][] = new int [SIZE][SIZE];
		int matrixDifference[][] = new int [SIZE][SIZE];
		int matrixProduct[][] = new int [SIZE][SIZE];
	
		System.out.println("Initializing Matrices...");
		createMatrices(matrixA, matrixB);
		System.out.println("\nMatrix A:");
		printMatrix(matrixA);
		System.out.println("\nMatrix B:");
		printMatrix(matrixB);
	
		addMatrix(matrixSum, matrixA, matrixB);
		System.out.println("\n\nMatrix Sum:");
		printMatrix(matrixSum);
	
		subMatrix(matrixDifference, matrixA, matrixB);
		System.out.println("\n\nMatrix Difference:");
		printMatrix(matrixDifference);
	
		mulMatrix(matrixProduct, matrixA, matrixB);
		System.out.println("\n\nMatrix Product:");
		printMatrix(matrixProduct);
		}
	}