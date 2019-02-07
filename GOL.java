/*
 *   The Game of Life Exercise
 *   Stephanie Man
 *   A basic implementation of Game of Life. 
 *   The following assumptions are made:
 *   	The grid size in this game is 20 by 20.
 */






import java.util.Random;

public class GOL {
	
	int rows = 20; 
	int columns =20;
	int generation = 0; // Tracks number of iterations
	int[][] world;	// Game of Life World
	
	
	// Initialises a Game of Life world and sets up the world
	public GOL() {
		world = new int[columns][rows];
		init();
	}
	
	// Randomly populates the world with 0s or 1s
	public void init() {
		Random random = new Random();
		for(int i=0; i<columns; i++) {
			for(int j=0; j<rows; j++) {
				world[i][j] = random.nextInt(2);
			}
		}
	}
	
	// Generates the world for the next iteration 
	public void nextIteration() {
		int[][] next = new int[columns][rows];
		
		// Loop through every cell in array 
		for(int i=0; i<rows-1; i++) {
			for(int j=1; j<columns-1; j++) {
				
				// Get total count of neighbours for each cell
				int countNeighbours = 0;
				for(int k =-1; k<=1; k++) {
					for(int l = -1; l <=1; l++) {
			            countNeighbours += world[(i+k+rows)%rows][(j+l+columns)%columns];
					}
				}
				// Current cell was added to count so need to decrement
				countNeighbours -= world[i][j];
				
				// Implement the Game Of Life rules
				// Scenario: Underpopulation. Live cell with less than 2 neighbours die
				if((world[i][j] ==1) && (countNeighbours < 2)) {
					next[i][j] =0;
				}	
				// Scenario: Overcrowding. Live cell with more than 3 neighbours die
				else if((world[i][j] ==1) && (countNeighbours > 3)) {
					next[i][j] =0;
				}
				// Scenario:vEmpty cell has 3 neighbours, new cell is born
				else if(world[i][j]==0 && countNeighbours==3) {
					next[i][j] = 1;
				}
				// Scenario: stasis 
				else {
					next[i][j] = world[i][j];
				}
			}
		}
		world = next; // Next is our new iteration
		generation++; // This is the current generation

	}
		
	// Displays a visual representation of the current world, 
	// where live cells are represented by '@' and dead cells
	// are represented by '-'
	public void printWorld() {
			System.out.println("======================================");
			System.out.println("Generation: " + generation);
			for(int i=0; i<rows;i++) {
				for(int j=0; j<columns; j++) {
					
					// 
					if((world[i][j] == 1)) {
						System.out.print(" @ ");
					}
					else if(world[i][j] == 0) {
						System.out.print(" - ");
					}
				}
				System.out.println("");
			}
			System.out.println(" ");

		}


}
	
	
