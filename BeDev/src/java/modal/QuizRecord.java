/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.time.LocalDateTime;

/**
 *
 * @author admin
 */
public class QuizRecord {

    int recordID;
    int quizID;
    LocalDateTime timeAttended;
    float grade;
    int studentID;
    float passRate;
    String quizName;
    
    public QuizRecord() {
    }

    public QuizRecord(int recordID, int quizID, LocalDateTime timeAttended, float grade, int studentID) {
        this.recordID = recordID;
        this.quizID = quizID;
        this.timeAttended = timeAttended;
        this.grade = grade;
        this.studentID = studentID;
    }

    public QuizRecord(float grade, float passRate, String quizName) {
        this.grade = grade;
        this.passRate = passRate;
        this.quizName = quizName;
    }
    
    

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public LocalDateTime getTimeAttended() {
        return timeAttended;
    }

    public void setTimeAttended(LocalDateTime timeAttended) {
        this.timeAttended = timeAttended;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public float getPassRate() {
        return passRate;
    }

    public void setPassRate(float passRate) {
        this.passRate = passRate;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    

    
}
