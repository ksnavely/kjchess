/**
 * 
 */

/**
 * @author ksnavely
 *
 */
public class KJChessPiece {
	String text = "P";
	String color = "white";
	
    int position = 1;
    int maxPosition = 2^64;
    int minPosition = 0;
    
    // The only allowed move is up one
    // FIXME capture is an allowed move in special circumstances
    int[] moves;

	/**
	 * @param args
	 */
	public KJChessPiece(String pieceType) {
		this.moves = new int[1];
	    this.moves[0] = 8;
		// Do nothing
	}

	public int getPosition() {
		return this.position;
	}	
	
	public int move() {
	    //this.position = this.position << this.moves[0];	
	    this.position = (int) (this.position * Math.pow(2, ( this.moves[0] )));	
		return this.position;
	}

	public String getText() {
		return this.text;
	}
	
}
