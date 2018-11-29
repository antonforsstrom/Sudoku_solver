package SudokuLogic;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitSudokuTest {
	private Sudoku board;

	@Before
	public void setUp() throws Exception {
		board = new Sudoku();
	}

	@After
	public void tearDown() throws Exception {
		board = null;
	}

	
	/**
	 * First tests unsolvable then solvable
	 */
	@Test
	public final void testUnsolvableEmptyaBox() {
		board.clear();
		
		board.add(0,0,1);
		board.add(0,1,2);
		board.add(0,2,3);
		
		board.add(1,0,4);
		board.add(1,1,5);
		board.add(1,2,6);
		
		board.add(2,3,7);
		
		assertFalse("Sudoku should not be solved", board.solve());
		
		board.add(2,3,0);
		
		assertTrue("Sudoku should be solved", board.solve());
		
	}
	
	/**
	 * Tests methods: getValue() and clear().
	 */
	@Test
	public void testGetClear() {
		
		board.add(5, 5, 5);
		assertEquals("get() does not return correct value", 5, board.getValue(5, 5));
		
		board.clear();
		assertEquals("clear() does not clear board", 0, board.getValue(5, 5));
	
	}
	
	/**
	 * Test method: solve() on empty.
	 */
	@Test
	public void testSolveEmpty() {
		
		assertTrue("Empty board is not solved", board.solve());
	
	}
	
	/**
	 * Test method: solve() on solvable board.
	 */
	@Test
	public void testSolveSolvable() {
		board.add(0, 2, 8);
		board.add(0, 5, 9);
		board.add(0, 7, 6);
		board.add(0, 8, 2);
		
		board.add(1, 8, 5);
		
		board.add(2, 0, 1);
		board.add(2, 2, 2);
		board.add(2, 3, 5);
		
		board.add(3, 3, 2);
		board.add(3, 4, 1);
		board.add(3, 7, 9);
		
		board.add(4, 1, 5);
		board.add(4, 6, 6);
		
		board.add(5, 0, 6);
		board.add(5, 7, 2);
		board.add(5, 8, 8);
		
		board.add(6, 0, 4);
		board.add(6, 1, 1);
		board.add(6, 3, 6);
		board.add(6, 5, 8);
		
		board.add(7, 0, 8);
		board.add(7, 1, 6);
		board.add(7, 4, 3);
		board.add(7, 6, 1);
		
		board.add(8, 6, 4);
		
		assertTrue("Does not solve solvable board", board.solve());
	}
	
	

}
