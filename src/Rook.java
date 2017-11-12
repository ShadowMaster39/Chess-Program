import java.awt.Color;
import java.awt.*;

public class Rook extends ChessPiece{
	private int xPos;
	private int yPos;
	
	
	public Rook(Graphics g, BoardSquare square, int color){
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
		int temp = xPos + 10;
	//Color Selector	
		g.setColor(pieceColor);
	//Drawing
		//Base
			g.fillRect(xPos+15, yPos+70, 60, 15);
		//Middle
			g.fillRect(xPos+30, yPos+30, 30, 38);
		//Top
			g.fillRect(xPos+20, yPos+25, 50, 15);
		//Prongs
			for (int s = 0; s < 3; s++){
				g.fillRect(temp+10, yPos+15, 10, 10);
				temp = temp + 20;
			}
	}
}
	
	

