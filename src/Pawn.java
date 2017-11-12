import java.awt.Color;
import java.awt.*;

public class Pawn extends ChessPiece{
	private int xPos;
	private int yPos;
	
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
		draw(g);
		location.setOccupant(this);
	}
	
	
	private void draw(Graphics g){
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
		}
		
		

	
	

