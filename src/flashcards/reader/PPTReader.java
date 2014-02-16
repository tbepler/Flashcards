package flashcards.reader;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hslf.model.Notes;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;

import flashcards.data.Deck;
import flashcards.data.Flashcard;

public class PPTReader {
	
	public static Deck readPPT(File pptFile) throws FileNotFoundException, IOException{
		SlideShow ppt = new SlideShow(new FileInputStream(pptFile));
		int slideWidth = ppt.getPageSize().width;
		int slideHeight = ppt.getPageSize().height;
		List<Flashcard> cards = new ArrayList<Flashcard>();
		for(Slide slide : ppt.getSlides()){
			cards.add(toFlashcard(slide, slideWidth, slideHeight));
		}
		return new Deck(cards);
	}
	
	private static Flashcard toFlashcard(Slide slide, int width, int height){
		BufferedImage frontImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = frontImage.createGraphics();
		slide.draw(g2d);
		BufferedImage backImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2d = backImage.createGraphics();
		Notes notes = slide.getNotesSheet();
		notes.draw(g2d);
		return new Flashcard(frontImage, backImage);
	}
	
}
