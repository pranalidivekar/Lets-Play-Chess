/*
 * Knight.java
 *
 * Version:
 *     1
 *
 * Revisions:
 *     1
 */

/**
 * This is class checks if the position is valid to place the knight and finds the max knights.
 * @author      Sharvai Patil (sp4479@g.rit.edu)
 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */
public class Knight extends Board {

	/**
	* Constructor to initialise maxboard and currentbard 
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/
	Knight(int n) {
		maxboard = new char[n][n];
		currentboard = new char[n][n];
	}

	public static void main(String args[]){

	}
	
	/**
	* This method finds max knights.
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/

	void findMaxKnights(){	
		System.out.println("~~~~~~~~ FINDING MAX KNIGHTS ~~~~~~~~");	
		
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                resetCurrentBoard();
                placePieces(i,j, 'K');
                checkMaxPieces();
            }
        }

		printMaxBoard("KNIGHTS");
	}

	/**
	* This method checks if the position is valid to place a knight
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
        	while(true){
				
				// checking coordinates of left-left-up
				if(r-1>=0 && c-2>=0 && currentboard[r-1][c-2]=='K'){
					flagPlacePiece = false;
					break;						
				}

				// checking coordinates of left-up-up
				if(r-2>=0 && c-1>=0 && currentboard[r-2][c-1]=='K'){							
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of left-left-down
				if(r+1<=currentboard.length-1 && c-2>=0 && currentboard[r+1][c-2]=='K'){
					flagPlacePiece = false;
					break;						
				}

				// checking coordinates of left-down-down
				if(r+2<=currentboard.length-1 && c-1>=0 && currentboard[r+2][c-1]=='K'){						
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of right-right-up
				if(r-1>=0 && c+2<=currentboard[0].length-1 && currentboard[r-1][c+2]=='K'){				
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of right-up-up
				if(r-2>=0 && c+1<=currentboard[0].length-1 && currentboard[r-2][c+1]=='K'){						
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of right-right-down
				if(r+1<=currentboard.length-1 && c+2<=currentboard[0].length-1 && currentboard[r+1][c+2]=='K'){
					flagPlacePiece = false;
					break;						
				}

				// checking coordinates of right-down-down
				if(r+2<=currentboard.length-1 && c+1<=currentboard[0].length-1 && currentboard[r+2][c+1]=='K'){						
					flagPlacePiece = false;
					break;
				}

				break;
			}	
        } 
        else{
            flagPlacePiece = false;
        }

        return flagPlacePiece;
    }


	

}