package hive;

public class Engine {
	private Player currentPlayer;
	private Board board;

	//Attempt to perform the move requested by the player. If the move was successful, advance to the next player and return true.
	//If the move failed return false.
	public boolean move(Piece piece, int destX, int destY) {
		if (	this.currentPlayer.equals(piece.player) &&
				this.board.contains(destX, destY) &&
				piece.top != null &&
				this.canReach(piece, destX, destY) &&
				!this.isOnlyConnection(piece)
				) {
			this.board.setLocation(piece, destX, destY);
			this.currentPlayer = (this.currentPlayer == Player.BLACK ? Player.WHITE : Player.BLACK);
			return true;
		}
		else {
			return false;
		}
	}

	//Check if the piece's movement capabilities allow it to reach the specified location.
	private boolean canReach(Piece piece, int destX, int destY) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//Check whether moving this piece will cause some pieces to no longer be connected to the rest of the board, which is illegel.
	//True if an illegal situation will occur.
	//Must check the rules to see whether the test should check for stranded piece before or after the piece is put back down on the board.
	private boolean isOnlyConnection(Piece piece) {
		// TODO Auto-generated method stub
		return false;
	}
}