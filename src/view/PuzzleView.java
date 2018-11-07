package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Stroke;

import javax.swing.JPanel;

import model.Board;
import model.Tile;

/** 
 * Knows how to visually present the puzzle. 
 */
public class PuzzleView extends JPanel {

	Board board;
	int offset = 3;
	int scale = 100;
	
	public PuzzleView(Board b) {
		board = b;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 400, 500);
		
		for(Tile t: board.tiles()) {
			g.setColor(t.isLargest() ? Color.red : Color.lightGray);
			g.fillRect(t.x()*scale +offset, t.y()*scale +offset, t.width()*scale -offset*2, t.height()*scale -offset*2);
			g.setColor(Color.black);
			g.drawRect(t.x()*scale +offset, t.y()*scale +offset, t.width()*scale -offset*2, t.height()*scale -offset*2);
		}

		Tile s = board.selected();
		if (s != null) {
			g.setColor(Color.blue);
			g.drawRect(s.x()*scale +offset-1, s.y()*scale +offset-1, s.width()*scale -offset*2+2, s.height()*scale -offset*2+2);
		}

		
	}
	
}
