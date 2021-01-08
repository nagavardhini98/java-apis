package com.spring.web.beans;

import java.io.Serializable;
import java.util.Arrays;

public class QuestionForms implements Serializable {
	private String question;
	private String answertype;

	private Answers[] answers;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswertype() {
		return answertype;
	}

	public void setAnswertype(String answertype) {
		this.answertype = answertype;
	}

	public Answers[] getAnswers() {
		return answers;
	}

	public void setAnswers(Answers[] answers) {
		this.answers = answers;
	}

	public QuestionForms() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QuestionForms [question=" + question + ", answertype=" + answertype + ", answers="
				+ Arrays.toString(answers) + "]";
	}

}
