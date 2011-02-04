package hive;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class Board 
//implements Iterable<Piece> 
{
//	grid[y][x]
	private Piece[][] grid = new Piece[44][44];
	
//	private Point getNextPoint(int x, int y) {
//		assert(this.isHexCoordinate(x, y));
//		
//		if (x + 2 < 44)
//			return new Point(y, x + 2);
//		else if ((y + 1) % 2 == 0)
//			return new Point(y + 1, 1);
//		else if ((y + 1) % 2 == 1)
//			return new Point(y + 1, 0);
//		
//		return null;
//	}
//	
//	private Iterator<Piece> iterator = new Iterator<Piece>() {
//		private int x, y;
//		
//		
//		/**
//		 * Returns whether there is another PIECE on the board
//		 */
//		@Override
//		public boolean hasNext() {
//			int x = this.x, y = this.y;
//			return Board.this.getNext(x, y) != null;
//		}
//
//		@Override
//		public Piece next() {
//			Point point = Board.this.getNext(x, y);
//			return null;
//		}
//
//		@Override
//		public void remove() {
//			// TODO Auto-generated method stub
//			
//		}
//	};
//	
//	private boolean isHexCoordinate(int x, int y) {
//		if (y % 2 == 0) {
//			if (x % 2 == 1) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
//		else if (x % 2 == 0) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	
//	public ArrayList<Point> getAdjacentCoordinates(int x, int y) {
//		ArrayList<Point> coordinates = new ArrayList<Point>();
//		
//		if (this.isHexCoordinate(x,y)) {
//			if (y - 2 >= 0)
//				coordinates.add(new Point(x , y - 2));
//			if (x + 1 < this.grid.length && y - 1 >= 0)
//				coordinates.add(new Point(x+1,y-1));
//			if (x + 1 < this.grid.length && y + 1 < this.grid.length)
//				coordinates.add(new Point(x+1,y+1));
//			if (y + 2 < this.grid.length)
//				coordinates.add(new Point(x,y+2));
//			if (x - 1 >= 0 && y + 1 < this.grid.length)
//				coordinates.add(new Point(x-1,y+1));
//			if (x - 1 >= 0 && y - 1 >= 0)
//				coordinates.add(new Point(x-1,y-1));
//		}
//		
//		return coordinates;
//	}
//
//
//	@Override
//	public Iterator iterator() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	Whether the specified location or its neighbors have a piece in them. 
	public boolean contains(int destX, int destY) {
		if (	this.grid[destY - 0][destX - 0] != null ||
				
				this.grid[destY - 1][destX - 1] != null ||
				this.grid[destY - 2][destX - 0] != null ||
				this.grid[destY - 1][destX + 1] != null ||

				this.grid[destY + 1][destX + 1] != null ||
				this.grid[destY + 2][destX + 0] != null ||
				this.grid[destY + 1][destX - 1] != null
				)
			return true;
		else
			return false;
	}

	public void setLocation(Piece piece, int destX, int destY) {
		Point location = this.getLocation(piece);
		if (location != null) this.grid[location.y][location.x] = null;
		this.grid[destY][destY] = piece;
	}
	
	private Point getLocation(Piece piece) {
		for (int y = 0; y < this.grid.length; y++) {
			for (int x = 0; x < this.grid[y].length; x++) {
				if (this.grid[y][x] == piece) return new Point(x, y);
				
				Piece bottomPiece = this.grid[y][x];
				while (bottomPiece.top != null) {
					if (bottomPiece.top == piece) return new Point(x, y);
					else bottomPiece = bottomPiece.top;
				}
			}
		}
		
		return null;
	}
}
