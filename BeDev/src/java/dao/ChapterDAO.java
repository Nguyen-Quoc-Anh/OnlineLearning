/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modal.Chapter;
import modal.Lesson;
import modal.Quiz;

/**
 *
 * @author admin
 */
public class ChapterDAO extends DBContext {

    /**
     * This method get a list chapter by course ID from database
     *
     * @return a list chapter
     */
    public List<Chapter> listChapterByCourse(String courseID) {
        List<Chapter> listChapter = new ArrayList<>();
        try {
            String sql = "select c.chapterID, c.chapterName, c.position, "
                    + "l.lessonID, l.lessonName, l.position, q.quizID, "
                    + "q.quizName, q.position from Chapter c left join Lesson l "
                    + "on c.chapterID = l.chapterID and l.status = 1 left join Quiz q "
                    + "on c.chapterID = q.chapterID and q.status = 1 "
                    + "where c.courseID = ? and c.status = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, courseID);
            ResultSet rs = stm.executeQuery();
            Lesson lesson = null;
            while (rs.next()) {
                List<Lesson> listLesson = new ArrayList<>();
                if (lesson != null) {
                    listLesson.add(lesson);
                }
                Quiz quiz = new Quiz(rs.getInt(7), rs.getString(8), rs.getInt(9));
                listChapter.add(new Chapter(rs.getInt(1), rs.getString(2), rs.getInt(3), listLesson, quiz));
                listLesson.add(new Lesson(rs.getInt(4), rs.getString(5), rs.getInt(6)));
                int pos = rs.getInt(3);
                while (rs.next()) {
                    if (pos == rs.getInt(3)) {
                        listLesson.add(new Lesson(rs.getInt(4), rs.getString(5), rs.getInt(6)));
                    } else {
                        lesson = new Lesson(rs.getInt(4), rs.getString(5), rs.getInt(6));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listChapter;
    }

    public List<Chapter> listChapterByEnrollCourse(String courseID, int studentID) {
        List<Chapter> listChapter = new ArrayList<>();
        try {
            String sql = "select c.chapterID, c.chapterName, c.position, l.lessonID, l.lessonName, l.position, q.quizID, \n"
                    + "q.quizName, q.position, ll.lessonID from Chapter c left join Lesson l on c.chapterID = l.chapterID and l.status = 1\n"
                    + "left join Quiz q on c.chapterID = q.chapterID and q.status = 1\n"
                    + "left join Lesson_Learned ll on ll.lessonID = l.lessonID and ll.studentID = ?\n"
                    + "where c.courseID = ? and c.status = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, studentID);
            stm.setString(2, courseID);
            ResultSet rs = stm.executeQuery();
            Lesson lesson = null;
            while (rs.next()) {
                List<Lesson> listLesson = new ArrayList<>();
                if (lesson != null) {
                    listLesson.add(lesson);
                }
                Quiz quiz = new Quiz(rs.getInt(7), rs.getString(8), rs.getInt(9));
                listChapter.add(new Chapter(rs.getInt(1), rs.getString(2), rs.getInt(3), listLesson, quiz));
                listLesson.add(new Lesson(rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(10)));
                int pos = rs.getInt(3);
                while (rs.next()) {
                    if (pos == rs.getInt(3)) {
                        listLesson.add(new Lesson(rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(10)));
                    } else {
                        lesson = new Lesson(rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(10));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listChapter;
    }

    public static void main(String[] args) {
        ChapterDAO c = new ChapterDAO();
        System.out.println(c.listChapterByEnrollCourse("2", 10).get(1).getLessons().size());
    }

}
