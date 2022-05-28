/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

/**
 *
 * @author ACER
 */
public class Answer {
    private int answerID;
    private Question question;
    private String content;
    private boolean isTrue;
    private double point;
    
    public Answer() {
    }

    public Answer(int answerID) {
        this.answerID = answerID;
    }
    
    public Answer(int answerID, Question question, String content, boolean isTrue) {
        this.answerID = answerID;
        this.question = question;
        this.content = content;
        this.isTrue = isTrue;
    }

    public Answer(int answerID, double point) {
        this.answerID = answerID;
        this.point = point;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.answerID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Answer other = (Answer) obj;
        if (this.answerID != other.answerID) {
            return false;
        }
        return true;
    }
}
