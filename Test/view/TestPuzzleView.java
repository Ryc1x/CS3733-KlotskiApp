package view;

import junit.framework.TestCase;
import controller.*;
import model.*;

public class TestPuzzleView extends TestCase {
	KlotskiApp app;
	Board board;
	
	protected void setUp() {
		board = new Board(4,5);
		app = new KlotskiApp(board);
		new ResetPuzzle(app,board).reset();
		app.setVisible(true);
	}
	
	protected void tearDown() {
		app.setVisible(false);
	}
	
	public void testMapping() {
		// wait 1 second for GUI to appear...
		try { Thread.sleep(1000); } catch (Exception e) { }
		PuzzleView view = app.getPuzzleView();
		
		app.setVisible(true);
		
	}
	
}
