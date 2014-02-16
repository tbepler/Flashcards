package flashcards.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import flashcards.Constants;
import flashcards.data.Deck;
import flashcards.reader.DeckReader;
import flashcards.reader.UnsupportedFileFormatException;

public class ImportMenuItem extends JMenuItem implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private GUIFrame m_Frame;
	private JFileChooser m_Chooser;
	
	public ImportMenuItem(GUIFrame frame){
		super(Constants.IMPORT_MENU_TEXT);
		m_Frame = frame;
		this.addActionListener(this);
		m_Chooser = new JFileChooser("");
		m_Chooser.setAcceptAllFileFilterUsed(false);
		for(FileNameExtensionFilter filter : DeckReader.getSupportedFileExtensionFilters()){
			m_Chooser.addChoosableFileFilter(filter);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int result = m_Chooser.showDialog(m_Frame, Constants.IMPORT_MENU_TEXT);
		if(result == JFileChooser.APPROVE_OPTION){
			File f = m_Chooser.getSelectedFile();
			try {
				Deck d = DeckReader.readFile(f);
				m_Frame.setDeck(d);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedFileFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
