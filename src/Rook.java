import java.awt.*;

public class Rook extends ChessPiece{
	private int xPos;
	private int yPos;
	private boolean vertical = false;
	private boolean horizontal = false;
	
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
		Draw(g);
		location.setOccupant(this);
	}
	
	public void Draw(Graphics g){
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
	
	public void Move(Graphics g, BoardSquare newLocation){
		location.clearOccupant(g);
		location = newLocation;
		xPos = newLocation.GetXPos();
		yPos = newLocation.GetYPos();
		newLocation.setOccupant(this);
		Draw(g);
	}
	
	public boolean isLegalMove(int Currentindex, int Movedindex, BoardSquare[] Board){
		int CurrentMaxIndex = (((Currentindex / 8) + 1) * 8) - 1;
		int MovedMaxIndex = (((Movedindex / 8) + 1) * 8) - 1;
		int CurrentRow = ((Currentindex / 8) + 1);
		int CurrentCol = 8 - (CurrentMaxIndex - Currentindex) + 1;
		int MovedRow =((Movedindex / 8) + 1);;
		int MovedCol = 8 - (MovedMaxIndex - Movedindex) + 1;
		
				vertical = ((CurrentRow != MovedRow) && (CurrentCol == MovedCol))? true : false;
				horizontal = ((CurrentRow == MovedRow) && (CurrentCol != MovedCol))? true : false; 
				
			isLegal = ((vertical) ^ (horizontal))? true : false;
			
		return isLegal;
	}
		
	public boolean isBlocked(int Currentindex, int Movedindex, BoardSquare[] Board){
		boolean isBlocked = false;
		
		int CurrentMaxIndex = (((Currentindex / 8) + 1) * 8) - 1;
		int MovedMaxIndex = (((Movedindex / 8) + 1) * 8) - 1;
		int CurrentRow = ((Currentindex / 8) + 1);
		int CurrentCol = 8 - (CurrentMaxIndex - Currentindex) + 1;
		int MovedRow =((Movedindex / 8) + 1);;
		int MovedCol = 8 - (MovedMaxIndex - Movedindex) + 1;
		
		if(vertical){
			int verticalDifference = Math.abs(CurrentRow - MovedRow);
			int[] VIndexes = new int[verticalDifference]; 
			for(int t = 0; t <= verticalDifference; t++){
				VIndexes[t] = (Currentindex + ((t+1) * 8));
			}
		}
		else if(horizontal){
			int horizontalDifference = Math.abs(CurrentRow - MovedRow);
			int[] HIndexes = new int[horizontalDifference];
			int[] HAllValues = new int[horizontalDifference];
			
			
			for(int t = 0; t <= horizontalDifference; t++){
				HIndexes[t] = (Currentindex + ((t+1) * 8));
			}
			
			isBlocked = (Board[HIndexes[0]].isOccupied())? true : false;
		}
		
		//isBlocked = (Board[])? true : false;
		
		return isBlocked;
	}
	
}
	
	

