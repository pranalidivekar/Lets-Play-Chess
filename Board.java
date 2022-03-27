abstract class Board{
	static char board[][][];

	char maxboard[][][];
	char currentboard[][][];

	// int row = 0;
	// int column = 0;

	int maxPieces = 0;
	int currentPieces = 0;

	// abstract void placePieces(int r, int c);
	abstract boolean checkPositionValid(int r, int c, int z); 
	// z is the z-coordinate
	// z=0 means the top level 
	// z=1 means the second level from the top and so on

	void placePieces(int r, int c, int z, char pieceChar){
		// System.out.println("("+z+","+r+","+c+")");
		if(currentboard[z][r][c]==pieceChar){
			// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
			// printBoard();
			checkMaxPieces();
			return;
		}
		else{
			if(checkPositionValid(z,r,c)){
				currentboard[z][r][c]=pieceChar;
				currentPieces+=1;
				
				int z1=z;
				int r1=r;
				int c1=c+1;
				if(c1==currentboard[0][0].length){
					c1=0;
					r1+=1;
					if(r1==currentboard[0].length){
						r1=0;
						z1+=1;
						if(z1==currentboard.length){
							z1=0;
						}
					}
				}
				
				for(int zz=z1; zz<currentboard.length; zz++){
					for(int i=r1; i<currentboard[0].length; i++){
						for(int j=c1; j<currentboard[0][0].length; j++){
							placePieces(i,j,zz, pieceChar);
							// System.out.println("("+i+","+j+","+zz+")");
						}
					}           
				}     
				
				currentboard[z][r][c]=board[z][r][c];
				currentPieces-=1;

			}
			else{
				int z1=z;
				int r1=r;
				int c1=c+1;
				if(c1==currentboard[0][0].length){
					c1=0;
					r1+=1;
					if(r1==currentboard[0].length){
						r1=0;
						z1+=1;
						if(z1==currentboard.length){
							z1=0;
						}
					}
				}
				placePieces(r1,c1,z1, pieceChar);
			}
		}
	}

	void printBoard(){
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		for(int z=0; z<board.length; z++){
			System.out.println("Level="+z);
			for(int i=0; i<board[z].length; i++){
				for(int j=0; j<board[z][0].length; j++){
					System.out.print(currentboard[z][i][j]+" ");
				}
				System.out.println();
			}

		}		
		System.out.println("~~~~~~~~~~~~~~~~~~~");
	}

	void printMaxBoard(String pieceName){
		System.out.println("Maximum number of "+pieceName+" = "+maxPieces);
		for(int z=0; z<maxboard.length; z++){
			System.out.println("Level="+z);
			for(int i=0; i<maxboard[z].length; i++){
				for(int j=0; j<maxboard[z][0].length; j++){
					System.out.print(maxboard[z][i][j]+" ");
				}
				System.out.println();
			}

		}		
		System.out.println("~~~~~~~~~~~~~~~~~~~");
	}

	void resetCurrentBoard(){
		currentPieces=0;
		for(int z=0; z<board.length; z++){
			for(int i=0; i<board[z].length; i++){
				for(int j=0; j<board[z][0].length; j++){
					currentboard[z][i][j]=board[z][i][j];
				}
			}

		}
	}

	void copyCurrentBoardToMaxBoard(){
		for(int z=0; z<board.length; z++){
			for(int i=0; i<board[z].length; i++){
				for(int j=0; j<board[z][0].length; j++){
					maxboard[z][i][j]=currentboard[z][i][j];
				}
			}

		}
	}

	void checkMaxPieces(){
		if(currentPieces>maxPieces){
			// System.out.println("Found max maxPieces="+maxPieces+" currentPieces="+currentPieces);
			maxPieces=currentPieces;
			copyCurrentBoardToMaxBoard();
		}
	}
		
}