package flashcards.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import flashcards.data.Deck;

public class FlashcardPanel extends JPanel implements Observer, MouseListener, ComponentListener{
	private static final long serialVersionUID = 1L;
	
	private Deck m_Deck;
	
	public FlashcardPanel(Deck deck){
		super(new BorderLayout());
		m_Deck = deck;
		if(m_Deck != null){
			m_Deck.addObserver(this);
		}
		this.addMouseListener(this);
		this.addComponentListener(this);
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
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g){
		if(m_Deck != null){
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			m_Deck.getCurrentCard().draw((Graphics2D) g, this.getWidth(), this.getHeight());
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 == m_Deck){
			this.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1 && m_Deck != null){
			m_Deck.flipCard();
		}
	}
	

	@Override
	public void componentResized(ComponentEvent arg0) {
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		//do nothing
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//do nothing
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//do nothing
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//do nothing
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
}
