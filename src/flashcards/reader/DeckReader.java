package flashcards.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import flashcards.data.Deck;

public class DeckReader {
	
	private static final String PPT_EXT = ".ppt";
	private static final String PPTX_EXT = ".pptx";

	public static Deck readFile(File f) throws FileNotFoundException, IOException, UnsupportedFileFormatException{
		if(f.getName().endsWith(PPTX_EXT)){
			return readPPTX(f);
		}
		if(f.getName().endsWith(PPT_EXT)){
			return readPPT(f);
		}
		throw new UnsupportedFileFormatException("Cannot read file "+f+". File format not supported.");
	}
	
	public static Deck readPPTX(File pptxFile) throws FileNotFoundException, IOException{
		return PPTXReader.readPPTX(pptxFile);
	}
	
	public static Deck readPPT(File pptFile) throws FileNotFoundException, IOException{
		return PPTReader.readPPT(pptFile);
	}
	
}
