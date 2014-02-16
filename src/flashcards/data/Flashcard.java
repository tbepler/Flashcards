package flashcards.data;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;

public class Flashcard extends Observable{
	
	private final Image m_Front;
	private final Image m_Back;
	private Image m_Display;
	
	public Flashcard(Image front, Image back){
		m_Front = front;
		m_Back = back;
		m_Display = m_Front;
	}
	
	public void showFront(){
		if(m_Display != m_Front){
			this.setChanged();
		}
		m_Display = m_Front;
		this.notifyObservers();
	}
	
	public void showBack(){
		if(m_Display != m_Back){
			this.setChanged();
		}
		m_Display = m_Back;
		this.notifyObservers();
	}
	
	public void flipOver(){
		if(m_Display == m_Front){
			m_Display = m_Back;
		}else{
			m_Display = m_Front;
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void draw(Graphics g){
		g.drawImage(m_Display, 0, 0, null);
	}
	
}
