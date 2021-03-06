import java.awt.*;

public class Knight extends ChessPiece{
	private int xPos;
	private int yPos;
	
	public Knight(Graphics g, BoardSquare square, int color){
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
			int[] xEB = {xPos+24,xPos+66,xPos+65,xPos+41,xPos+16,xPos+25,xPos+37};  
			int[] yEB = {yPos+72,yPos+72,yPos+32,yPos+10,yPos+41,yPos+54,yPos+47}; 
		//Color Selector
			g.setColor(pieceColor);	
        //Drawing   
			//Top
				g.fillPolygon(xEB, yEB, 7);
			//Base
				g.fillRect(xPos+17, yPos+74, 56, 11);
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
		int CurrentMaxIndex = (((Currentindex / 8) + 1) * 8) - 1;
		int MovedMaxIndex = (((Movedindex / 8) + 1) * 8) - 1;
		int CurrentRow = ((Currentindex / 8) + 1);
		int CurrentCol = 8 - (CurrentMaxIndex - Currentindex) + 1;
		int MovedRow =((Movedindex / 8) + 1);;
		int MovedCol = 8 - (MovedMaxIndex - Movedindex) + 1;
			
		
		isLegal = ((Math.abs(CurrentRow - MovedRow) == 2 && Math.abs(CurrentCol - MovedCol) == 1) ^ (Math.abs(CurrentRow - MovedRow) == 1 && Math.abs(CurrentCol - MovedCol) == 2))? true : false;
		
		
		
		return isLegal;
	}
	
}
		
		

	
	

