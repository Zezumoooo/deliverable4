import org.junit.*;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;



import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameOfLifePinningTest {
	MainPanel panel;
	@Before
	public void setUp() {
		
		Cell[][] boardCells=new Cell[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <5; j++) {
				cell[i][j]=new Cell();
			}
		}
		for(int j=1;j<=3;j++) {
			cell[2][j].setAlive(true);
		}
		panel.setCells(cell);
}
@After
	public void teardown() {
		// TODO Auto-generated method stub
	Cell=null;
	panel=null;
	boardCells=null;
	}
@Test 
	public void test1() {
	Cell[][] boardCells=new Cell[5][5];
	panel.calculateNextIteration();
	for(int i=0;i<2;i++) {
		for(int j=0;j<5;j++) {
			assertFalse(boardCells[j][i].getAlive());
		}
	}
	for(int i=1;i<=3;i++) {
		assertTrue(cell[i][2].getAlive());
	}
		for(int i=3;i<5;i++) {
			for(int j=0;j<5;j++) {
				assertFasle(boardCells[j][i].getAlive());
			}
		}
		panel.calculateNextIteration();
		for(int i=0;i<2;i++) {
			for(int j=0;j<5;j++) {
				assertFasle(boardCells[j][i].getAlive());
			}
		}
		for(int i=1;i<=3;i++) {
			assertTrue(boardCells[2][i].getAlive());
		}
		for(int i=3;i<5;i++) {
			for(int j=0;j<5;j++) {
				assertFalse(boardCells[j][i].getAlive());
			}
		}
}
@Test 
	public void test2() {
	Cell[][] boardCells=new Cell[5][5];
	for (int i = 0; i < 5; i++) 
	{
		for (int j = 0; j < 5; j++) 
		{
			if (j == 2) {
				if(i == 1 || i == 2 || i == 3) {
					assertEquals(boardCells.iterateCell(i,j),true);
				}
			}
			else {
				assertEquals(boardCells.iterateCell(i,j),false);
			}
		}
	}
}
@Test 
	public void test3() {
	Cell alive=new Cell(true);
	Cell dead=new Cell(false);
	assertEquals(alive.toString(),"x");
	assertEquals(dead.toString(), ".");
}
	/* TODO: Write the three pinning unit tests for the three optimized methods */

}