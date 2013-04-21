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
	
	public char[] makeBoardCharArray( KJChessPiece[] pieces ) {
		char[] boardCharArray = new char[this.bgCharArray.length];
		System.arraycopy(this.bgCharArray, 0, boardCharArray, 0, this.bgCharArray.length);
		
		int i;
		BigInteger bit;

		// Set charArray values
		for (KJChessPiece piece:pieces) {
			for (i=0; i<64; i++) {
				bit = piece.getBitBoard().and( BigInteger.valueOf(1).shiftLeft(i) );
				if (!bit.equals(BigInteger.valueOf(0)))
					boardCharArray[i] = piece.getText();
			}
		}
		
		return boardCharArray;
	}
	
	public String makeBoardString( KJChessPiece[] pieces ) {
		int row, col;
		String boardRowString;
		String boardString = "";
		char[] boardCharArray = makeBoardCharArray( pieces );
		
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
