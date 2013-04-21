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
import java.util.Scanner;

public class KJChess {
	public static Scanner in = new Scanner(System.in);
	public static KJChessPiece[] pieces = {
		// White
		// Back row
		new KJChessPiece('R', 'W', "00000000" +
								   "00000000" +
				                   "00000000" +
				                   "00000000" +
								   "00000000" +
								   "00000000" +
								   "00000000" +
								   "10000001"),
	};
	public static KJChessBoard chessBoard = new KJChessBoard();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("-- KJChess --\n");
		System.out.print( chessBoard.makeBoardString(pieces) + "\n" );
		System.out.print( promptMove() + "\n");
		
	}
	
	public static String[] promptMove() {
		System.out.print("Enter Move: ");
		String[] move = in.nextLine().trim().split(" ");
		return move;
	}
	
}
