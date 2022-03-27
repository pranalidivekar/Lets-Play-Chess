public class Knight extends Board {

	Knight(int n) {
		maxboard = new char[n][n][n];
		currentboard = new char[n][n][n];
	}

	public static void main(String args[]){

	}

	void findMaxKnights(){	
		System.out.println("~~~~~~~~ FINDING MAX KNIGHTS ~~~~~~~~");	
		// resetCurrentBoard();
        // placePieces(0,0);
        for(int z=0; z<board.length; z++){
			for(int i=0; i<board[0].length; i++){
				for(int j=0; j<board[0].length; j++){
					resetCurrentBoard();
					placePieces(i, j, z, 'K');
					checkMaxPieces();
				}
			}
		}

		printMaxBoard("KNIGHTS");
	}


    boolean checkPositionValid(int z, int r, int c){
        boolean flagPlacePiece = true;

        // checking if (r,c) is not a hole
        if(currentboard[z][r][c]!=' '){
        	while(true){
				
				// checking coordinates of left-left-up
				if(r-1>=0 && c-2>=0 && currentboard[z][r-1][c-2]=='K'){
					flagPlacePiece = false;
					break;						
				}

				// checking coordinates of left-up-up
				if(r-2>=0 && c-1>=0 && currentboard[z][r-2][c-1]=='K'){							
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of left-left-down
				if(r+1<=currentboard[z].length-1 && c-2>=0 && currentboard[z][r+1][c-2]=='K'){
					flagPlacePiece = false;
					break;						
				}

				// checking coordinates of left-down-down
				if(r+2<=currentboard[z].length-1 && c-1>=0 && currentboard[z][r+2][c-1]=='K'){						
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of right-right-up
				if(r-1>=0 && c+2<=currentboard[z][0].length-1 && currentboard[z][r-1][c+2]=='K'){				
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of right-up-up
				if(r-2>=0 && c+1<=currentboard[z][0].length-1 && currentboard[z][r-2][c+1]=='K'){						
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of right-right-down
				if(r+1<=currentboard[z].length-1 && c+2<=currentboard[z][0].length-1 && currentboard[z][r+1][c+2]=='K'){
					flagPlacePiece = false;
					break;						
				}

				// checking coordinates of right-down-down
				if(r+2<=currentboard[z].length-1 && c+1<=currentboard[z][0].length-1 && currentboard[z][r+2][c+1]=='K'){						
					flagPlacePiece = false;
					break;
				}

				// checking 3D coordinates
				// checking coordinates of left-left-up
				if(z-1>=0 && c-2>=0 && currentboard[z-1][r][c-2]=='K'){
					flagPlacePiece = false;
					break;						
				}

				// checking coordinates of left-up-up
				if(z-2>=0 && c-1>=0 && currentboard[z-2][r][c-1]=='K'){							
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of left-left-down
				if(z+1<=currentboard.length-1 && c-2>=0 && currentboard[z+1][r][c-2]=='K'){
					flagPlacePiece = false;
					break;						
				}

				// checking coordinates of left-down-down
				if(z+2<=currentboard.length-1 && c-1>=0 && currentboard[z+2][r][c-1]=='K'){						
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of right-right-up
				if(z-1>=0 && c+2<=currentboard[z][0].length-1 && currentboard[z-1][r][c+2]=='K'){				
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of right-up-up
				if(z-2>=0 && c+1<=currentboard[z][0].length-1 && currentboard[z-2][r][c+1]=='K'){						
					flagPlacePiece = false;
					break;
				}

				// checking coordinates of right-right-down
				if(z+1<=currentboard.length-1 && c+2<=currentboard[z][0].length-1 && currentboard[z+1][r][c+2]=='K'){
					flagPlacePiece = false;
					break;						
				}

				// checking coordinates of right-down-down
				if(z+2<=currentboard.length-1 && c+1<=currentboard[z][0].length-1 && currentboard[z+2][r][c+1]=='K'){						
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