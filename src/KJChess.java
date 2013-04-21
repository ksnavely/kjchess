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
    public static KJChessBoard chessBoard = new KJChessBoard();
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("-- KJChess --\n");
    	System.out.print( chessBoard.makeBoardString() + "\n" );

        while (true) {
        	appStep();
        }
        
    }
    
    public static void appStep() {
    	String move = promptMove();
    	chessBoard.movePiece( move );
    	System.out.print( "\n" + chessBoard.makeBoardString() + "\n" );
    }
    
    public static String promptMove() {
        System.out.print("Enter Move: ");
        String move = in.nextLine().trim();
        return move;
    }
    
}
