

import java.awt.*;

public class ChessPiece {
	public BoardSquare location;
	public BoardSquare tempLocation;
	public Color pieceColor;
	public boolean isLegal = false;
	
	public void Draw(Graphics g){
		
	}
	
	public void Move(Graphics g, BoardSquare newLocation){
		
		}

	public void Take(){
		
	}
	
	public BoardSquare getLocation(){
		return location;
	}
	
	public boolean isLegalMove(int Currentindex, int Movedindex, BoardSquare[] Board) {
		return isLegal;
	}

	
}
