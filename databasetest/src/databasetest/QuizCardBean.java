package databasetest;

import java.io.Serializable;

/**
 * 卡片的问题答案类
 * @author Administrator
 *
 */
public class QuizCardBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String question;//问题
	private String answer;//答案
	

	public QuizCardBean(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
}
