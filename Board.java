package hive;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class Board implements Iterable<Piece> {
	private Piece[][] grid = new Piece[44][44];
	
	private Point getNextPoint(int x, int y) {
		assert(this.isHexCoordinate(x, y));
		
		if (x + 2 < 44)
			return new Point(y, x + 2);
		else if ((y + 1) % 2 == 0)
			return new Point(y + 1, 1);
		else if ((y + 1) % 2 == 1)
			return new Point(y + 1, 0);
		
		return null;
	}
	
	private Iterator<Piece> iterator = new Iterator<Piece>() {
		private int x, y;
		
		
		/**
		 * Returns whether there is another PIECE on the board
		 */
		@Override
		public boolean hasNext() {
			int x = this.x, y = this.y;
			return Board.this.getNext(x, y) != null;
		}

		@Override
		public Piece next() {
			Point point = Board.this.getNext(x, y);
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	};
	
	private boolean isHexCoordinate(int x, int y) {
		if (y % 2 == 0) {
			if (x % 2 == 1) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (x % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ArrayList<Point> getAdjacentCoordinates(int x, int y) {
		ArrayList<Point> coordinates = new ArrayList<Point>();
		
		if (this.isHexCoordinate(x,y)) {
			if (y - 2 >= 0)
				coordinates.add(new Point(x , y - 2));
			if (x + 1 < this.grid.length && y - 1 >= 0)
				coordinates.add(new Point(x+1,y-1));
			if (x + 1 < this.grid.length && y + 1 < this.grid.length)
				coordinates.add(new Point(x+1,y+1));
			if (y + 2 < this.grid.length)
				coordinates.add(new Point(x,y+2));
			if (x - 1 >= 0 && y + 1 < this.grid.length)
				coordinates.add(new Point(x-1,y+1));
			if (x - 1 >= 0 && y - 1 >= 0)
				coordinates.add(new Point(x-1,y-1));
		}
		
		return coordinates;
	}


	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
