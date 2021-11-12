import org.junit.*;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameOfLifePinningTest {
	/*
	 * READ ME: You may need to write pinning tests for methods from multiple
	 * classes, if you decide to refactor methods from multiple classes.
	 * 
	 * In general, a pinning test doesn't necessarily have to be a unit test; it can
	 * be an end-to-end test that spans multiple classes that you slap on quickly
	 * for the purposes of refactoring. The end-to-end pinning test is gradually
	 * refined into more high quality unit tests. Sometimes this is necessary
	 * because writing unit tests itself requires refactoring to make the code more
	 * testable (e.g. dependency injection), and you need a temporary end-to-end
	 * pinning test to protect the code base meanwhile.
	 * 
	 * For this deliverable, there is no reason you cannot write unit tests for
	 * pinning tests as the dependency injection(s) has already been done for you.
	 * You are required to localize each pinning unit test within the tested class
	 * as we did for Deliverable 2 (meaning it should not exercise any code from
	 * external classes). You will have to use Mockito mock objects to achieve this.
	 * 
	 * Also, you may have to use behavior verification instead of state verification
	 * to test some methods because the state change happens within a mocked
	 * external object. Remember that you can use behavior verification only on
	 * mocked objects (technically, you can use Mockito.verify on real objects too
	 * using something called a Spy, but you wouldn't need to go to that length for
	 * this deliverable).
	 */

	/* TODO: Declare all variables required for the test fixture. */
	@Mock
	private MainPanel mainPanel;

	@Mock
	private Cell [][] cells;

	@Before
	public void setUp() {
		/*
		 * TODO: initialize the text fixture. For the initial pattern, use the "blinker"
		 * pattern shown in:
		 * https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Examples_of_patterns
		 * The actual pattern GIF is at:
		 * https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#/media/File:Game_of_life_blinker.gif
		 * Start from the vertical bar on a 5X5 matrix as shown in the GIF.
		 */
		mainPanel = new MainPanel(5);
		cells = new Cell[5][5];
		for (int x = 0 ; x < 5; x++) {
			for (int y=0; y < 5; y++){
				cells[x][y] = new Cell();
			}
		}
		for (int y=1; y<=3; y++)
			cells[2][y].setAlive(true);

		mainPanel.setCells(cells);
	}

	/* TODO: Write the three pinning unit tests for the three optimized methods */
	@Test
	public void testCalculateNextIteration() {
		mainPanel.calculateNextIteration();
		for (int y = 0 ; y < 2; y++) {
			for (int x=0; x < 5; x++){
				assertFalse(cells[x][y].getAlive());
			}
		}
		for (int x=1; x<=3; x++)
			assertTrue(cells[x][2].getAlive());
		for (int y = 3 ; y < 5; y++) {
			for (int x=0; x < 5; x++){
				assertFalse(cells[x][y].getAlive());
			}
		}
		mainPanel.calculateNextIteration();
		for (int x = 0 ; x < 2; x++) {
			for (int y=0; y < 5; y++){
				assertFalse(cells[x][y].getAlive());
			}
		}
		for (int y=1; y<=3; y++)
			assertTrue(cells[2][y].getAlive());
		for (int x = 3 ; x < 5; x++) {
			for (int y=0; y < 5; y++){
				assertFalse(cells[x][y].getAlive());
			}
		}
	}

	@Test
	public void testIterateCell() {
		for (int y = 0 ; y < 2; y++) {
			for (int x=0; x < 5; x++){
				assertFalse(mainPanel.iterateCell(x, y));
			}
		}
		for (int x=1; x<=3; x++)
			assertTrue(mainPanel.iterateCell(x, 2));
		for (int y = 3 ; y < 5; y++) {
			for (int x=0; x < 5; x++){
				assertFalse(mainPanel.iterateCell(x, y));
			}
		}
	}

	@Test
	public void testToString() {
		for (int x = 0 ; x < 2; x++) {
			for (int y=0; y < 5; y++){
				assertTrue(cells[x][y].toString().equals("."));
			}
		}
		for (int y=1; y<=3; y++)
			assertTrue(cells[2][y].toString().equals("X"));
		for (int x = 3 ; x < 5; x++) {
			for (int y=0; y < 5; y++){
				assertTrue(cells[x][y].toString().equals("."));
			}
		}
	}
}
