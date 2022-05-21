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
    private int expertID;
    private double money;
    private Date releasedDate;
    private boolean status;

    public Course() {
    }

    public Course(int courseID, String courseName, String courseImage, double money) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.money = money;
    }

    public Course(int courseID, String courseName, String description, String courseImage, int expertID, double money, Date releasedDate, boolean status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.description = description;
        this.courseImage = courseImage;
        this.expertID = expertID;
        this.money = money;
        this.releasedDate = releasedDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", courseName=" + courseName + ", description=" + description + ", courseImage=" + courseImage + ", expertID=" + expertID + ", money=" + money + ", releasedDate=" + releasedDate + ", status=" + status + '}';
    }
}
