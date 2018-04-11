package databasetest;

import java.io.Serializable;

/**
 * ��Ƭ���������
 * @author Administrator
 *
 */
public class QuizCardBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String question;//����
	private String answer;//��
	

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
