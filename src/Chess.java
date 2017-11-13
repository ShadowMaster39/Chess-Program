
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
	boolean StartSquareSelcted = false;
	boolean TargetSquareSelected = false;
	private BoardSquare StartSquare;
	private BoardSquare TargetSquare;
	private PaintActions Action = PaintActions.NoAction;
	
	
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
    			break;
    		case SelectFirstSquare: 
    			if (StartSquare != null){
    					StartSquare.selectSquare(g);
				}
				break;
    		case SelectSecondSquare: break;
    		case InvalidSelection: break;
    		case DeselectSquare: 
    			StartSquare.deselectSquare(g);
    			break;
    			
    		default: break;
    			
    	}
    	
    	Action = PaintActions.NoAction;
    	
    	
    	
    	
    	//g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		//g.setColor(Color.black);
		//g.drawString("Mouse",100,100);
    }
    
    
	public void mouseClicked(MouseEvent me){
		Coords[0] = me.getX();
		Coords[1] = me.getY(); 
		BoardSquare ToTest= Game.getSquare(Coords);
		setActionMouseClick(ToTest);
		repaint();
	}
	
	
	private void setActionMouseClick(BoardSquare TestSubject){
		if (TestSubject.isSelected){
			Action = PaintActions.DeselectSquare;
			StartSquare = TestSubject;
		}
		else if (!(TestSubject.isSelected)){
			Action = PaintActions.SelectFirstSquare;
			StartSquare = TestSubject;
		}
		
		
	}
	
	public void mouseEntered (MouseEvent me) {} 
	public void mousePressed (MouseEvent me) {} 
	public void mouseReleased (MouseEvent me) {}  
	public void mouseExited (MouseEvent me) {}  
}


   