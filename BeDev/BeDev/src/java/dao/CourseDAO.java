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
public class CourseDAO {

    public List<Course> listCoursePart(int page) {
        int number = 6;
        List<Course> list = new ArrayList<>();
        try {
            String sql = "select * from Course order by releasedDate desc "
                    + " offset " + (page - 1) * number + " rows fetch next " + page * number + " rows only";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getDouble(6)));
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
            String sql = "	select co.*, e.name from Course co, Expert e\n"
                    + "	where co.courseID in (select a.courseID from  (select top(6) e.courseID, count(*) as Number_Registed from Enroll e, Course c\n"
                    + "	where e.courseID = c.courseID\n"
                    + "	group by e.courseID\n"
                    + "	order by Number_Registed desc ) as a) and co.expertID = e.expertID";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Expert(rs.getInt(5), rs.getString(9), "", "", ""), rs.getDouble(6), rs.getDate(7), rs.getBoolean(8), en.countEnrollOfCourse(rs.getInt(1)), le.countLessonOfCourse(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        for (Course category : dao.listCoursePart(1)) {
            System.out.println(category.toString());
        }     
    }
}
