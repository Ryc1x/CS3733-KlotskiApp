package controller;

import java.awt.event.MouseAdapter;

import view.PuzzleView;
import model.Board;
import view.KlotskiApp;

public class SelectTile extends MouseAdapter {
	
	KlotskiApp app; 
	Board board;
	
	public SelectTile (KlotskiApp a, Board b) {
		app = a;
		board = b;
	}
	
	public void select (int px, int py) {
		PuzzleView view = app.getPuzzleView();
		int x = px/100;
		int y = py/100;
		System.out.println(x + "  " + y);
		board.setSelected(x, y);
		view.repaint();
	}
	
	
	
}
