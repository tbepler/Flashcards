package flashcards.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import flashcards.Constants;
import flashcards.data.Deck;

public class GUIFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private DeckButtonsToolbar m_ButtonsBar;
	private FlashcardPanel m_CardPanel;
	
	public GUIFrame(){
		super(Constants.FRAME_TITLE);
		this.setJMenuBar(new JMenuBar());
		this.getJMenuBar().add(new FileMenu(this));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.weightx = 0.7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		m_ButtonsBar = new DeckButtonsToolbar();
		this.add(m_ButtonsBar, gbc);
		gbc = new GridBagConstraints();
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.7;
		gbc.weighty = 0.7;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		m_CardPanel = new FlashcardPanel();
		this.add(m_CardPanel, gbc);
		this.pack();
		this.setVisible(true);
	}
	
	public void setDeck(Deck deck){
		m_ButtonsBar.setDeck(deck);
		m_CardPanel.setDeck(deck);
	}
	
}
