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
public class Quiz {
    private int quizID;
    private String quizName;
    private int passRate;
    private int position;
    private Chapter chapter;
    private boolean status;

    public Quiz() {
    }

    public Quiz(int quizID) {
        this.quizID = quizID;
    }
    
    public Quiz(int quizID, String quizName, int passRate, int position, Chapter chapter, boolean status) {
        this.quizID = quizID;
        this.quizName = quizName;
        this.passRate = passRate;
        this.position = position;
        this.chapter = chapter;
        this.status = status;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getPassRate() {
        return passRate;
    }

    public void setPassRate(int passRate) {
        this.passRate = passRate;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
