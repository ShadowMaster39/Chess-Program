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
}
		
		

	
	

