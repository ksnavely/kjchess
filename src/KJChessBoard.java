/**
 * 
 */
import java.math.BigInteger;
/**
 * @author ksnavely
 *
 */
public class KJChessBoard {
	public char[] bgCharArray = { '#', '-', '#', '-', '#', '-', '#', '-', 
					              '-', '#', '-', '#', '-', '#', '-', '#',
					              '#', '-', '#', '-', '#', '-', '#', '-',
					              '-', '#', '-', '#', '-', '#', '-', '#',
					              '#', '-', '#', '-', '#', '-', '#', '-', 
					              '-', '#', '-', '#', '-', '#', '-', '#',
					              '#', '-', '#', '-', '#', '-', '#', '-',
					              '-', '#', '-', '#', '-', '#', '-', '#' };
    public KJChessPiece[] pieces = {
        // White
        new KJChessPiece('R', 'W', "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "10000001"),
        new KJChessPiece('B', 'W', "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "01000010"),
        new KJChessPiece('N', 'W', "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00100100"),
        new KJChessPiece('Q', 'W', "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00010000"),
        new KJChessPiece('K', 'W', "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00001000"),
        new KJChessPiece('P', 'W', "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "11111111" +
                                   "00000000"),
        // Black
        new KJChessPiece('R', 'B', "10000001" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000"),
        new KJChessPiece('B', 'B', "01000010" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000"),
        new KJChessPiece('N', 'B', "00100100" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000"),
        new KJChessPiece('Q', 'B', "00001000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000"),
        new KJChessPiece('K', 'B', "00010000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000"),
        new KJChessPiece('P', 'B', "00000000" +
                                   "11111111" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000" +
                                   "00000000")
    };
	
	public char[] makeBoardCharArray() {
		char[] boardCharArray = new char[this.bgCharArray.length];
		System.arraycopy(this.bgCharArray, 0, boardCharArray, 0, this.bgCharArray.length);
		
		int i;
		BigInteger bit;

		// Set charArray values
		for (KJChessPiece piece:this.pieces) {
			for (i=0; i<64; i++) {
				bit = piece.getBitBoard().and( BigInteger.valueOf(1).shiftLeft(i) );
				if (!bit.equals(BigInteger.valueOf(0)))
					boardCharArray[i] = piece.getText();
			}
		}
		
		return boardCharArray;
	}
	
	public String makeBoardString() {
		int row, col;
		String boardRowString;
		String boardString = "";
		char[] boardCharArray = makeBoardCharArray();
		
		// Build the string
		for (row = 0; row <= 7; row++) { 
			boardRowString = "|";
			for (col = 7; col >=0; col--) {
			    boardRowString += boardCharArray[row*8 + col] + "|";
			}
			boardRowString += "\n";
			boardString = boardRowString + boardString;
		}
		
		return boardString;
	}
}
