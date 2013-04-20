/**
 * KJChess
 * 
 * This is the application object. For now, debug scripts will be run in 
 * main as the application API is developed. Basic methods will be attached
 * to the application until they warrant separate libraries or classes.
 */

/**
 * @author ksnavely
 *
 */
public class KJChess {
	public static KJChessPiece pawn = new KJChessPiece("pawn");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("-- KJChess --\n");
		
		System.out.print( pawn.getPosition() + "\n");
		System.out.print( chessBoardView( pawn ) );
		
		pawn.move();

		System.out.print( pawn.getPosition() + "\n");
		System.out.print( chessBoardView( pawn ) );
		
	}
	
	public static String chessBoardView( KJChessPiece piece ) {
		// Returns chess board view of a piece
		String[] characters = { "#", piece.getText(), "-" };
		String boardString = "";
		String boardRowString = "";
		int bitrow, row, col, bit, c;

		for (row = 1; row <= 8; row++) { 
			bitrow = (int) (piece.getPosition() / Math.pow(2,  8*(row - 1)));
			boardRowString = "|";
			for (col = 1; col <=8; col++) {
				bit = (bitrow >> (col - 1)) & 1;
				if (bit == 0 && col % 2 == row % 2)
					c = 2;
				else
					c = bit;
				boardRowString += characters[ c ] + "|";

			}
			boardRowString += "\n";
			boardString = boardRowString + boardString;
		}
		
		return boardString;
		
	}

}
