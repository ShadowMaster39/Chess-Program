import java.awt.Color;
import java.awt.*;

public class Bishop extends ChessPiece{
	private int xPos;
	private int yPos;
	private Color BishopSecondary;
	
	public Bishop(Graphics g, BoardSquare square, int color){
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
	
}

	
	

