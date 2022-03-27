/*
 * Rook.java
 *
 * Version:
 *     1
 *
 * Revisions:
 *     1
 */

/**
 * This is class checks if the position is valid to place the Rook and finds the max Rooks.
 * @author      Sharvai Patil (sp4479@g.rit.edu)
 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */
public class Rook extends Board {

	/**
	* Constructor to initialise maxboard and currentbard 
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/
	Rook(int n) {
		maxboard = new char[n][n];
		currentboard = new char[n][n];
	}

	public static void main(String args[]){

	}
	/**
	* This method finds max rooks.
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/

	void findMaxRooks(){	
		System.out.println("~~~~~~~~ FINDING MAX ROOKS ~~~~~~~~");	
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				resetCurrentBoard();
				placePieces(i,j, 'R');
				checkMaxPieces();
			}
		}

		printMaxBoard("ROOKS");
	}

	/**
	* This method checks if the position is valid to place a rook
	*
	*
	* @param       r 		Stores the rows
	*			   c	    Stores the columns
	*
	* @return      boolean
	*
	*/
	boolean checkPositionValid(int r, int c){
        boolean flagPlacePiece = true;

        if(currentboard[r][c]!=' '){
			
			// checking for pieces in the row r
			for(int j=0; j<currentboard[0].length; j++){
				if(currentboard[r][j]=='R'){
					flagPlacePiece = false;
					break;
				}
			}

			// checking for pieces in the column c
			for(int i=0; i<currentboard[0].length; i++){
				if(currentboard[i][c]=='R'){
					flagPlacePiece = false;
					break;
				}
			}

		}
		else{
			flagPlacePiece = false;
		}

        return flagPlacePiece;
    }

	

}