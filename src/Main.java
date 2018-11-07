import java.awt.EventQueue;

import model.Board;
import controller.*;
import view.*;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board board = new Board(4,5);
					KlotskiApp app = new KlotskiApp(board);
					
					new ResetPuzzle(app,board).reset();
					app.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
