package com.spring.web.beans;

import java.io.Serializable;

public class Answers implements Serializable {
	private String ansText;
	private boolean iscorrect;

	public String getAnsText() {
		return ansText;
	}

	public void setAnsText(String ansText) {
		this.ansText = ansText;
	}

	public boolean isIscorrect() {
		return iscorrect;
	}

	public void setIscorrect(boolean iscorrect) {
		this.iscorrect = iscorrect;
	}

	public Answers() {
		super();
	}

	@Override
	public String toString() {
		return "Answers [ansText=" + ansText + ", iscorrect=" + iscorrect + "]";
	}

}
