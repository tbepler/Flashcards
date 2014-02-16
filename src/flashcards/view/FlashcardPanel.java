package flashcards.view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import flashcards.data.Deck;

public class FlashcardPanel extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;
	
	private Deck m_Deck;
	
	public FlashcardPanel(Deck deck){
		super(new BorderLayout());
		m_Deck = deck;
		if(m_Deck != null){
			m_Deck.addObserver(this);
		}
	}
	
	public FlashcardPanel(){
		this(null);
	}
	
	public void setDeck(Deck deck){
		if(m_Deck != null){
			m_Deck.deleteObserver(this);
		}
		m_Deck = deck;
		if(m_Deck != null){
			m_Deck.addObserver(this);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
