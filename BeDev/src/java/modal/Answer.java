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
    
}
