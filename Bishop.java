public class Bishop extends Board {

	int alreadyChecked[][];// keeps a track of all places visited for diagonal checks
	int alreadyCheckedCounter = 0;

	Bishop(int n) {
		maxboard = new char[n][n][n];
		currentboard = new char[n][n][n];
		alreadyChecked = new int[n*n][2];
	}

	public static void main(String args[]){

	}

	void findMaxBishops(){	
		System.out.println("~~~~~~~~ FINDING MAX BISHOPS ~~~~~~~~");	
		for(int z=0; z<board.length; z++){
			for(int i=0; i<board[0].length; i++){
				for(int j=0; j<board[0].length; j++){
					resetCurrentBoard();
					placePieces(i, j, z, 'B');
					checkMaxPieces();
				}
			}
		}

		printMaxBoard("BISHOPS");
	}

	boolean checkPositionValid(int z, int r, int c){
        boolean flagPlacePiece = true;
        boolean flag3dChecksUp = true;
		boolean flag3dChecksDown = true;

       	// checking if (r,c) is not a hole
		if(currentboard[z][r][c]!=' '){
			// System.out.println(r+","+c);

			// checking for pieces in the diagonals
			int tempr;
			int tempc;
			// checking the left diagonal(going from top-left to bottom-right)
			// going to top-left
			tempr=r-1;
			tempc=c-1;
			while(tempr!=-1 && tempc!=-1){
				if(currentboard[z][tempr][tempc]=='B'){
					flagPlacePiece = false;
					break;
				}
				tempr-=1;
				tempc-=1;
			}
			// going to bottom-right
			tempr=r+1;
			tempc=c+1;
			while(tempr!=currentboard[z].length && tempc!=currentboard[z][0].length){
				if(currentboard[z][tempr][tempc]=='B'){
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
			while(tempr!=-1 && tempc!=currentboard[z][0].length){
				if(currentboard[z][tempr][tempc]=='B'){
					flagPlacePiece = false;
					break;
				}
				tempr-=1;
				tempc+=1;
			}
			// going to bottom-left
			tempr=r+1;
			tempc=c-1;
			while(tempr!=currentboard[z].length && tempc!=-1){
				if(currentboard[z][tempr][tempc]=='B'){
					flagPlacePiece = false;
					break;
				}
				tempr+=1;
				tempc-=1;
			}

			// 3D CHECKS
			// diagonal
			// diagonally up
			resetAlreadyChecked();
			alreadyCheckedCounter=0;
			flag3dChecksUp = diagonalCheckUp(z, r, c);

			// diagonally down
			resetAlreadyChecked();
			alreadyCheckedCounter=0;
			flag3dChecksDown = diagonalCheckDown(z, r, c);

			// if(flagPlacePiece==true){
			// 	currentboard[r][c]='B';
			// 	currentPieces+=1;
			// }

		}
		else{
			flagPlacePiece=false;
		}


        return flagPlacePiece && flag3dChecksUp && flag3dChecksDown;
    }

    void resetAlreadyChecked(){
		alreadyCheckedCounter=0;
		for(int i=0; i<alreadyChecked.length; i++){
			for(int j=0; j<alreadyChecked[0].length; j++){
				alreadyChecked[i][0]=-1;
				alreadyChecked[i][1]=-1;
			}
			// System.out.println(Arrays.toString(alreadyChecked[i]));

		}
		// System.out.println(Arrays.toString(alreadyChecked));
	}

	boolean isAlreadyChecked(int r, int c){

		if(r==-1 || r==currentboard[0].length || c==-1 || c==currentboard[0][0].length){
			return true;
		}

		boolean _isAlreadyChecked = false;
		for(int i=0;i<alreadyChecked.length; i++){
			// System.out.println(alreadyChecked[i][0]+","+alreadyChecked[i][1]);
			if(alreadyChecked[i][0]==r && alreadyChecked[i][1]==c){
				
				_isAlreadyChecked = true;
				break;
			}
		}

		if(_isAlreadyChecked==false){
			// System.out.println("Here for r="+r+",c="+c);
			alreadyChecked[alreadyCheckedCounter][0]=r;
			alreadyChecked[alreadyCheckedCounter][1]=c;
			alreadyCheckedCounter+=1;
		}

		return _isAlreadyChecked;
	}

	boolean diagonalCheckUp(int z, int r, int c){
		// System.out.println("("+z+","+r+","+c+")");
		if(z==-1){
			return true;
		}
		else if(r==-1 || r==currentboard[0].length || c==-1 || c==currentboard[0][0].length){
			return true;
		}
		else if(currentboard[z][r][c]=='B'){
			return false;
		}
		else if(isAlreadyChecked(r,c)==true){
			// System.out.println("("+z+","+r+","+c+") is already checked");
			// System.out.println("is already checked");
			return true;
		}
		// else if(isAlreadyChecked(r,c)==false){
			// System.out.println("("+z+","+r+","+c+")");
			// return true;
		// }

		boolean isValid = true;

		int rPositionsToCheck[] = {-1,0,1};
		int cPositionsToCheck[] = {-1,0,1};

		here: for(int i=0; i<rPositionsToCheck.length; i++){
			int newr = r+rPositionsToCheck[i];
			for(int j=0; j<cPositionsToCheck.length; j++){				
				int newc = c+cPositionsToCheck[j];					
				isValid = diagonalCheckUp(z-1, newr, newc);
				if(isValid==false)
					break here;				
			}
		}

		return isValid;

	}

	boolean diagonalCheckDown(int z, int r, int c){
		// System.out.println("("+z+","+r+","+c+")");
		if(z==currentboard.length){
			return true;
		}
		else if(r==-1 || r==currentboard[0].length || c==-1 || c==currentboard[0][0].length){
			return true;
		}
		else if(currentboard[z][r][c]=='B'){
			return false;
		}
		else if(isAlreadyChecked(r,c)==true){
			// System.out.println("("+z+","+r+","+c+") is already checked");
			// System.out.println("is already checked");
			return true;
		}
		// else if(isAlreadyChecked(r,c)==false){
		// 	System.out.println("false: ("+z+","+r+","+c+")");
		// 	// return true;
		// }

		boolean isValid = true;

		int rPositionsToCheck[] = {-1,0,1};
		int cPositionsToCheck[] = {-1,0,1};

		here: for(int i=0; i<rPositionsToCheck.length; i++){
			int newr = r+rPositionsToCheck[i];
			for(int j=0; j<cPositionsToCheck.length; j++){				
				int newc = c+cPositionsToCheck[j];
				isValid = diagonalCheckDown(z+1, newr, newc);
				if(isValid==false)
					break here;
			}
		}

		return isValid;

	}
	

}