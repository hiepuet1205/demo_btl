package dictionary;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.FileNotFoundException;

public class dictionaryManagement extends dictionary {
	public void insertFromCommandline() {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<1; i++) {
			String word_target = sc.nextLine();
			String word_explain = sc.nextLine();
			
			word newWord = new word(word_target, word_explain);
			
			words.add(newWord);
		}
	}
	
	public void insertFromFile() {
		try {
			File file = new File("/Users/DELL/Desktop/dictionaries.txt");
			Scanner myDictionary = new Scanner(file);
			while(myDictionary.hasNextLine()) {
				String data = myDictionary.nextLine();
				
				String word_target = "";
				String word_explain = "";
				int index = 0;
				
				for(int i=0; i<data.length(); i++) {
					if(data.charAt(i) == '\t') {
						index = i;
						break;
					}
					word_target += data.charAt(i);
				}
				
				for(int i=index+1; i<data.length(); i++) {
					word_explain += data.charAt(i);
				}
				
				word newWord = new word(word_target, word_explain);
				
				words.add(newWord);
			}
		}catch(FileNotFoundException  e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	
	public void dictionaryExportToFile() {
		try {
			FileWriter myWriter = new FileWriter("/Users/DELL/Desktop/dictionaries.txt");
			for(word s : words) {
				myWriter.write(s.getWordTarget() + "	" + s.getWordExplain() + "\n");
			}
			myWriter.close();
	    } catch (IOException e) {
	    	System.out.println("Error");
	    	e.printStackTrace();
	    }
	}
	
	public void dictionaryLookup() {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		for(word s : words) {
			if(s.getWordTarget().equals(word)) {
				System.out.println(word + ": " + s.getWordExplain());
			}
		}
	}
	
	public void addWord() {
		Scanner sc = new Scanner(System.in);
		
		String word_target = sc.nextLine();
		String word_explain = sc.nextLine();
		
		word newWord = new word(word_target, word_explain);
		
		words.add(newWord);
	}
	
	public void replaceWord() {
		Scanner sc = new Scanner(System.in);
		
		String word_target = sc.nextLine();
		String word_explain = sc.nextLine();
		
		for(word s : words) {
			if(s.getWordTarget().equals(word_target)) {
				s.setWordExplain(word_explain);
			}
			if(s.getWordExplain().equals(word_explain)) {
				s.setWordTarget(word_target);
			}
		}
	}
	
	public void deleteWord() {
		Scanner sc = new Scanner(System.in);
		
		String word_target = sc.nextLine();
		
		words.removeIf(s -> (s.getWordTarget().equals(word_target)));			
	}
}
