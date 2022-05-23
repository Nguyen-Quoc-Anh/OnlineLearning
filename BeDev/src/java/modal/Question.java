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
public class Question {
    private int questionID;
    private String content;
    private String explaination;
    private Quiz quiz;
    private String status;

    public Question() {
    }

    public Question(int questionID) {
        this.questionID = questionID;
    }
    
    public Question(int questionID, String content, String explaination, Quiz quiz, String status) {
        this.questionID = questionID;
        this.content = content;
        this.explaination = explaination;
        this.quiz = quiz;
        this.status = status;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
