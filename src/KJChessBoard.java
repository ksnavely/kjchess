/**
 * KJChessBoard 
 *
 * This object will hold the KJChessPiece instances, and provide
 * the API for moving a piece. It also contains methods for dislaying 
 * the board.
 *
 * Create a KJChessBoardView with an API that can eventually
 * become graphical.
 */
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ksnavely
 *
 */
public class KJChessBoard {
    // The "black and white" chess board tiles
    public char[] bgCharArray = { '#', '-', '#', '-', '#', '-', '#', '-', 
                                  '-', '#', '-', '#', '-', '#', '-', '#',
                                  '#', '-', '#', '-', '#', '-', '#', '-',
                                  '-', '#', '-', '#', '-', '#', '-', '#',
                                  '#', '-', '#', '-', '#', '-', '#', '-', 
                                  '-', '#', '-', '#', '-', '#', '-', '#',
                                  '#', '-', '#', '-', '#', '-', '#', '-',
                                  '-', '#', '-', '#', '-', '#', '-', '#' };
    
    // The KJChessPiece objects which hold the bitfields for the pieces
    public KJChessPiece[] pieces = {
        new KJChessPawn('W'),
    };
    
    // This HashMap transforms chess column coordinates into integer values for bit operations
    private static final Map<Character, Integer> rowMap = new HashMap<Character, Integer>();
    static {
        rowMap.put('a',8);
        rowMap.put('b',7);
        rowMap.put('c',6);
        rowMap.put('d',5);
        rowMap.put('e',4);
        rowMap.put('f',3);
        rowMap.put('g',2);
        rowMap.put('h',1);
    }

    
    /**
     * makeBoardCharArray()
     * 
     * returns array of characters which are the overlay of the pieces on the background
     */
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
                    boardCharArray[i] = piece.getPieceChar();
            }
        }
        
        return boardCharArray;
    }
    
    
    /**
     * makeBoardString()
     * 
     * returns a nicely formatted chess board String for display
     */
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

    /**
     * movePiece( String coords )
     * 
     * Should
     *     1) Find the piece that can move to the specified coords by checking allowable moves
     *  2) Perform the move and determine captures
     *  3) Update PGN history
     * @param coords
     */
    public void movePiece(String coords) {
        KJChessPiece piece = this.getPieceWithAllowedMove(coords);
        int shift;

        if ( piece == null ) 
            System.out.print( "Illegal move!\n" );
        else {
            try {
                shift = this.getCoordShift( coords );
                piece.move( shift );
            }
            catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }
    
    /**
     * getPieceAt( String coords )
     * 
     * Given coords, return the piece at that coord. For non-pawns, the first
     * coord letter must match e.g. "Nc1" needs to be a night.
     * @param coords
     * @return
     */
    public KJChessPiece getPieceAt( String coords ) {
        // By default, the piece is a pawn e.g. opening a4
        char pieceChar = 'P';
        int shift;
        // If it's not, e.g. Nb3, get the char and chop the string
        if (coords.length() == 3) {
            pieceChar = coords.charAt(0);
            coords = coords.substring(1);
        }
        
        try {
            shift = this.getCoordShift( coords );
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }

        BigInteger bit;
        
        // Go through the pieces and see if one with matching pieceChar is at the shift value
        for (KJChessPiece piece:this.pieces) {
            bit = piece.getBitBoard().and( BigInteger.valueOf(1).shiftLeft(shift - 1) );
            if (!bit.equals(BigInteger.valueOf(0)) && pieceChar == piece.getPieceChar())
                return piece;
        }
        // No match found...
        return null;
    }

    public int getCoordShift( String coords ) throws Exception {
        if (coords.length() != 3 && coords.length() != 2) {
            throw new Exception("Bad coordinates string? E.g. a3, Qc7...\n");
        }

        if (coords.length() == 3)
            coords = coords.substring(1);

        int col, row, shift;

        try {
            col = rowMap.get(coords.charAt(0));
        }
        catch (NullPointerException e) {
            throw new Exception("Bad column letter? (a-h valid)\n");
        }
        row = new Integer( Character.toString( coords.charAt(1) ) );

        if (row > 8 || col > 8) {
            throw new Exception("Coordinates off the chessboard?\n");
        }

        shift = 8*(row - 1) + col - 1;
        return shift;
    }

    public KJChessPiece getPieceWithAllowedMove( String coords ) {
        // By default, the piece is a pawn e.g. opening a4
        char pieceChar = 'P';
        int shift;
        // If it's not, e.g. Nb3, get the char and chop the string
        if (coords.length() == 3) {
            pieceChar = coords.charAt(0);
            coords = coords.substring(1);
        }
        
        try {
            shift = this.getCoordShift( coords );
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
        BigInteger bit;
        for (KJChessPiece piece:this.pieces) {
            bit = piece.getAllowedMovesBitBoard().and( BigInteger.valueOf(1).shiftLeft(shift) );
            if (!bit.equals(BigInteger.valueOf(0)) && pieceChar == piece.getPieceChar())
                return piece;
        }
        
        return null;
    }
}
