package hive;

public class Piece {
	boolean canJump, canClimb;
	int moves; // -1 means infinite.
	Player player;
	Piece top; //The piece that is taking an unsolicited piggyback ride on this piece. 
	
	public Piece(Player player) {
		this.player = player;
	}
}

class Bee extends Piece {
	public Bee(Player player) {
		super(player);
		this.canJump = false;
		this.canClimb = false;
		this.moves = 1;
	}
}

class Ant extends Piece {
	public Ant(Player player) {
		super(player);
		this.canJump = false;
		this.canClimb = false;
		this.moves = -1;
	}
}

class Spider extends Piece {
	public Spider(Player player) {
		super(player);
		this.canJump = false;
		this.canClimb = false;
		this.moves = 3;
	}
}

class Beatle extends Piece {
	public Beatle(Player player) {
		super(player);
		this.canJump = false;
		this.canClimb = true;
		this.moves = 1;
	}
}

class Grasshopper extends Piece {
	public Grasshopper(Player player) {
		super(player);
		this.canJump = true;
		this.canClimb = false;
		this.moves = 0;
	}
}