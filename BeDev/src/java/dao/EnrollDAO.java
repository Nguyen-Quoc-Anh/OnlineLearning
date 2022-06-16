/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.Course;
import modal.Enroll;
import modal.Expert;

/**
 *
 * @author admin
 */
public class EnrollDAO extends DBContext {

    public List<Enroll> countFeatureEnrollOfCourse() {
        List<Enroll> list = new ArrayList<>();
        try {
            String sql = "select top(6) c.courseID, count(*) as Number_Registed from Enroll e, Course c\n"
                    + "where e.courseID = c.courseID\n"
                    + "group by e.courseID, c.courseID\n"
                    + "order by  Number_Registed  desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Enroll(new Course(rs.getInt(1), "", "", "", null, 0, null, true), rs.getInt(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int countEnrollOfCourse(int id) {
        try {
            String sql = "select count(*)  from Enroll e\n"
                    + "where e.courseID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    /**
     * This method is number course enrolled by student from database
     *
     * @param id is id of student
     * @return number course enrolled by student
     */
    public int countEnrollOfStudent(int id) {
        try {
            String sql = "select count(*) from Enroll e\n"
                    + "	where e.studentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    /**
     * This method  checks if this student is already registered for this course.
     * @param studentID
     * @param courseID
     * @return true if registered , false if not.
     */
    public boolean isEnroll(String courseID, int studentID) {
        try {
            String sql = "select * from Enroll where courseID = ? and studentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, courseID);
            stm.setInt(2, studentID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static void main(String[] args) {
        EnrollDAO enrollDAO = new EnrollDAO();
    }
    
}
