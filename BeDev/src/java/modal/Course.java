/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Course {
    private int courseID;
    private String courseName;
    private String description;
    private String courseImage;
    private Expert expert;
    private double money;
    private Date releasedDate;
    private boolean status;
    private int numberRegister;
    private int numberLesson;
    public Course() {
    }

    public Course(int courseID, String courseName, String description, String courseImage, Expert expert, double money, Date releasedDate, boolean status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.description = description;
        this.courseImage = courseImage;
        this.expert = expert;
        this.money = money;
        this.releasedDate = releasedDate;
        this.status = status;
    }

    public Course(int courseID, String courseName, String description, String courseImage, Expert expert, double money, Date releasedDate, boolean status, int numberRegister) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.description = description;
        this.courseImage = courseImage;
        this.expert = expert;
        this.money = money;
        this.releasedDate = releasedDate;
        this.status = status;
        this.numberRegister = numberRegister;
    }

    public Course(int courseID, String courseName, String description, String courseImage, Expert expert, double money, Date releasedDate, boolean status, int numberRegister, int numberLesson) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.description = description;
        this.courseImage = courseImage;
        this.expert = expert;
        this.money = money;
        this.releasedDate = releasedDate;
        this.status = status;
        this.numberRegister = numberRegister;
        this.numberLesson = numberLesson;
    }

    public int getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(int numberLesson) {
        this.numberLesson = numberLesson;
    }
    
    

    public int getNumberRegister() {
        return numberRegister;
    }

    public void setNumberRegister(int numberRegister) {
        this.numberRegister = numberRegister;
    }
    
    
    
    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", courseName=" + courseName + ", description=" + description + ", courseImage=" + courseImage + ", expert=" + expert + ", money=" + money + ", releasedDate=" + releasedDate + ", status=" + status + ", numberRegister=" + numberRegister + ", numberLesson=" + numberLesson + '}';
    }
        
   
}
