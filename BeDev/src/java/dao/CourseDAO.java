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

/**
 *
 * @author Admin
 */
public class CourseDAO {

    public List<Course> listCourse() {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "select * from Course";
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
    
    public List<Course> listCourseByCategoryID(String categoryID) {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "select * from Course c inner join Course_Category cc on c.courseID = cc.courseID where categoryID = ?";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql);
            stm.setString(1, categoryID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getDouble(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Course> listCourseBySearch(String search) {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "select * from Course where courseName like ?";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getDouble(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Course> listCourseByPrice(String lowPrice, String highPrice) {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "select * from Course where price between ? and ?";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql);
            stm.setString(1, lowPrice);
            stm.setString(2, highPrice);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getDouble(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        for (Course category : dao.listCourse()) {
            System.out.println(category.toString());
        }
    }
}
