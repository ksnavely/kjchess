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
		new KJChessPiece('R', 'W', (int) Math.pow(2,0)),
		new KJChessPiece('B', 'W', (int) Math.pow(2,1)),
		new KJChessPiece('N', 'W', (int) Math.pow(2,2)),
		new KJChessPiece('Q', 'W', (int) Math.pow(2,3)),
		new KJChessPiece('K', 'W', (int) Math.pow(2,4)),
		new KJChessPiece('N', 'W', (int) Math.pow(2,5)),
		new KJChessPiece('B', 'W', (int) Math.pow(2,6)),
		new KJChessPiece('R', 'W', (int) Math.pow(2,7)),
		// Pawns
		new KJChessPiece('P', 'W', (int) Math.pow(2,8)),
		new KJChessPiece('P', 'W', (int) Math.pow(2,9)),
		new KJChessPiece('P', 'W', (int) Math.pow(2,10)),
		new KJChessPiece('P', 'W', (int) Math.pow(2,11)),
		new KJChessPiece('P', 'W', (int) Math.pow(2,12)),
		new KJChessPiece('P', 'W', (int) Math.pow(2,13)),
		new KJChessPiece('P', 'W', (int) Math.pow(2,14)),
		new KJChessPiece('P', 'W', (int) Math.pow(2,15)),

		// Black
		// Back row
		new KJChessPiece('R', 'B', (int) Math.pow(2,57)),
		new KJChessPiece('B', 'B', (int) Math.pow(2,58)),
		new KJChessPiece('N', 'B', (int) Math.pow(2,59)),
		new KJChessPiece('Q', 'B', (int) Math.pow(2,60)),
		new KJChessPiece('K', 'B', (int) Math.pow(2,61)),
		new KJChessPiece('N', 'B', (int) Math.pow(2,62)),
		new KJChessPiece('B', 'B', (int) Math.pow(2,63)),
		new KJChessPiece('R', 'B', (int) Math.pow(2,64)),
		// Pawns
		new KJChessPiece('P', 'B', (int) Math.pow(2,49)),
		new KJChessPiece('P', 'B', (int) Math.pow(2,50)),
		new KJChessPiece('P', 'B', (int) Math.pow(2,51)),
		new KJChessPiece('P', 'B', (int) Math.pow(2,52)),
		new KJChessPiece('P', 'B', (int) Math.pow(2,53)),
		new KJChessPiece('P', 'B', (int) Math.pow(2,54)),
		new KJChessPiece('P', 'B', (int) Math.pow(2,55)),
		new KJChessPiece('P', 'B', (int) Math.pow(2,56))
	};
	public static KJChessBoard chessBoard = new KJChessBoard();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("-- KJChess --\n");
		System.out.print( chessBoard.makeBoardString(pieces) );
		System.out.print( promptMove() + "\n");
		
	}
	
	public static String[] promptMove() {
		System.out.print("Enter Move: ");
		String[] move = in.nextLine().trim().split(" ");
		return move;
	}
	
}
