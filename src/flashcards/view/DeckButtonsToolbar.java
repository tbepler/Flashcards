package flashcards.view;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import flashcards.data.Deck;

public class DeckButtonsToolbar extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private Deck m_Deck;
	
	public DeckButtonsToolbar(){
		this(null);
	}
	
	public DeckButtonsToolbar(Deck deck){
		super(new FlowLayout());
		m_Deck = deck;
	}
	
	public void setDeck(Deck deck){
		m_Deck = deck;
	}
	
}
