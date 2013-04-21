/**
 * @author ksnavely
 *
 */
import java.math.BigInteger;

public abstract class KJChessPiece {
    char pieceChar, colorChar;
    BigInteger bitBoard;

	public KJChessPiece(char colorChar) {
		this.colorChar = colorChar;
	}

	public BigInteger getBitBoard() {
		return this.bitBoard;
	}	
	
	public BigInteger move() {
	    //this.position = this.position << this.moves[0];	
	    //this.position = (long) (this.position * Math.pow(2, ( this.moves[0] )));	
		return this.bitBoard;
	}

	public char getPieceChar() {
		return this.pieceChar;
	}

    public BigInteger flipBitBoard() {
        BigInteger b = new BigInteger("0");
        b = b.or( this.bitBoard.shiftLeft(56) ); 
        b = b.or( this.bitBoard.shiftLeft(40).and( new BigInteger( "00000000" +
                                                                   "11111111" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "00000000", 2 ) ) );
        b = b.or( this.bitBoard.shiftLeft(24).and( new BigInteger( "00000000" +
                                                                   "00000000" +
                                                                   "11111111" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "00000000", 2 ) ) );
        b = b.or( this.bitBoard.shiftLeft(8).and( new BigInteger(  "00000000" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "11111111" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "00000000" +
                                                                   "00000000", 2 ) ) );
        b = b.or( this.bitBoard.shiftRight(56) ); 
        b = b.or( this.bitBoard.shiftRight(40).and( new BigInteger( "00000000" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "11111111" +
                                                                    "00000000", 2 ) ) );
        b = b.or( this.bitBoard.shiftRight(24).and( new BigInteger( "00000000" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "11111111" +
                                                                    "00000000" +
                                                                    "00000000", 2 ) ) );
        b = b.or( this.bitBoard.shiftRight(8).and( new BigInteger(  "00000000" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "11111111" +
                                                                    "00000000" +
                                                                    "00000000" +
                                                                    "00000000", 2 ) ) );
        return b;
    }
}
