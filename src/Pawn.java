
import java.awt.*;

public class Pawn extends ChessPiece{
	private int xPos;
	private int yPos;
	private boolean hasMoved = false;
		
	
	
	public Pawn(Graphics g, BoardSquare square, int color){
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
	       int[] xFPB = {xPos+45,xPos+30,xPos+60};
	       int[] yFPB = {yPos+32,yPos+76,yPos+76};
		//Color Selector
	       g.setColor(pieceColor);
        //Drawing   
	       //Fill Each Head
               g.fillOval(xPos+35,yPos+22,20,20);   
           //Fill Triangle
              g.fillPolygon(xFPB,yFPB,3);
           //Base
              g.fillRect(xPos+25, yPos+77, 41, 10);
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
		
		if(!(hasMoved)) {
			if(this.pieceColor == Color.lightGray) {
				isLegal = ((Movedindex == Currentindex + 8) || (Movedindex == Currentindex + 16))? true : false;
				if(isLegal == true){
					hasMoved = true;
				}
			}
			else if (this.pieceColor == Color.black) {
				isLegal = (Movedindex == Currentindex - 8 || (Movedindex == Currentindex - 16))? true : false;
				if(isLegal == true){
					hasMoved = true;
				}
			}
		}
		else if(hasMoved) {
			if(this.pieceColor == Color.lightGray) {
				isLegal = (Movedindex == Currentindex + 8)? true : false;
			}
			else if (this.pieceColor == Color.black) {
				isLegal = (Movedindex == Currentindex - 8)? true : false;
			}
		}
		
		
		return isLegal;
	}
	
	
}
		
		

	
	

