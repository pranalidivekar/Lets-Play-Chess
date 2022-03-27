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
 * This program determines the maximum number of kings you can put on the traditional (nxn) chess 
 * board, such that no king is in check.
 *
 * @author      Sharvai Patil (sp4479@g.rit.edu)
 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */

public class Board{

	// declaring the initial board
	char board[][] = {
		{'w', 'b', 'w', 'b', 'w', 'b'},
		{'.', 'w', '.', 'w', '.', 'w'},
		{'w', '.', '.', '.', 'w', 'b'},
		{'b', '.', 'b', '.', 'b', 'w'},
		{'.', '.', '.', '.', '.', 'b'},
		{'b', 'w', 'b', 'w', 'b', 'w'},
	};

	// declaring the variables for the row and column coordinates
	int row=0;
	int column=0;

	// maxBoard stores the solution with the maximum number of kings 
	int maxKings = 0;
	char maxBoard[][]={
		{'w', 'b', 'w', 'b', 'w', 'b'},
		{'.', 'w', '.', 'w', '.', 'w'},
		{'w', '.', '.', '.', 'w', 'b'},
		{'b', '.', 'b', '.', 'b', 'w'},
		{'.', '.', '.', '.', '.', 'b'},
		{'b', 'w', 'b', 'w', 'b', 'w'},
	};

	// currentBoard is used to store every generated solution
	int currentKings = 0 ;
	char currentBoard[][] = {
		{'w', 'b', 'w', 'b', 'w', 'b'},
		{'.', 'w', '.', 'w', '.', 'w'},
		{'w', '.', '.', '.', 'w', 'b'},
		{'b', '.', 'b', '.', 'b', 'w'},
		{'.', '.', '.', '.', '.', 'b'},
		{'b', 'w', 'b', 'w', 'b', 'w'},
	};	


	/**
	* This method creates an object of the class and calls the recursiveMakeBoard()
	* function inorder to create all possible solutions
	* Finally, it checks for the solution with the maximum number of kings
	* and the final result is printed by called printBoard()
	*
	* @param       args    command-line arguments (ignored)
	*
	* @return              void
	*
	*/
	public static void main(String args[]){
		
		Board ob = new Board();

		//print the original board
		System.out.println("~~~~ Start State ~~~~");
		ob.printBoard(ob.board); 

		//checking if all cells are blocked
		if(ob.allCellsBlocked()==false){

			// calculating the total number of cells in the board
			int numCells = ob.board.length * ob.board[0].length;
			
			// Placing kings recursively from (0,0) to (board.length-1, board[0].length-1)
			for(int i=0;i<ob.board.length;i++){
				for(int j=0;j<ob.board[0].length;j++){

					// set the new start coordinates
					ob.row=i;
					ob.column=j;

					// reset current data
					ob.currentKings=0;
					ob.resetBoard(ob.currentBoard);

					// call recursiveMakeBoard() if cells>=4 else call lessThanFourMakeBoard()
					if(numCells>=4)
						ob.recursiveMakeBoard();
					else
						ob.lessThanFourMakeBoard();

					// print this solution
					// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
					// System.out.println("Kings placed = "+ob.currentKings);
					// ob.printBoard(ob.currentBoard);

					// check for max
					ob.checkMax();
					
				}
			}
			
			// printing the final solution
			System.out.println("\n~~~~ Final solution ~~~~");
			ob.printBoard(ob.maxBoard);
			System.out.println("Max number of kings is = "+ob.maxKings);
		}
		else{
			System.out.println("\n~~~~ Final solution ~~~~");
			ob.printBoard(ob.board);
			System.out.println("Max number of kings is = 0");
		}

	}


	/**
	* This method checks if the current solution in currentBoard 
	* has more number of kings than the solution with the maximum number 
	* of kings. If yes, the current solution is the max solution
	*
	* @param       none    
	*
	* @return              void
	*
	*/
	void recursiveMakeBoard(){

		// Base case: if we stumble upon a cell which already has a King in it
		// we end the recursion
		if(currentBoard[row][column]=='K')
			return;

		// test (row, column) if it isn't blocked
		if(currentBoard[row][column]!='.'){
			
			// Now for every cell, we will check if it is valid to place a King in it
			// the case when we are testing for the first row
			if(row==0){		
				if(column==0){
					// this is (0,0)
					if(currentBoard[row][column+1]!='K' && currentBoard[row+1][column]!='K' 
					   && currentBoard[row+1][column+1]!='K'){
						currentBoard[row][column]='K';
						currentKings+=1;
					}
				}
				else if(column==currentBoard[0].length-1){
					// this is (0,5)
					if(currentBoard[row][column-1]!='K' && currentBoard[row+1][column]!='K' 
					   && currentBoard[row+1][column-1]!='K'){
						currentBoard[row][column]='K';
						currentKings+=1;
					}
				}
				else{
					// this is to test blocks from (0,1) to (0,4)
					if(currentBoard[row][column-1]!='K' && currentBoard[row][column+1]!='K' 
					   && currentBoard[row+1][column-1]!='K' && currentBoard[row+1][column+1]!='K'
					   && currentBoard[row+1][column]!='K'){
						currentBoard[row][column]='K';
						currentKings+=1;
					}
				}
			}
			// the case when we are testing for the last row
			else if(row==currentBoard.length-1){
				if(column==0){
					// this is (5,0)
					if(currentBoard[row][column+1]!='K' && currentBoard[row-1][column]!='K' 
					   && currentBoard[row-1][column+1]!='K' ){
						currentBoard[row][column]='K';
						currentKings+=1;
					}
				}
				else if(column==currentBoard[0].length-1){
					// this is (5,5)
					if(currentBoard[row][column-1]!='K' && currentBoard[row-1][column]!='K' 
					   && currentBoard[row-1][column-1]!='K'){
						currentBoard[row][column]='K';
						currentKings+=1;
					}
				}
				else{
					// this is to test blocks from (5,1) to (5,4)
					if(currentBoard[row][column-1]!='K' && currentBoard[row][column+1]!='K' 
					   && currentBoard[row-1][column]!='K' && currentBoard[row-1][column+1]!='K' 
					   && currentBoard[row-1][column-1]!='K'){
						currentBoard[row][column]='K';
						currentKings+=1;
					}
				}
			}
			// the case where we are testing for all the rows in between
			else{
				if(column==0){
					// this is (row,0)
					if(currentBoard[row][column+1]!='K' && currentBoard[row-1][column]!='K' 
					   && currentBoard[row-1][column+1]!='K' && currentBoard[row+1][column]!='K' 
					   && currentBoard[row+1][column+1]!='K'){
						currentBoard[row][column]='K';
						currentKings+=1;
					}
				}
				else if(column==currentBoard[0].length-1){
					// this is (row,5)
					if(currentBoard[row][column-1]!='K' && currentBoard[row-1][column]!='K' 
					   && currentBoard[row-1][column-1]!='K' && currentBoard[row+1][column]!='K' 
					   && currentBoard[row+1][column-1]!='K'){
						currentBoard[row][column]='K';
						currentKings+=1;
					}
				}
				else{
					// this is to test blocks from (row,1) to (row,4)
					if(currentBoard[row][column-1]!='K' && currentBoard[row][column+1]!='K' 
					   && currentBoard[row-1][column]!='K' && currentBoard[row-1][column+1]!='K' 
					   && currentBoard[row-1][column-1]!='K' && currentBoard[row+1][column-1]!='K' 
					   && currentBoard[row+1][column]!='K' && currentBoard[row+1][column+1]!='K'){
						currentBoard[row][column]='K';
						currentKings+=1;
					}
				}
			}
		}

		// changing our coordinates so that we point to the next cell
		// if we reach the last column, we jump to the next row, first column
		// if we reach the last cell of the board, we jump to the first
		column+=1;
		if(column==currentBoard[0].length){
			column=0;
			row+=1;
			if(row==currentBoard[0].length){
				row=0;
			}
			
		}

		recursiveMakeBoard();
	}


	/**
	* This method replaces all the cells of the board passed to it 
	* by the corresponding cells of the original board
	*
	* @param       thisboard    2D array which contains the board configuration to be printed
	*
	* @return              		void
	*
	*/
	void resetBoard(char thisboard[][]){		
		for(int i=0; i<thisboard.length;i++){
			for(int j=0;j<thisboard[0].length;j++){
				thisboard[i][j]=board[i][j];
			}
		}
	}

	/**
	* This method checks if the current solution in currentBoard 
	* has more number of kings than the solution with the maximum number 
	* of kings. If yes, the current solution is the max solution
	*
	* @param       none    
	*
	* @return              void
	*
	*/
	void checkMax(){		
		if(currentKings>maxKings){
			resetBoard(maxBoard);
			maxKings=currentKings;
			for(int i=0; i<board.length;i++){
				for(int j=0;j<board[0].length;j++){
					maxBoard[i][j]=currentBoard[i][j];
				}
			}
		}
	}

	/**
	* This method prints all the contents of the board that is passed to it
	*
	* @param       thisboard    2D array which contains the board configuration to be printed
	*
	* @return              		void
	*
	*/
	void printBoard(char thisboard[][]){		
		for(int i=0; i<thisboard.length; i++){
			for(int j=0; j<thisboard[0].length; j++){
				System.out.print(thisboard[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	* This method places kings into the current board for cases when
	* the number of cells in the board is less than 4
	*
	* @param       none    
	* 
	* @return              		void
	*
	*/
	void lessThanFourMakeBoard(){
		if(board[row][column]!='.'){
			currentBoard[row][column]='K';
			currentKings+=1;
		}
	}

	/**
	* This method checks if all contents of the board are blocked or not
	*
	* @param       none    
	*
	* @return              		(boolean) true if all contents are blocked else false
	*
	*/
	boolean allCellsBlocked(){
		boolean _allCellsBlocked = true;

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]!='.'){
					_allCellsBlocked=false;
					break;
				}
			}
		}

		return _allCellsBlocked;
	}
}