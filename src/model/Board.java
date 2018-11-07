package model;

import java.util.ArrayList;

public class Board {
	
	/* instance variables */
	Tile[][] board;
	ArrayList<Tile> tileList;
	int width;
	int height;
	int moves;
	
	Tile selected = null;
	
	public Board (int width, int height){
		board = new Tile[width][height];
		tileList = new ArrayList<>();
		this.width = width;
		this.height = height;
		moves = 0;
	}
	
	public Tile selected() {
		return selected;
	}
	
	public int moves() {
		return moves;
	}
	
	/**
	 * Place the given tiles on the board
	 * @param tiles given tiles
	 */
	public void addTile(Tile... tiles) {
		for (Tile t: tiles) {
			tileList.add(t);
			for (int i = t.x; i < t.x+t.width; i++) {
				for (int j = t.y; j < t.y+t.height; j++) {
					board[i][j] = t;
				}
			}
		}
	}
	
	public void clear() {
		tileList.clear();
		board = new Tile[width][height];
		selected = null;
		moves = 0;
	}
	
	public void setSelected (int x, int y) {
		selected = selectTile(x, y);
	}
	
	public Tile selectTile (int x, int y) {
		if (x<0 || y<0 || x>board.length || y>board[0].length)
			return null;
		return board[x][y];
	}
	
	public Iterable<Tile> tiles(){
		return tileList;
	}
	
	public boolean tryMove (MoveType m) {
		Tile t = selected;
		if (t == null) {
			System.out.println("not selected");
			return false;
		}
		int x = t.x, y = t.y, w = t.width, h = t.height;
		int nx = x + m.dx;
		int ny = y + m.dy;
		
		// check if out of the boundary
		if (nx < 0 || ny < 0 || nx+w > width || ny+h > height) {
			System.out.println("out of boundary");
			return false;
		}
		// check if move is blocked by other tiles
		for (int i = nx; i < nx+w; i++) {
			for (int j = ny; j < ny+h; j++) {
				if(board[i][j] != null && board[i][j] != t) {
					System.out.println("blocked");
					return false;
				}
			}
		}
		// otherwise, valid move, update board
		for (int i = x; i < x+w; i++) {
			for (int j = y; j < y+h; j++) {
				board[i][j] = null;
			}
		}
		for (int i = nx; i < nx+w; i++) {
			for (int j = ny; j < ny+h; j++) {
				board[i][j] = t;
			}
		}
		// update tile
		t.x = nx;
		t.y = ny;
		// update moves
		moves++;
		
		return true;
	}
	
	public boolean victory() {
		if (board[1][4] != null && board[2][4] != null)
			return board[1][4].isLargest && board[2][4].isLargest;
		return false;
	}
}
