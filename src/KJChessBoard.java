/**
 * 
 */

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
		
		int bitrow, row, col, bit;

		// Set charArray values
		for (KJChessPiece piece:pieces) {
			for (row = 0; row <= 7; row++) { 
				bitrow = (int) (piece.getPosition() / Math.pow(2,  8*row));
				for (col = 0; col <=7; col++) {
					bit = (bitrow >> col) & 1;
					if (bit == 1)
						boardCharArray[row*8 + col] = piece.getText();
				}
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
			for (col = 0; col <=7; col++) {
			    boardRowString += boardCharArray[row*8 + col] + "|";
			}
			boardRowString += "\n";
			boardString = boardRowString + boardString;
		}
		
		return boardString;
	}
}
