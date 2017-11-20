
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Board {
	int xOfA1;
	int yOfA1;
	private BoardSquare[] ChessBoard;
	
	
	public Board (Graphics g, int x, int y){
		IntializeBoard(g,x,y);
	}

	public Board (Graphics g){
		IntializeBoard(g,400,100);
	}

   //Main Functions		

	public BoardSquare[] getBoard(){
		return ChessBoard;
	}
	
	public BoardSquare getSquare(int [] Click){
		BoardSquare ClickedSquare = null;
		int x = Click[0];
		int y = Click[1];
		int index = 0;
		int xSquare = x - xOfA1;
		int ySquare = y - yOfA1;
		int col;
		int row;
		
		if (xSquare >= 0 && ySquare >= 0){
			//Find x
			col = xSquare / 90;			
			//Find y
			row = ySquare / 90;
			//Find Index
			//index = (col -1) + 8*(row-1);	
			if (col < 8 && row < 8){
				index = (col) + 8*(row);
				if (index <= 63 && index >= 0){
						ClickedSquare = ChessBoard[index];
				}
			}
		}	
		return ClickedSquare;
		
	}
		
	public int getIndex(BoardSquare ClickedSquare) {
		int x = ClickedSquare.GetXPos();
		int y = ClickedSquare.GetYPos();
		int index = 0;
		int xSquare = x - xOfA1;
		int ySquare = y - yOfA1;
		int col;
		int row;
		
		if (xSquare >= 0 && ySquare >= 0){
			//Find x
			col = xSquare / 90;			
			//Find y
			row = ySquare / 90;
			//Find Index
			//index = (col -1) + 8*(row-1);	
			if (col < 8 && row < 8){
				index = (col) + 8*(row);
				if (index <= 63 && index >= 0){
						ClickedSquare = ChessBoard[index];
				}
			}
		}	
		return index;
		
	}

	public void ResetBoard(Graphics g){
		startGame(g);
	}
  //Private Functions 		
	private void startGame(Graphics g){
	   	drawBoard(g);
        LabelBoard(g);
        drawAllPawns(g);
        drawAllRooks(g);
        drawAllBishops(g);
        drawAllKnights(g);
        drawBothQueens(g);
        drawBothKings(g);
    }
	
    private void IntializeBoard(Graphics g, int x, int y){
		xOfA1 = x;
		yOfA1 = y;
		ChessBoard = new BoardSquare[64];
		startGame(g);
	}
    
    
  //Draw Board
	private void drawBoard(Graphics g){
		g.setColor(Color.black);
		g.drawRect(xOfA1-1,yOfA1-1,721,721);
	
		int index=0;
		for(int row=1;row<9;row++){
	    	for(int col=0;col<8;col++){
	    		if (row % 2 == 0)
	    		{
		    		if (index==0 || ((index % 2) ==0) )
		    			ChessBoard[index] = new BoardSquare(g,xOfA1+col*90,yOfA1+(row-1)*90,1);
		    		else
		    			ChessBoard[index] = new BoardSquare(g,xOfA1+col*90,yOfA1+(row-1)*90,0);		    			
	    		}
	    		else
	    		{
		    		if (index==0 || ((index % 2) ==0) )
		    			ChessBoard[index] = new BoardSquare(g,xOfA1+col*90,yOfA1+(row-1)*90,0);
		    		else
		    			ChessBoard[index] = new BoardSquare(g,xOfA1+col*90,yOfA1+(row-1)*90,1);
	    		}
	    		index++;
	    	}
		}	    	
	}         
	
	private void LabelBoard(Graphics g){
		//Declare Variables
		String[] Files = {"A","B","C","D","E","F","G","H"};
		String[] Ranks = {"1","2","3","4","5","6","7","8"};
		int y = yOfA1 + 40;
		int x = xOfA1 + 5;	    	
		int fontSize = 30;
		//Set Font and Color
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.setColor(Color.blue);
		//Label Files
		for (int p = 0; p < 8; p++){
			g.drawString(Files[p], xOfA1-30, y+16);
			y = y + 90;
		}
		//Label Ranks
	    for (int a = 0; a < 8; a++){
	    	g.drawString(Ranks[a], x+35, yOfA1-12);
	    	x = x + 90;	
	    }
	 }
	    
	//Draw Pieces
	private void drawAllPawns(Graphics g){
		//Establish all White Pawns
		Pawn W1 = new Pawn(g,ChessBoard[SquarePosition.valueOf("B1").ordinal()],0);
		Pawn W2 = new Pawn(g,ChessBoard[SquarePosition.valueOf("B2").ordinal()],0);
		Pawn W3 = new Pawn(g,ChessBoard[SquarePosition.valueOf("B3").ordinal()],0);
		Pawn W4 = new Pawn(g,ChessBoard[SquarePosition.valueOf("B4").ordinal()],0);
		Pawn W5 = new Pawn(g,ChessBoard[SquarePosition.valueOf("B5").ordinal()],0);
		Pawn W6 = new Pawn(g,ChessBoard[SquarePosition.valueOf("B6").ordinal()],0);
		Pawn W7 = new Pawn(g,ChessBoard[SquarePosition.valueOf("B7").ordinal()],0);
		Pawn W8 = new Pawn(g,ChessBoard[SquarePosition.valueOf("B8").ordinal()],0);
		//Establish all Black Pawns
		Pawn B1 = new Pawn(g,ChessBoard[SquarePosition.valueOf("G1").ordinal()],1);
		Pawn B2 = new Pawn(g,ChessBoard[SquarePosition.valueOf("G2").ordinal()],1);
		Pawn B3 = new Pawn(g,ChessBoard[SquarePosition.valueOf("G3").ordinal()],1);
		Pawn B4 = new Pawn(g,ChessBoard[SquarePosition.valueOf("G4").ordinal()],1);
		Pawn B5 = new Pawn(g,ChessBoard[SquarePosition.valueOf("G5").ordinal()],1);
		Pawn B6 = new Pawn(g,ChessBoard[SquarePosition.valueOf("G6").ordinal()],1);
		Pawn B7 = new Pawn(g,ChessBoard[SquarePosition.valueOf("G7").ordinal()],1);
		Pawn B8 = new Pawn(g,ChessBoard[SquarePosition.valueOf("G8").ordinal()],1);
	}
		
	private void drawAllRooks(Graphics g){
		//Establish White A1 Rook
		Rook WR1 = new Rook(g,ChessBoard[SquarePosition.valueOf("A1").ordinal()],0);
		//Establish White A8 Rook
		Rook WR2 = new Rook(g,ChessBoard[SquarePosition.valueOf("A8").ordinal()],0);
		//Establish Black H1 Rook
		Rook BR1 = new Rook(g,ChessBoard[SquarePosition.valueOf("H1").ordinal()],1);
		//Establish Black H8 Rook
		Rook BR2 = new Rook(g,ChessBoard[SquarePosition.valueOf("H8").ordinal()],1);
	}
	   
	private void drawAllBishops(Graphics g){
		Bishop WB1 = new Bishop (g,ChessBoard[SquarePosition.valueOf("A3").ordinal()],0);
		Bishop WB2 = new Bishop (g,ChessBoard[SquarePosition.valueOf("A6").ordinal()],0);
		Bishop BB1 = new Bishop (g,ChessBoard[SquarePosition.valueOf("H3").ordinal()],1);
		Bishop BB2 = new Bishop (g,ChessBoard[SquarePosition.valueOf("H6").ordinal()],1);    	
	}
	
	private void drawAllKnights(Graphics g){
		Knight WK1 = new Knight(g,ChessBoard[SquarePosition.valueOf("A2").ordinal()],0);
		Knight WK2 = new Knight(g,ChessBoard[SquarePosition.valueOf("A7").ordinal()],0);
		Knight BK1 = new Knight(g,ChessBoard[SquarePosition.valueOf("H2").ordinal()],1);
		Knight BK2 = new Knight(g,ChessBoard[SquarePosition.valueOf("H7").ordinal()],1);
	}
	
	private void drawBothQueens(Graphics g){
		Queen WQ = new Queen(g,ChessBoard[SquarePosition.valueOf("A4").ordinal()],0);
		Queen BQ = new Queen(g,ChessBoard[SquarePosition.valueOf("H4").ordinal()],1);    	
	}
	
	private void drawBothKings(Graphics g){
		King WK = new King(g,ChessBoard[SquarePosition.valueOf("A5").ordinal()], 0);
		King BK = new King(g,ChessBoard[SquarePosition.valueOf("H5").ordinal()], 1);    	
    }

}

