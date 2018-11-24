package model;

import junit.framework.TestCase;
import controller.*;

public class TestBoard extends TestCase {
	Board board;
	Tile t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	
	protected void setUp() {
		board = new Board(4,5);
		t1 = new Tile(1,0,2,2);
		t2 = new Tile(0,0,1,1);
		t3 = new Tile(3,0,1,1);
		t4 = new Tile(0,1,1,2);
		t5 = new Tile(3,1,1,2);
		t6 = new Tile(1,2,1,2);
		t7 = new Tile(0,3,1,1);
		t8 = new Tile(3,3,1,1);
		t9 = new Tile(0,4,2,1);
		t10 = new Tile(2,4,2,1);
		t1.setLargest(true);
		
		board.addTile(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10);
	}
	
	public void testSetSelected () {
		assertEquals(board.selected, null);
		board.setSelected(0,0);
		assertEquals(board.selected,t2);
	}

	public void testSelectTile () {
		// valid numbers
		assertEquals(board.selectTile(0,0), t2);
		assertEquals(board.selectTile(2,1), t1);
		assertEquals(board.selectTile(0,4), t9);
		assertEquals(board.selectTile(3,2), t5);
		assertEquals(board.selectTile(3,3), t8);
		// empty spots
		assertEquals(board.selectTile(2,2), null);
		assertEquals(board.selectTile(2,3), null);
		// invalid numbers
		assertEquals(board.selectTile(-1,-1), null);
		assertEquals(board.selectTile(10,10), null);
		assertEquals(board.selectTile(0,5), null);
	}
	
	public void testTryMove() {
		// no selected tile
		board.selected = null;
		assertEquals(board.tryMove(MoveType.UP), false);
		// out of bound
		board.selected = t1;
		assertEquals(board.tryMove(MoveType.UP), false);
		assertEquals(board.tryMove(MoveType.LEFT), false);
		// blocked by other tiles
		assertEquals(board.tryMove(MoveType.DOWN), false);
		assertEquals(board.tryMove(MoveType.RIGHT), false);
		// valid moves
		board.selected = t8;
		assertEquals(board.tryMove(MoveType.LEFT), true);
	}
	
	public void testVictory() {
		assertEquals(board.victory(),false);
		board.clear();
		Tile t = new Tile(1,2,2,2);
		t.isLargest = true;
		board.addTile(t);
		assertEquals(board.victory(),false);
		// move one block down, victory
		board.clear();
		t.y = 3;
		board.addTile(t);
		assertEquals(board.victory(),true);
	}
	
}
