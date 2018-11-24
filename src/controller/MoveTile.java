package controller;

import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;

import model.*;
import view.KlotskiApp;

public class MoveTile extends KeyAdapter {

	KlotskiApp app;
	Board board;
	
	public MoveTile(KlotskiApp a, Board b){
		app = a;
		board = b;
	}
	
	public void move(char key) {
		System.out.println(key);
		
		boolean validMove = false;
		if (key == 'a' || key == 'A') {
			validMove = board.tryMove(MoveType.LEFT);
		} else if (key == 's' || key == 'S') {
			if(board.victory()) {
				victoryMsg();
			} else { 
				validMove = board.tryMove(MoveType.DOWN);
			}
		} else if (key == 'd' || key == 'D') {
			validMove = board.tryMove(MoveType.RIGHT);
		} else if (key == 'w' || key == 'W') {
			validMove = board.tryMove(MoveType.UP);
		}
		if (validMove) {
			app.lblMoves.setText("Moves: " + board.moves());
			app.repaint();
		}
	}
	
	void victoryMsg() {
		String msg = "Congratulations! You've finished the Klotski puzzle!";
		JOptionPane.showMessageDialog(app, msg);	
	}
}
