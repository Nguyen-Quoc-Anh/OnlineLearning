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
     * @return a list chapter
     */
    public List<Chapter> listChapterByCourse(String courseID) {
        List<Chapter> listChapter = new ArrayList<>();
        try {
            String sql = "select c.chapterID, c.chapterName, c.position,"
                    + " l.lessonID, l.lessonName, l.position, q.quizID, "
                    + "q.quizName, q.position from Chapter c "
                    + "left join Lesson l on c.chapterID = l.chapterID "
                    + "left join Quiz q on c.chapterID = q.chapterID "
                    + "where c.courseID = ? and (q.status is NULL or q.status = 1) "
                    + "and (l.status is NULL or l.status = 1) and c.status = 1";
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

    public static void main(String[] args) {
        ChapterDAO c = new ChapterDAO();
        System.out.println(c.listChapterByCourse("2").get(1).getLessons().size());
    }

}
