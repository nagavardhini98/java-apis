package com.spring.web.beans;

import java.io.Serializable;
import java.util.Arrays;

public class Quiz implements Serializable {
	private int userId;
	private String quizName;
	private String quizDesc;
	private String quizSubject;
	private boolean isActive;
	private QuestionForms[] questionforms;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getQuizDesc() {
		return quizDesc;
	}

	public void setQuizDesc(String quizDesc) {
		this.quizDesc = quizDesc;
	}

	public String getQuizSubject() {
		return quizSubject;
	}

	public void setQuizSubject(String quizSubject) {
		this.quizSubject = quizSubject;
	}

	public boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public QuestionForms[] getQuestionforms() {
		return questionforms;
	}

	public void setQuestionforms(QuestionForms[] questionforms) {
		this.questionforms = questionforms;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Quiz1 [userId=" + userId + ", quizName=" + quizName + ", quizDesc=" + quizDesc + ", questionforms="
				+ Arrays.toString(questionforms) + "]";
	}

}
