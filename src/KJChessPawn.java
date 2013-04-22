/**
 * @author ksnavely
 *
 */
import java.math.BigInteger;

public class KJChessPawn extends KJChessPiece {
	/**
	 * @param colorChar
	 */
	public KJChessPawn(char colorChar) {
		super(colorChar);
        this.pieceChar = 'P';
       // if ( this.colorChar == 'W' ) {
        this.bitBoard = new BigInteger( "00000000" +
                                        "00000000" +
                                        "00000000" +
                                        "00000000" +
                                        "00000000" +
                                        "00000000" +
                                        "11111111" +
                                        "00000000", 2 );
        if (this.colorChar == 'B')
            this.bitBoard = this.flipBitBoard();
	}

    public BigInteger getAllowedMovesBitBoard() {
        BigInteger allowed = this.bitBoard.shiftLeft(8);
        // Grab ONLY the second row of the bitBoard. If a pawn hasn't
        // moved it's bit is 1. Shift this only row up by two and or it
        // to the normal shifted allowe moves.
        BigInteger secondRow = new BigInteger( "00000000" +
                                               "00000000" +
                                               "00000000" +
                                               "00000000" +
                                               "00000000" +
                                               "00000000" +
                                               "11111111" +
                                               "00000000", 2 );

        allowed = allowed.or( this.bitBoard.and( secondRow ).shiftLeft(16) );
        return allowed;
    }
   
    public BigInteger move( int shift ) {
        BigInteger moveBitBoard = BigInteger.valueOf(1).shiftLeft( shift ); 

        // It was a single-row pawn advance
        if (shift <24)
            moveBitBoard = moveBitBoard.or( BigInteger.valueOf(1).shiftLeft( shift - 8 ) );
        else
            moveBitBoard = moveBitBoard.or( BigInteger.valueOf(1).shiftLeft( shift - 16 ) );

        this.bitBoard = this.bitBoard.xor( moveBitBoard );
        
		return this.bitBoard;
    }
}
