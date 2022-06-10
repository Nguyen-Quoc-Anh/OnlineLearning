/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

/**
 *
 * @author admin
 */
public class Answer {
     private int recordID;
     private Question question;
     private Option option;
     private int trueOption;
     private int answerOption;
     private String contentOfAnswer;

    public Answer() {
    }
    
    public Answer(Option option) {
        this.option = option;
    }

    public Answer(int trueOption, int answerOption, String contentOfAnswer) {
        this.trueOption = trueOption;
        this.answerOption = answerOption;
        this.contentOfAnswer = contentOfAnswer;
    }
    
    
    
    public Answer(int recordID, Question question, Option option) {
        this.recordID = recordID;
        this.question = question;
        this.option = option;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public int getTrueOption() {
        return trueOption;
    }

    public void setTrueOption(int trueOption) {
        this.trueOption = trueOption;
    }

    public int getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(int answerOption) {
        this.answerOption = answerOption;
    }

    public String getContentOfAnswer() {
        return contentOfAnswer;
    }

    public void setContentOfAnswer(String contentOfAnswer) {
        this.contentOfAnswer = contentOfAnswer;
    }
     
    
     
}
