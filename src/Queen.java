import java.awt.*;

public class Queen extends ChessPiece{
	private int xPos;
	private int yPos;
	
	public Queen(Graphics g, BoardSquare square, int color){
		location = square;
		pieceColor = Color.white; 
		if(color == 0){
			pieceColor = Color.lightGray;
		}
		else if (color == 1){
			pieceColor = Color.black;
		}
		xPos = square.GetXPos();
		yPos = square.GetYPos();
		Draw(g);
		location.setOccupant(this);
	}
	
	
	public void Draw(Graphics g){
		//Set Variables
			int[] xSB = {xPos+22,xPos+13,xPos+31,xPos+35,xPos+46,xPos+57,xPos+61,xPos+77,xPos+69};  
			int[] ySB = {yPos+71,yPos+25,yPos+50,yPos+17,yPos+50,yPos+17,yPos+50,yPos+25,yPos+71};
		//Color Selector
			g.setColor(pieceColor);
        //Drawing   
			//Pointy Body
				g.fillPolygon(xSB, ySB, 9);
			//Jewels
				g.fillOval(xPos+11, yPos+24, 9, 9);
				g.fillOval(xPos+71, yPos+24, 9, 9);
				g.fillOval(xPos+31, yPos+16, 9, 9);
				g.fillOval(xPos+52, yPos+16, 9, 9);
			//Base
				g.fillRect(xPos+22, yPos+74, 48, 10);

		}
	
	public void Move(Graphics g, BoardSquare newLocation){
		location.clearOccupant(g);
		location = newLocation;
		xPos = newLocation.GetXPos();
		yPos = newLocation.GetYPos();
		newLocation.setOccupant(this);
		Draw(g);
	}
	
	public boolean isLegalMove(int Currentindex, int Movedindex, BoardSquare[] Board){
		if(this.movedLikeBishop(Currentindex, Movedindex) ^ this.movedLikeRook(Currentindex, Movedindex)){
			isLegal = true;
		}
		return isLegal;
	}
	
	private boolean movedLikeRook(int Currentindex, int Movedindex){
		int CurrentMaxIndex = (((Currentindex / 8) + 1) * 8) - 1;
		int CurrentMinIndex = CurrentMaxIndex - 7;
		boolean vertical = false;
		boolean horizontal = false;
		boolean movedRook = false;
		
				vertical = (((Movedindex - Currentindex) % 8) == 0)? true : false;
				horizontal = (Movedindex >= CurrentMinIndex && Movedindex <= CurrentMaxIndex)? true : false; 
				
			movedRook = ((vertical) ^ (horizontal))? true : false;
			return movedRook;
	}
	
	private boolean movedLikeBishop(int Currentindex, int Movedindex){
		int CurrentMaxIndex = (((Currentindex / 8) + 1) * 8) - 1;
		int MovedMaxIndex = (((Movedindex / 8) + 1) * 8) - 1;
		int CurrentRow = ((Currentindex / 8) + 1);
		int CurrentCol = 8 - (CurrentMaxIndex - Currentindex) + 1;
		int MovedRow =((Movedindex / 8) + 1);;
		int MovedCol = 8 - (MovedMaxIndex - Movedindex) + 1;
		boolean movedBishop = false;
			
			
		movedBishop = (Math.abs(CurrentRow - MovedRow) == Math.abs(CurrentCol - MovedCol))? true : false;
			
		
		
		return movedBishop;
	}
}
		
		

	
	

