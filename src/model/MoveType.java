package model;

public enum MoveType {
	UP(0,-1), 
	DOWN(0,1),
	LEFT(-1,0),
	RIGHT(1,0);
	
	final int dx;
	final int dy;
	
	MoveType(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
}
