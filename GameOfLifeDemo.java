/*
 *  Game of Life demo
 *  Stephanie Man
 */
public class GameOfLifeDemo {

	public static void main(String[] args) throws InterruptedException {

		GOL life = new GOL();
		life.printWorld();
		while(true) {
			Thread.sleep(200);
			life.nextIteration();
			life.printWorld();
		}	
	}
}
