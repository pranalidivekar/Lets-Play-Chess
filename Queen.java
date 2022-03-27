/*
 * Queen.java
 *
 * Version:
 *     1
 *
 * Revisions:
 *     1
 */

/**
 * This is class checks if the position is valid to place the Queen and finds the max Queens.
 * @author      Sharvai Patil (sp4479@g.rit.edu)
 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */
public class Queen extends Board {

	/**
	* Constructor to initialise maxboard and currentbard 
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/
	Queen(int n) {
		board = new char[n][n];
		maxboard = new char[n][n];
		currentboard = new char[n][n];
	}

	public static void main(String args[]){

	}

	/**
	* This method finds max queens.
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/
	void findMaxQueens(){	
		System.out.println("~~~~~~~~ FINDING MAX QUEENS ~~~~~~~~");	
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				resetCurrentBoard();
				placePieces(i,j, 'Q');
				checkMaxPieces();
			}
		}

		printMaxBoard("QUEENS");
	}

	/**
	* This method checks if the position is valid to place a queen
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

		// checking if (r,c) is not a hole
		if(currentboard[r][c]!=' '){
			// System.out.println(r+","+c);			

			// checking for pieces in the row r
			for(int j=0; j<currentboard[0].length; j++){
				if(currentboard[r][j]=='Q'){
					flagPlacePiece = false;
					break;
				}
			}

			// checking for pieces in the column c
			for(int i=0; i<currentboard[0].length; i++){
				if(currentboard[i][c]=='Q'){
					flagPlacePiece = false;
					break;
				}
			}

			// checking for pieces in the diagonals
			int tempr;
			int tempc;
			// checking the left diagonal(going from top-left to bottom-right)
			// going to top-left
			tempr=r-1;
			tempc=c-1;
			while(tempr!=-1 && tempc!=-1){
				if(currentboard[tempr][tempc]=='Q'){
					flagPlacePiece = false;
					break;
				}
				tempr-=1;
				tempc-=1;
			}
			// going to bottom-right
			tempr=r+1;
			tempc=c+1;
			while(tempr!=currentboard.length && tempc!=currentboard[0].length){
				if(currentboard[tempr][tempc]=='Q'){
					flagPlacePiece = false;
					break;
				}
				tempr+=1;
				tempc+=1;
			}
			// checking the right diagonal(going from top-right to bottom-left)
			// going to top-right
			tempr=r-1;
			tempc=c+1;
			while(tempr!=-1 && tempc!=currentboard[0].length){
				if(currentboard[tempr][tempc]=='Q'){
					flagPlacePiece = false;
					break;
				}
				tempr-=1;
				tempc+=1;
			}
			// going to bottom-left
			tempr=r+1;
			tempc=c-1;
			while(tempr!=currentboard.length && tempc!=-1){
				if(currentboard[tempr][tempc]=='Q'){
					flagPlacePiece = false;
					break;
				}
				tempr+=1;
				tempc-=1;
			}

			

		}
		else{
			flagPlacePiece = false;
		}

		return flagPlacePiece;
	}

}