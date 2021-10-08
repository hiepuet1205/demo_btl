package dictionary;

import java.util.Scanner;

public class dictionaryCommandline extends dictionaryManagement {
	
	public void showAllWords() {
		System.out.println("No	| English		| Vietnamese");
		int i = 1;
		for(word s : words) {
			System.out.println(i + "	| " + s.getWordTarget() + "		| " + s.getWordExplain());
			i++;
		}
	}
	
	public void dictionarySearcher() {
		Scanner sc = new Scanner(System.in);
		
		String word_search = sc.nextLine();
		
		for(word s : words) {
			if(s.getWordTarget().indexOf(word_search) == 0 ) {
				System.out.println(s.getWordTarget() + ": " + s.getWordExplain());
			}
		}
	}
	
	public void dictionaryBasic() {
		insertFromFile();
		showAllWords();
	}
	
	public void dictionaryAdvanced() {
		insertFromFile();
		showAllWords();
		dictionaryLookup();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dictionaryCommandline dictionary = new dictionaryCommandline();
		
		dictionary.dictionaryAdvanced();

	}

}
