package flashcards.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import flashcards.Constants;
import flashcards.data.Deck;

public class DeckButtonsToolbar extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private Deck m_Deck;
	private JButton m_Next;
	private JButton m_Prev;
	
	public DeckButtonsToolbar(){
		this(null);
	}
	
	public DeckButtonsToolbar(Deck deck){
		super(new FlowLayout());
		m_Deck = deck;
		m_Next = new JButton(Constants.NEXT_BUTTON_TEXT);
		m_Next.addActionListener(this);
		this.add(m_Next);
		m_Prev = new JButton(Constants.PREV_BUTTON_TEXT);
		m_Prev.addActionListener(this);
		this.add(m_Prev);
		m_Next.setEnabled(m_Deck != null);
		m_Prev.setEnabled(m_Deck != null);
	}
	
	public void setDeck(Deck deck){
		m_Deck = deck;
		m_Next.setEnabled(m_Deck != null);
		m_Prev.setEnabled(m_Deck != null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == m_Next && m_Deck != null){
			m_Deck.nextCard();
		}
		if(e.getSource() == m_Prev && m_Deck != null){
			m_Deck.previousCard();
		}
	}
	
}
