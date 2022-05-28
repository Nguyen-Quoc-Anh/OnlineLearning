/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Question {
    private int questionID;
    private String content;
    private String explanation;
    private Quiz quiz;
    private boolean status;
    private ArrayList<Answer> answerList;
    private double pointPerQuestion;
    
    public Question() {
    }

    public Question(int questionID) {
        this.questionID = questionID;
    }

    public Question(int questionID, String content, String explaination, Quiz quiz, boolean status, ArrayList<Answer> answerList) {
        this.questionID = questionID;
        this.content = content;
        this.explanation = explaination;
        this.quiz = quiz;
        this.status = status;
        this.answerList = answerList;
    }

    public Question(int questionID, String content, String explaination, Quiz quiz, boolean status) {
        this.questionID = questionID;
        this.content = content;
        this.explanation = explaination;
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

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }

    public double getPointPerQuestion() {
        return pointPerQuestion;
    }

    public void setPointPerQuestion(double pointPerQuestion) {
        this.pointPerQuestion = pointPerQuestion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.questionID;
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
        final Question other = (Question) obj;
        if (this.questionID != other.questionID) {
            return false;
        }
        return true;
    }
    
}
