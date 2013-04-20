/**
 * 
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
		
		System.out.print( pawn.move() + "\n");

	}

}
