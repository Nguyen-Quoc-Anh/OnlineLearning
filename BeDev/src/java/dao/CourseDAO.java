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
    
    
    
    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        for (Course category : dao.listCoursePart(1)) {
            System.out.println(category.toString());
        }
    }
}
