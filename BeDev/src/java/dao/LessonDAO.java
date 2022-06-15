/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modal.Lesson;

/**
 *
 * @author admin
 */
public class LessonDAO extends DBContext {

    public int countLessonOfCourse(int id) {
        try {
            String sql = "select count(*)  from Course c, Chapter ch, Lesson l\n"
                    + "where c.courseID = ch.courseID and ch.chapterID = l.chapterID and c.courseID = ?";
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

    public Lesson getLessonDetails(String lessonID) {
        Lesson lesson = null;
        try {
            String sql = "select lessonID, lessonName, videoUrl, content from Lesson where lessonID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lessonID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                lesson = new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lesson;
    }
    
    public void addLessonLearned(String lessonID, int studentID) {
        try {
            String sql = "insert into Lesson_Learned (studentID, lessonID) "
                    + "(select ?, ? where (select COUNT(studentID) from Lesson_Learned "
                    + "where studentID = ? and lessonID = ? group by studentID) is NULL)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, studentID);
            stm.setString(2, lessonID);
            stm.setInt(3, studentID);
            stm.setString(4, lessonID);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
