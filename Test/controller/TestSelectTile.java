package controller;

import junit.framework.TestCase;
import model.*;
import view.*;

public class TestSelectTile extends TestCase {
	Board board;
	KlotskiApp app;
	
	protected void setUp() {
		board = new Board(4,5);
		app = new KlotskiApp(board);
		new ResetPuzzle(app,board).reset();
	}
	
	public void testSelect() {
		SelectTile s = new SelectTile(app, board);
		// test if maps x and y correctly
		s.select(150,100);
		assertEquals(board.selected(), board.selectTile(1,1));
		s.select(373,192);
		assertEquals(board.selected(), board.selectTile(3,1));
		s.select(233,320);
		assertEquals(board.selected(), board.selectTile(2,3));
		// if out of bound
		s.select(550,100);
		assertEquals(board.selected(), board.selectTile(5,1)); // null
		assertEquals(board.selected(), null);
	}
}
