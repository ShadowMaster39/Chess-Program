import java.applet.Applet;  
import java.awt.*; 

public class BoardSquare {
	private int xPos;
	private int yPos;
	private int squareColor;
	private boolean occupied = false;
	private ChessPiece Occupant = null;
	
	public BoardSquare(Graphics g, int xSquare, int ySquare, int Color){
		xPos = xSquare;
		yPos = ySquare;
		squareColor = Color;
		draw(g);
	}
	private void draw(Graphics g){
		//Declare Variables
			Color ActColor = Color.white;
		//Color Selector
			if(squareColor == 0){
				ActColor = Color.white;
			}
			else if (squareColor == 1){
				ActColor = Color.gray;
			}
			g.setColor(ActColor);
		//Draw
			g.fillRect(xPos, yPos, 90, 90);
		
	}
	public int GetYPos(){
		return yPos;
	}

	public int GetXPos(){
		return xPos;
	}
	
	public boolean isOccupied(){
		if (Occupant == null){
			occupied = false;
		}
		else{
			occupied = true;
		}
		return occupied;
	}
	
	public void setOccupant(ChessPiece piece){
		Occupant = piece;
	}
	
	public ChessPiece getOccupant(){
		return Occupant;
	}
	
	public void clearOccupant(Graphics g){
		draw(g);
		Occupant = null;
	}
}
