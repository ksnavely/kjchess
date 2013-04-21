/**
 * 
 */
import java.math.BigInteger;
/**
 * @author ksnavely
 *
 */
public class KJChessPiece {
    char text, color;
    BigInteger bitBoard;
    
    // The only allowed move is up one
    // FIXME capture is an allowed move in special circumstances
    int[] moves;

	/**
	 * @param args
	 */
	public KJChessPiece(char pieceChar, char color, String bitString) {
		this.text = pieceChar;
		this.color = color;
		this.bitBoard = new BigInteger( bitString, 2 );
		this.moves = new int[1];
	    this.moves[0] = 8;
		// Do nothing
	}

	public BigInteger getBitBoard() {
		return this.bitBoard;
	}	
	
	public BigInteger move() {
	    //this.position = this.position << this.moves[0];	
	    //this.position = (long) (this.position * Math.pow(2, ( this.moves[0] )));	
		return this.bitBoard;
	}

	public char getText() {
		return this.text;
	}
	
}
