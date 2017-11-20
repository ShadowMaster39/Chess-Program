
import java.awt.*;

public class Bishop extends ChessPiece{
	private int xPos;
	private int yPos;
	private Color BishopSecondary;
	
	public Bishop(Graphics g, BoardSquare square, int color){
		tempLocation = square;
		location = square;
		pieceColor = Color.white; 
				if(color == 0){
			pieceColor = Color.lightGray;
			BishopSecondary = new Color(140,140,140);
		}
		else if (color == 1){
			pieceColor = Color.black;
			BishopSecondary = new Color(189,189,189);
		}
		xPos = square.GetXPos();
		yPos = square.GetYPos();
		Draw(g);
		location.setOccupant(this);
	}
	
	
	public void Draw(Graphics g){
		//Variable Declare
			int[] xDB = {xPos+45, xPos+25, xPos+35, xPos+55, xPos+65};
			int[] yDB = {yPos+18, yPos+35, yPos+75, yPos+75, yPos+35};
		//Color Selector
			g.setColor(pieceColor);		
		//Drawing
			//Top Orb
				g.fillOval(xPos+38,yPos+10,15,15);
			//Diamond Body
				g.fillPolygon(xDB, yDB, 5);
			//Base
				g.fillRect(xPos+20, yPos+77, 50, 8);
			//Cross
				g.setColor(BishopSecondary);
				g.fillRect(xDB[0]-1,yDB[0]+18,3 ,21);
				g.fillRect(xDB[0]-7,yDB[1]+7, 15, 3);
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
			
			
	    isLegal = (Math.abs(CurrentRow - MovedRow) == Math.abs(CurrentCol - MovedCol))? true : false;
		
		
		
		return isLegal;
	}
}

	
	

