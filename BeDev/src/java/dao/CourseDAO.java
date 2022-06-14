/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.Course;
import modal.Expert;

/**
 *
 * @author Admin
 */
public class CourseDAO extends DBContext {
    /**
     * This method get list course from database
     * @return a list of course
     */
    public List<Course> listCourse() {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "select c.courseID, c.courseName, c.courseImage, e.expertID, "
                    + "e.name, e.imageURL, c.price, eoc.enrolCourse, "
                    + "loc.numberLesson, aoc.averageStar from Course c left join "
                    + "Expert e on e.expertID = c.expertID left join (select c.courseID, "
                    + "COUNT(c.courseID) as numberLesson  from Course c, Chapter ch, "
                    + "Lesson l where c.courseID = ch.courseID and ch.chapterID = l.chapterID "
                    + "group by c.courseID) loc on c.courseID = loc.courseID left join "
                    + "(select e.courseID, COUNT(e.courseID) as enrolCourse  from Enroll e "
                    + "group by e.courseID) eoc on c.courseID = eoc.courseID left join "
                    + "(select r.courseID, AVG(star) as averageStar from Rate r group by "
                    + "r.courseID) aoc on c.courseID = aoc.courseID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        new Expert(rs.getInt(4), rs.getString(5), rs.getString(6)), 
                        rs.getDouble(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    /**
     * This method get list course by category ID from database
     * @return a list of course
     */
    public List<Course> listCourseCategory(String categoryID) {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "select c.courseID, c.courseName, c.courseImage, e.expertID, "
                    + "e.name, e.imageURL, c.price, eoc.enrolCourse, "
                    + "loc.numberLesson, aoc.averageStar from Course c left join "
                    + "Expert e on e.expertID = c.expertID left join (select c.courseID, "
                    + "COUNT(c.courseID) as numberLesson  from Course c, Chapter ch, "
                    + "Lesson l where c.courseID = ch.courseID and ch.chapterID = l.chapterID "
                    + "group by c.courseID) loc on c.courseID = loc.courseID left join "
                    + "(select e.courseID, COUNT(e.courseID) as enrolCourse  from Enroll e "
                    + "group by e.courseID) eoc on c.courseID = eoc.courseID left join "
                    + "(select r.courseID, AVG(star) as averageStar from Rate r group by "
                    + "r.courseID) aoc on c.courseID = aoc.courseID left join "
                    + "Course_Category cc on cc.courseID = c.courseID where cc.categoryID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, categoryID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        new Expert(rs.getInt(4), rs.getString(5), rs.getString(6)), 
                        rs.getDouble(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    /**
     * This method get list top 6 courses have highest register
     * @return a list of course
     */
    public List<Course> listFeatureCourse() {
        List<Course> list = new ArrayList<>();
        try {
            LessonDAO le = new LessonDAO();
            EnrollDAO en = new EnrollDAO();
            String sql = "select co.*, e.name, e.imageURL from Course co, Expert e\n"
                    + "where co.courseID in (select a.courseID from  (select top(6) e.courseID, count(*) as Number_Registed from Enroll e, Course c\n"
                    + "where e.courseID = c.courseID\n"
                    + "group by e.courseID\n"
                    + "order by Number_Registed desc ) as a) and co.expertID = e.expertID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Expert(rs.getInt(5), rs.getString(9), rs.getString(10), "", ""), rs.getDouble(6), rs.getDate(7), rs.getBoolean(8), en.countEnrollOfCourse(rs.getInt(1)), le.countLessonOfCourse(rs.getInt(1))));              
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     * This method get list courses of expert
     * @param id is id of expert
     * @return a list of courses
     */
    public List<Course> listCourseByExpert(int id) {
        List<Course> list = new ArrayList<>();
        try {
            LessonDAO le = new LessonDAO();
            EnrollDAO en = new EnrollDAO();
            String sql = "select c.*, e.name from Course c, Expert e\n"
                    + "	where c.expertID = e.expertID and e.expertID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Expert(rs.getInt(5), rs.getString(9), "", "", ""), rs.getDouble(6), rs.getDate(7), rs.getBoolean(8), en.countEnrollOfCourse(rs.getInt(1)), le.countLessonOfCourse(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    /**
     * This method count number course create by expert
     * @param id is id of expert
     * @return number of course
     */
    public int countCourseOfExpert(int id) {
        try {
            String sql = "select count(*) from Course\n"
                    + "where expertID = ?";
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
    
    public boolean checkStudentEnrollByQuizID (int quizID, int studentID) {
        try {
            String sql = "select e.* from Enroll e, Quiz q, Chapter c where q.chapterID = c.chapterID and c.courseID = e.courseID and "
                    + "q.quizID = ? and e.studentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
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

    /**
     * This method get course by course ID
     * @return a course
     */
    public Course getCourseById(String courseID) {
        try {
            String sql = "select c.courseID, c.courseName, c.description, c.courseImage, "
                    + "e.expertID, e.name, e.imageURL, e.description, c.price, c.releasedDate, "
                    + "eoc.enrolCourse, loc.numberLesson, aoc.averageStar "
                    + "from Course c left join Expert e on e.expertID = c.expertID "
                    + "left join (select c.courseID, COUNT(c.courseID) as numberLesson "
                    + "from Course c, Chapter ch, Lesson l where c.courseID = ch.courseID "
                    + "and ch.chapterID = l.chapterID group by c.courseID) loc "
                    + "on c.courseID = loc.courseID left join (select e.courseID, "
                    + "COUNT(e.courseID) as enrolCourse  from Enroll e group by e.courseID) "
                    + "eoc on c.courseID = eoc.courseID left join (select r.courseID, "
                    + "AVG(star) as averageStar from Rate r group by r.courseID) "
                    + "aoc on c.courseID = aoc.courseID where c.courseID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, courseID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        new Expert(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8)),
                        rs.getDouble(9), rs.getDate(10) ,rs.getInt(11), rs.getInt(12), rs.getInt(13));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method get 4 course by category ID and don't get a course have below course ID
     * @return a list of course
     */
    public List<Course> relatedCourse(String courseID, int categoryID) {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "select top 4 c.courseID, c.courseName, c.courseImage, e.expertID, "
                    + "e.name, e.imageURL, c.price, eoc.enrolCourse, "
                    + "loc.numberLesson, aoc.averageStar from Course c left join "
                    + "Expert e on e.expertID = c.expertID left join (select c.courseID, "
                    + "COUNT(c.courseID) as numberLesson  from Course c, Chapter ch, "
                    + "Lesson l where c.courseID = ch.courseID and ch.chapterID = l.chapterID "
                    + "group by c.courseID) loc on c.courseID = loc.courseID left join "
                    + "(select e.courseID, COUNT(e.courseID) as enrolCourse  from Enroll e "
                    + "group by e.courseID) eoc on c.courseID = eoc.courseID left join "
                    + "(select r.courseID, AVG(star) as averageStar from Rate r group by "
                    + "r.courseID) aoc on c.courseID = aoc.courseID left join "
                    + "Course_Category cc on cc.courseID = c.courseID where cc.categoryID = ? and c.courseID != ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryID);
            stm.setString(2, courseID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        new Expert(rs.getInt(4), rs.getString(5), rs.getString(6)), 
                        rs.getDouble(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    /**
     * This method enroll a course by course ID
     */
    public void enrollCourse(String courseID, int accountID) {
        try {
            String sql = "insert into Enroll values (?, ?, GETDATE())";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, courseID);
            stm.setInt(2, accountID);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        for (Course category : dao.listCourseCategory("1")) {
            System.out.println(category.toString());
        }
//        System.out.println(dao.getCourseById("1"));
    }
}
