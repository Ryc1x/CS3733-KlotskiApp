package controller;

import java.awt.event.KeyEvent;

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
	
	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		System.out.println(key);
		
		boolean validMove = false;
		if (key == 'a') {
			validMove = board.tryMove(MoveType.LEFT);
		} else if (key == 's') {
			if(board.victory()) {
				victoryMsg();
			} else {
				validMove = board.tryMove(MoveType.DOWN);
			}
		} else if (key == 'd') {
			validMove = board.tryMove(MoveType.RIGHT);
		} else if (key == 'w') {
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
