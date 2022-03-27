/*
 * Bishop.java
 *
 * Version:
 *     1
 *
 * Revisions:
 *     1
 */

/**
 * This is class checks if the position is valid to place the bishop and finds the max bishops.
 * @author      Sharvai Patil (sp4479@g.rit.edu)
 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */
public class Bishop extends Board {
	
	/**
	* Constructor to initialise maxboard and currentbard 
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/

	Bishop(int n) {
		maxboard = new char[n][n];
		currentboard = new char[n][n];
	}

	public static void main(String args[]){

	}
	
	/**
	* This method finds max bishops.
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/

	void findMaxBishops(){	
		System.out.println("~~~~~~~~ FINDING MAX BISHOPS ~~~~~~~~");	
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				resetCurrentBoard();
				placePieces(i,j, 'B');
				checkMaxPieces();
			}
		}

		printMaxBoard("BISHOPS");
	}

	/**
	* This method checks if the position is valid to place a bishop
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

			// checking for pieces in the diagonals
			int tempr;
			int tempc;
			// checking the left diagonal(going from top-left to bottom-right)
			// going to top-left
			tempr=r-1;
			tempc=c-1;
			while(tempr!=-1 && tempc!=-1){
				if(currentboard[tempr][tempc]=='B'){
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
				if(currentboard[tempr][tempc]=='B'){
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
				if(currentboard[tempr][tempc]=='B'){
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
				if(currentboard[tempr][tempc]=='B'){
					flagPlacePiece = false;
					break;
				}
				tempr+=1;
				tempc-=1;
			}


		}
		else{
			flagPlacePiece=false;
		}


        return flagPlacePiece;
    }
	

}