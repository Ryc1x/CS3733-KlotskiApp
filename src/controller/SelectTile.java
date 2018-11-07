package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	@Override
	public void mousePressed (MouseEvent e) {
		PuzzleView view = app.getPuzzleView();
		int x = e.getX()/100;
		int y = e.getY()/100;
		System.out.println(x + "  " + y);
		board.setSelected(x, y);
		view.repaint();
	}
	
	
	
}
