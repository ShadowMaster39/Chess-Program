import java.awt.Color;
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
}
		
		

	
	

