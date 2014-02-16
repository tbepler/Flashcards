package flashcards.reader;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFNotes;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import flashcards.data.Deck;
import flashcards.data.Flashcard;

public class PPTXReader {
	
	public static Deck readPPTX(File pptxFile) throws FileNotFoundException, IOException{
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptxFile));
		int slideWidth = ppt.getPageSize().width;
		int slideHeight = ppt.getPageSize().height;
		List<Flashcard> cards = new ArrayList<Flashcard>();
		for(XSLFSlide slide : ppt.getSlides()){
			cards.add(toFlashcard(slide, slideWidth, slideHeight));
		}
		return new Deck(cards);
	}
	
	private static Flashcard toFlashcard(XSLFSlide slide, int width, int height){
		BufferedImage frontImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = frontImage.createGraphics();
		slide.draw(g2d);
		BufferedImage backImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2d = backImage.createGraphics();
		XSLFNotes notes = slide.getNotes();
		notes.draw(g2d);
		return new Flashcard(frontImage, backImage);
	}
	
}
