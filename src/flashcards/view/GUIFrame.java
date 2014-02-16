package flashcards.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import flashcards.Constants;

public class GUIFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public GUIFrame(){
		super(Constants.FRAME_TITLE);
		this.setJMenuBar(new JMenuBar());
	}
	
	
	
}
