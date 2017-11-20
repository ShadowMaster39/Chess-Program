
import java.awt.*;

public class King extends ChessPiece{
	private int xPos;
	private int yPos;
	
	public King(Graphics g, BoardSquare square, int color){
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
		//Color Selector
			g.setColor(pieceColor);
        //Drawing   
			//Body
				g.fillRect(xPos+20, yPos+45, 50, 30);
			//Top Round
				g.fillArc(xPos+35, yPos+36, 20, 20, 0, 180);
			//Cross
				g.fillRect(xPos+42, yPos+14, 7, 25);
				g.fillRect(xPos+36, yPos+19, 19, 7);
			//Double Circles
				g.fillOval(xPos+9, yPos+28, 36, 36);
				g.fillOval(xPos+45, yPos+28, 36, 36);
			//Base
				g.fillRect(xPos+20, yPos+78, 50, 7);
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
		
		isLegal = (this.movedLikeBishop(Currentindex, Movedindex) ^ this.movedLikeRook(Currentindex, Movedindex))? true : false;
		
		
		return isLegal;
	}
	
	private boolean movedLikeBishop(int Currentindex, int Movedindex){
		int CurrentMaxIndex = (((Currentindex / 8) + 1) * 8) - 1;
		int MovedMaxIndex = (((Movedindex / 8) + 1) * 8) - 1;
		int CurrentRow = ((Currentindex / 8) + 1);
		int CurrentCol = 8 - (CurrentMaxIndex - Currentindex) + 1;
		int MovedRow =((Movedindex / 8) + 1);;
		int MovedCol = 8 - (MovedMaxIndex - Movedindex) + 1;
		boolean movedBishop = false;
			
			if ((Math.abs(CurrentRow - MovedRow) == Math.abs(CurrentCol - MovedCol)) && Math.abs(CurrentRow - MovedRow) == 1){
				movedBishop = true;
			}
		
		
		return movedBishop;
	}
	
	private boolean movedLikeRook(int Currentindex, int Movedindex){
		int CurrentMaxIndex = (((Currentindex / 8) + 1) * 8) - 1;
		int CurrentMinIndex = CurrentMaxIndex - 7;
		boolean vertical = false;
		boolean horizontal = false;
		boolean movedRook = false;
		
				vertical = (Math.abs((Movedindex - Currentindex)) == 8)? true : false;
				horizontal = (Math.abs((Movedindex - Currentindex)) == 1)? true : false; 
				
			movedRook = ((vertical) ^ (horizontal))? true : false;
			return movedRook;
	}
}
		
		

	
	

