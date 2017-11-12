import java.awt.Color;
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
		draw(g);
		location.setOccupant(this);
	}
	
	
	private void draw(Graphics g){
		//Set Variables
			int[] xSB = {xPos+23,xPos+23,xPos+69,xPos+69};  
			int[] ySB = {yPos+75,yPos+55,yPos+55,yPos+75}; 
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
}
		
		

	
	

