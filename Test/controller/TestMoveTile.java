package controller;

import junit.framework.TestCase;
import model.Board;
import view.KlotskiApp;

public class TestMoveTile extends TestCase {
	Board board;
	KlotskiApp app;
	
	protected void setUp() {
		board = new Board(4,5);
		app = new KlotskiApp(board);
		new ResetPuzzle(app,board).reset();
	}
	
	public void testSelect() {
		MoveTile m = new MoveTile(app, board);
		board.setSelected(1, 2);
		assertEquals(board.selected().x(),1);
		m.move('d'); // move selected to right
		assertEquals(board.selected().x(),2);
		m.move('a'); // move selected to left
		assertEquals(board.selected().x(),1);
		
		board.setSelected(3, 3);
		m.move('a'); // move selected to left
		assertEquals(board.selected().y(),3);
		m.move('w'); // move selected up
		assertEquals(board.selected().y(),2);
		m.move('s'); // move selected down
		assertEquals(board.selected().y(),3);
		
	}
}
