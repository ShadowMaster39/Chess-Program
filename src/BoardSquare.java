import java.applet.Applet;  
import java.awt.*; 

public class BoardSquare {
	private int xPos;
	private int yPos;
	private int squareColor;
	private boolean occupied = false;
	private ChessPiece Occupant = null;
	public boolean isSelected = false; 
	
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
		occupied = true;
	}
	
	public void selectSquare(Graphics g){
		g.setColor(Color.blue);
		g.drawRect(xPos, yPos, 89, 89);
		g.drawRect(xPos+1, yPos+1, 87, 87);
		g.drawRect(xPos+2, yPos+2, 85, 85);
		isSelected = true;
	}
	
	public void deselectSquare(Graphics g){
		draw(g);
		if (occupied){
			Occupant.Draw(g);
		}
		isSelected = false;
	}
	
	public ChessPiece getOccupant(){
		return Occupant;
	}
	
	public void clearOccupant(Graphics g){
		draw(g);
		Occupant = null;
		occupied=false;
	}
}
