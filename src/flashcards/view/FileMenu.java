package flashcards.view;

import javax.swing.JMenu;

import flashcards.Constants;

public class FileMenu extends JMenu{
	private static final long serialVersionUID = 1L;
	
	public FileMenu(GUIFrame frame){
		super(Constants.FILE_MENU_TITLE);
		this.add(new ImportMenuItem(frame));
	}
	
	
	
}
