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
import modal.Course;
import modal.Expert;

/**
 *
 * @author Admin
 */
public class CourseDAO extends DBContext {

    public List<Course> listCourse() {
        List<Course> list = new ArrayList<>();
        try {
            LessonDAO le = new LessonDAO();
            EnrollDAO en = new EnrollDAO();
            String sql = "select co.*, e.name, e.imageURL from Course co, Expert e where co.expertID = e.expertID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Expert(rs.getInt(5), rs.getString(9), rs.getString(10), "", ""), rs.getDouble(6), rs.getDate(7), rs.getBoolean(8), en.countEnrollOfCourse(rs.getInt(1)), le.countLessonOfCourse(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Course> listCourseByCategoryID(String categoryID) {
        List<Course> list = new ArrayList<>();
        try {
            LessonDAO le = new LessonDAO();
            EnrollDAO en = new EnrollDAO();
            String sql = "select co.*, e.name, e.imageURL from Expert e, Course co inner join Course_Category cc on co.courseID = cc.courseID where co.expertID = e.expertID and categoryID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, categoryID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Expert(rs.getInt(5), rs.getString(9), rs.getString(10), "", ""), rs.getDouble(6), rs.getDate(7), rs.getBoolean(8), en.countEnrollOfCourse(rs.getInt(1)), le.countLessonOfCourse(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Course> listCourseBySearch(String search) {
        List<Course> list = new ArrayList<>();
        try {
            LessonDAO le = new LessonDAO();
            EnrollDAO en = new EnrollDAO();
            String sql = "select co.*, e.name, e.imageURL from Course co, Expert e where co.expertID = e.expertID and co.courseName like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Expert(rs.getInt(5), rs.getString(9), rs.getString(10), "", ""), rs.getDouble(6), rs.getDate(7), rs.getBoolean(8), en.countEnrollOfCourse(rs.getInt(1)), le.countLessonOfCourse(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Course> listCourseByPrice(String lowPrice, String highPrice) {
        List<Course> list = new ArrayList<>();
        try {
            LessonDAO le = new LessonDAO();
            EnrollDAO en = new EnrollDAO();
            String sql = "select co.*, e.name, e.imageURL from Course co, Expert e where co.expertID = e.expertID and price between ? and ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lowPrice);
            stm.setString(2, highPrice);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Expert(rs.getInt(5), rs.getString(9), rs.getString(10), "", ""), rs.getDouble(6), rs.getDate(7), rs.getBoolean(8), en.countEnrollOfCourse(rs.getInt(1)), le.countLessonOfCourse(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Course> listCourseByStar(String star) {
        List<Course> list = new ArrayList<>();
        try {
            LessonDAO le = new LessonDAO();
            EnrollDAO en = new EnrollDAO();
            String sql = "select co.*, e.name, e.imageURL from Expert e, Course co where co.expertID = e.expertID and co.courseID in (select courseID from Rate group by courseID having AVG(star) > ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, star);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Expert(rs.getInt(5), rs.getString(9), rs.getString(10), "", ""), rs.getDouble(6), rs.getDate(7), rs.getBoolean(8), en.countEnrollOfCourse(rs.getInt(1)), le.countLessonOfCourse(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

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
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

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

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        for (Course category : dao.listCourseByStar("1")) {
            System.out.println(category.toString());
        }
    }
}
