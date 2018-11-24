package controller;

import model.Board;
import model.Tile;
import view.KlotskiApp;

public class ResetPuzzle {
	
	KlotskiApp app;
	Board board;
	
	public ResetPuzzle(KlotskiApp a, Board b){
		app = a;
		board = b;
	}

	public void reset() {
		board.clear();
		
		Tile t1 = new Tile(1,0,2,2);
		Tile t2 = new Tile(0,0,1,1);
		Tile t3 = new Tile(3,0,1,1);
		Tile t4 = new Tile(0,1,1,2);
		Tile t5 = new Tile(3,1,1,2);
		Tile t6 = new Tile(1,2,1,2);
		Tile t7 = new Tile(0,3,1,1);
		Tile t8 = new Tile(3,3,1,1);
		Tile t9 = new Tile(0,4,2,1);
		Tile t10 = new Tile(2,4,2,1);
		t1.setLargest(true);
		
		board.addTile(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10);
		
		app.lblMoves.setText("Moves: 0");
		app.repaint();
	}
	
}
