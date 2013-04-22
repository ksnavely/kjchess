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
        return this.bitBoard.shiftLeft(8);
    }
   
    public BigInteger move( int shift ) {
        BigInteger moveBitBoard = BigInteger.valueOf(1).shiftLeft( shift ); 
        moveBitBoard = moveBitBoard.or( BigInteger.valueOf(1).shiftLeft( shift - 8 ) );

        this.bitBoard = this.bitBoard.xor( moveBitBoard );
        
		return this.bitBoard;
    }
}
