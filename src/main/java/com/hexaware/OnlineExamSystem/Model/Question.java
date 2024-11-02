package com.hexaware.OnlineExamSystem.Model;

import javax.persistence.*;

@Entity
public class Question {
	@Id
	@Column
	@GeneratedValue
	private int qId;
	@Column
	private String qText;
	@Column
	private String optionA;
	@Column
	private String optionB;
	@Column
	private String optionC;
	@Column
	private String optionD;
	@Column
	private String correctAnswer;
	
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getqText() {
		return qText;
	}
	public void setqText(String qText) {
		this.qText = qText;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	@Override
	public String toString() {
		return "Question [qId=" + qId + ", qText=" + qText + ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", optionD=" + optionD + ", correctAnswer=" + correctAnswer + "]";
	}
	
	
}
