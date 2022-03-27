/*
 * Board.java
 *
 * Version:
 *     1
 *
 * Revisions:
 *     1
 */

/**
 * This is an abstract class which places pieces and prints the board.
 * 
 * @author      Sharvai Patil (sp4479@g.rit.edu)
 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */
 
abstract class Board{
	static char board[][];

	char maxboard[][];
	char currentboard[][];

	int maxPieces = 0;
	int currentPieces = 0;

	abstract boolean checkPositionValid(int r, int c);   //abstract class to check if the positin is valid for that row and column
	
	/**
	* This class places pieces recursively if position is valid.
	*
	*
	* @param       r    		Stores the rows
	*			   c		    Stores the columns
	*			   pieceChar	Stores the piece which is to be placed recursively
	*
	* @return      void
	*
	*/

	void placePieces(int r, int c, char pieceChar){
		if(currentboard[r][c]==pieceChar){
			checkMaxPieces();
			return;
		}
		else{
			if(checkPositionValid(r,c)){
				currentboard[r][c]=pieceChar;
				currentPieces+=1;
	
				int r1=r;
				int c1=c+1;
				if(c1==currentboard[0].length){
					c1=0;
					r1+=1;
					if(r1==currentboard.length){
						r1=0;
					}
				}
				
				for(int i=r1; i<currentboard.length; i++){
					for(int j=c1; j<currentboard[0].length; j++){
						placePieces(i,j, pieceChar);

					}
				}                
				
				currentboard[r][c]=board[r][c]; //?
				currentPieces-=1;

			}
			else{
				int r1=r;
				int c1=c+1;
				if(c1==currentboard[0].length){
					c1=0;
					r1+=1;
					if(r1==currentboard.length){
						r1=0;
					}
				}
				placePieces(r1,c1, pieceChar);
			}
		}
	}
	
	/**
	* This class prints the current board.
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/

	void printBoard(){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				System.out.print(currentboard[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	* This method prints max board
	*
	*
	* @param       pieceName    		Stores the piece for which the max board is to be printed 
	*
	* @return      void
	*
	*/
	void printMaxBoard(String pieceName){
		System.out.println("Maximum number of "+pieceName+" = "+maxPieces);
		for(int i=0; i<maxboard.length; i++){
			for(int j=0; j<maxboard[0].length; j++){
				System.out.print(maxboard[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	* This method reset current board.
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/

	void resetCurrentBoard(){
		currentPieces=0;
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				currentboard[i][j]=board[i][j];
			}
		}
	}
	
	/**
	* This method copies current board to max board 
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/
	void copyCurrentBoardToMaxBoard(){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				maxboard[i][j]=currentboard[i][j];
			}
		}
	}
	
	/**
	* This method checks max pieces. 
	*
	*
	* @param       None
	*
	* @return      void
	*
	*/

	void checkMaxPieces(){
		if(currentPieces>maxPieces){
			maxPieces=currentPieces;
			copyCurrentBoardToMaxBoard();
		}
	}
		
}