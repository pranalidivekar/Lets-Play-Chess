public class Chess  {

	public static void main(String args[]) {
		// ob.parseArgs(args);
		int d = 0; // dimensions (2D, 3D)
		int n = 0; // board size
		
		// parsing args
		for(int i=0; i<args.length; i++){
			if(args[i].equals("-d")){
				d = Integer.parseInt(args[i+1]);
			}
			else if(args[i].equals("-n")){
				n = Integer.parseInt(args[i+1]);
			}
		}

		// initializing the board using the queen object
		// this is done using only the queen object since board[][] is static
		Queen queen = new Queen(n);
		int x = 0;
		for(int z=0; z<n; z++){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(x%2==0)
						queen.board[z][i][j]='w';
					else
						queen.board[z][i][j]='b';
					x+=1;
				}
			}
		}
		

		// placing holes in the chess board
		for(int i=0; i<args.length; i++){
			if(args[i].equals("-h")){
				String s = args[i+1];
				int cpos = Integer.parseInt(s.substring(s.indexOf('.')+1, s.lastIndexOf('.')))-1;
				int rpos = Integer.parseInt(s.substring(0,s.indexOf('.')))-1;
				int zpos = Integer.parseInt(s.substring(s.lastIndexOf('.')+1))-1;
				queen.board[zpos][rpos][cpos] = ' ';
			}
		}
		
		// queen.printBoard();
		queen.findMaxQueens();

		Rook rook = new Rook(n);
		rook.findMaxRooks();

		Bishop bishop = new Bishop(n);
		bishop.findMaxBishops();

		Knight knight = new Knight(n);
		knight.findMaxKnights();
	}

}