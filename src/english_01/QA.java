package english_01;

public class QA {
	private int id;
	private String sentence;
	private String answer;
	private String translation;

	//コンストラクタ
	public QA(int id, String sentence, String answer, String translation) {
		this.id = id;
		this.sentence = sentence;
		this.answer = answer;
		this.translation = translation;
	}

	@Override
	public String toString() {
		return "id=" + this.getId() + ", sentence=" + this.getSentence() + ", answer="+this.getAnswer()+", translation="+this.getTranslation();
	}





	//ゲッター、セッター
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}





}







