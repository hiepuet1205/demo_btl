package dictionary;

public class word {
	private String word_target;
	private String word_explain;
	
	public word(String word_target, String word_explain){
		this.word_target = word_target;
		this.word_explain = word_explain;
	}
	
	public String getWordTarget() {
		return word_target;
	}
	
	public String getWordExplain() {
		return word_explain;
	}
	
	public void setWordTarget(String word_target) {
		this.word_target = word_target;
	}
	
	public void setWordExplain(String word_explain) {
		this.word_explain = word_explain;
	}
}
