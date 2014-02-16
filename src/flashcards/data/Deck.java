package flashcards.data;

import java.util.*;

public class Deck extends Observable implements Observer{
	
	private List<Flashcard> m_Cards = new ArrayList<Flashcard>();
	private int m_Index = 0;
	private Collection<Flashcard> m_Marked = new HashSet<Flashcard>();
	
	public Deck(List<Flashcard> cards){
		for(Flashcard card : cards){
			m_Cards.add(card);
		}
	}
	
	public void shuffle(){
		long seed = System.nanoTime();
		Collections.shuffle(m_Cards, new Random(seed));
		m_Index = 0;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void flipCard(){
		this.getCurrentCard().flipOver();
	}
	
	private void increment(){
		m_Index++;
		if(m_Index >= m_Cards.size()){
			m_Index = 0;
		}
	}
	
	private void decrement(){
		m_Index--;
		if(m_Index < 0){
			m_Index = m_Cards.size() - 1;
		}
	}
	
	public void mark(){
		m_Marked.add(this.getCurrentCard());
	}
	
	public void unmark(){
		m_Marked.remove(this.getCurrentCard());
	}
	
	public boolean isMarked(){
		return m_Marked.contains(this.getCurrentCard());
	}
	
	public Flashcard nextMarkedCard(){
		if(m_Marked.isEmpty()){
			return this.getCurrentCard();
		}
		this.getCurrentCard().deleteObserver(this);
		this.increment();
		while(!m_Marked.contains(this.getCurrentCard())){
			this.increment();
		}
		this.getCurrentCard().addObserver(this);
		this.setChanged();
		this.notifyObservers();
		return this.getCurrentCard();
	}
	
	public Flashcard previousMarkedCard(){
		if(m_Marked.isEmpty()){
			return this.getCurrentCard();
		}
		this.getCurrentCard().deleteObserver(this);
		this.decrement();
		while(!m_Marked.contains(this.getCurrentCard())){
			this.decrement();
		}
		this.getCurrentCard().addObserver(this);
		this.setChanged();
		this.notifyObservers();
		return this.getCurrentCard();
	}
	
	public Flashcard getCurrentCard(){
		return m_Cards.get(m_Index);
	}
	
	public Flashcard nextCard(){
		this.getCurrentCard().deleteObserver(this);
		this.increment();
		this.getCurrentCard().addObserver(this);
		this.setChanged();
		this.notifyObservers();
		return this.getCurrentCard();
	}
	
	public Flashcard previousCard(){
		this.getCurrentCard().deleteObserver(this);
		this.decrement();
		this.getCurrentCard().addObserver(this);
		this.setChanged();
		this.notifyObservers();
		return this.getCurrentCard();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 == this.getCurrentCard()){
			this.setChanged();
			this.notifyObservers();
		}
	}
	
}
