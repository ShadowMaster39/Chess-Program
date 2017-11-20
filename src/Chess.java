


import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.lang.*; 
import java.awt.event.*;

public class Chess extends Applet implements ActionListener, MouseListener{
    int xPos;
    int yPos;
    private Button ResetButton;
    private Board Game;
    private Graphics gApplet;
    int [] Coords = new int[2];
    boolean StartSquareSelected = false;
    boolean TargetSquareSelected = false;
    private BoardSquare StartSquare;
    private BoardSquare TargetSquare;
    private BoardSquare tempSquare;
    private PaintActions Action = PaintActions.NoAction;
    private Color PlayerTurn = Color.lightGray;
    
    public void init(){
        ResetButton = new Button("Reset");
        add(ResetButton);
        ResetButton.addActionListener(this);
        
        addMouseListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == ResetButton){
                Action = PaintActions.ResetBoard;
                repaint();
        }
    }
    
    public void paint(Graphics g){
        gApplet = g;
        Game = new Board(g);
        
    }
    
    public void update(Graphics g){
        
        switch(Action){
            case ResetBoard: 
                Game.ResetBoard(g);
                StartSquareSelected = false;
                TargetSquareSelected = false;
                PlayerTurn = Color.lightGray; 
                break;
            case SelectFirstSquare: 
                if (StartSquare != null){
                        StartSquare.selectSquare(g);
                        StartSquareSelected = true;
                        tempSquare = StartSquare;
                        }
                break;
            case SelectSecondSquare: 
                if (TargetSquare != null){
                        TargetSquare.selectSquare(g);
                        TargetSquareSelected = true;
                        
                        StartSquare.moveEffect(g);
                        TargetSquare.moveEffect(g);
                        
                        StartSquareSelected = false;
                        TargetSquareSelected = false;
                        
                        try{
                            Thread.sleep(500);
                        } catch (Exception e){
                            
                        }
                        
                        ChessPiece ToBeMoved = StartSquare.getOccupant();
                        ToBeMoved.Move(g, TargetSquare);
                        
                        StartSquare.deselectSquare(g);
                        TargetSquare.deselectSquare(g);
                        PlayerTurn = (PlayerTurn == Color.lightGray)? Color.black: Color.lightGray;
                        
                            
                }
                break;
            case InvalidSelection: 
                tempSquare.InvalidEffect(g);
                 try{
                            Thread.sleep(500);
                        } catch (Exception e){
                            
                        }
                 tempSquare.deselectSquare(g);
                 tempSquare = null;
            break;
            case DeselectSquare: 
                StartSquare.deselectSquare(g);
                StartSquareSelected = false;
                break;
            case ChangeSelection: 
            	TargetSquare.selectSquare(g);
                TargetSquareSelected = true;
                
                StartSquare.deselectSquare(g);
                
                StartSquare = TargetSquare;
                TargetSquare = null;
                
                StartSquareSelected = true;
                TargetSquareSelected = false;
            	
            	
            	break;
            default: break;
                
        }
        Action = PaintActions.NoAction;
    }
    
    
    public void mouseClicked(MouseEvent me){
        Coords[0] = me.getX();
        Coords[1] = me.getY(); 
        BoardSquare ToTest= Game.getSquare(Coords);
        setActionMouseClick(ToTest);
        repaint();
    }
    
    
    private void setActionMouseClick(BoardSquare TestSubject){
        ChessPiece tempStartPiece = null;
        ChessPiece tempTargetPiece = null;
        ChessPiece moving = null;
        if(TestSubject != null){
	        try {
	        if (StartSquareSelected && StartSquare.isOccupied()){
	        		tempStartPiece = StartSquare.getOccupant();
	        }
	        if (StartSquareSelected && StartSquare.isOccupied()){
	        		tempTargetPiece = TestSubject.getOccupant();
	        }
	        if(!(StartSquareSelected) && TestSubject.isOccupied()){
	     		moving = TestSubject.getOccupant();
	     	}
	        if(moving == null || moving.pieceColor == PlayerTurn) {   	
		        if (!(StartSquareSelected) && !(TestSubject.isOccupied())){
				                Action = PaintActions.InvalidSelection;
				                tempSquare = TestSubject;
				            }
				            else if (TestSubject.isSelected){
				                Action = PaintActions.DeselectSquare;
				                StartSquare = TestSubject;
				            }
				            else if (!(TestSubject.isSelected)  && !(StartSquareSelected) && TestSubject.isOccupied()){
				               	Action = PaintActions.SelectFirstSquare;
				                StartSquare = TestSubject;
				            }
				            else if (!(TestSubject.isSelected) && StartSquareSelected && (tempStartPiece == null || (tempStartPiece.pieceColor.equals(tempTargetPiece.pieceColor)) || tempStartPiece.isLegalMove(Game.getIndex(StartSquare), Game.getIndex(TestSubject), Game.getBoard()))){
					           
				            	if (!(tempTargetPiece == null)){
				            		if (!(tempStartPiece.pieceColor.equals(tempTargetPiece.pieceColor))){
					                	Action = PaintActions.SelectSecondSquare;
					                    TargetSquare = TestSubject;
					                }
					               else{
					            	   Action = PaintActions.ChangeSelection;
                                       TargetSquare = TestSubject;
					               }
					           }
					           else{
					        	   Action = PaintActions.SelectSecondSquare;
				                   TargetSquare = TestSubject;
					           }
				            	
				            }
				            else {
				        		Action = PaintActions.InvalidSelection;
				        				tempSquare = TestSubject;
				            } 
				        }
	       	else {
	        		Action = PaintActions.InvalidSelection;
	        				tempSquare = TestSubject;
	        } 
	      }
	        catch(Exception e){
	        	System.out.println("ERROR IN SETACTIONMOUSECLICK");
	        }
      }
       
    }
	          
	    	
   
    
    public void mouseEntered (MouseEvent me) {} 
    public void mousePressed (MouseEvent me) {} 
    public void mouseReleased (MouseEvent me) {}  
    public void mouseExited (MouseEvent me) {}  
}


   