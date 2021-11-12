import org.junit.*;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameOfLifePinningTest {
	MainPanel panel;
	Cell[][] boardCells;
	@Before
	public void setUp() {
		Cell[][] boardCells=new Cell[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <5; j++) {
				Mockito.when(boardCells[i][j].getAlive()).thenReturn(false);
			}
		}
		panel=new MainPanel(boardCells);
		for(int j=1;j<=3;j++) {
			Mockito.when(boardCells[2][j].getAlive()).thenReturn(true);
		}
		
}
@Test 
	public void test1() {
	
	panel.calculateNextIteration();
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			Mockito.verify(boardCells[i][j].setAlive(i==1&&j==2)||(i==2&&j==2)||(i==3&&j==2));
		}
	}
}
@Test 
	public void test2() {
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			if (i==2&&j==1) {
				assertTrue(panel.iterateCell(i,j));
			}
			else if (i==2&&i==2) {
				assertTrue(panel.iterateCell(i,j));
			}
			else if (i==2&&i==3) {
				assertTrue(panel.iterateCell(i,j));
			}
			else {
				assertFalse(panel.iterateCell(i,j));
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