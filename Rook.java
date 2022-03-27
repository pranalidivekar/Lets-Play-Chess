public class Rook extends Board {

	Rook(int n) {
		maxboard = new char[n][n][n];
		currentboard = new char[n][n][n];
	}

	public static void main(String args[]){

	}

	void findMaxRooks(){	
		System.out.println("~~~~~~~~ FINDING MAX ROOKS ~~~~~~~~");	
		for(int z=0; z<board.length; z++){
			for(int i=0; i<board[0].length; i++){
				for(int j=0; j<board[0].length; j++){
					resetCurrentBoard();
					placePieces(i, j, z, 'R');
					checkMaxPieces();
				}
			}
		}

		printMaxBoard("ROOKS");
	}

	

	boolean checkPositionValid(int z, int r, int c){
        boolean flagPlacePiece = true;

        if(currentboard[z][r][c]!=' '){
			// System.out.println(r+","+c);

			// checking for pieces in the row r
			for(int j=0; j<currentboard[z][0].length; j++){
				if(currentboard[z][r][j]=='R'){
					flagPlacePiece = false;
					break;
				}
			}

			// checking for pieces in the column c
			for(int i=0; i<currentboard[z][0].length; i++){
				if(currentboard[z][i][c]=='R'){
					flagPlacePiece = false;
					break;
				}
			}

			// 3D CHECKS
			// vertical
			for(int zz=0; zz<currentboard.length; zz++){
				if(currentboard[zz][r][c]=='R'){
					flagPlacePiece=false;
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