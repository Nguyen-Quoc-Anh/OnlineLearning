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
import modal.Rate;

/**
 *
 * @author Admin
 */
public class RateDAO extends DBContext {
    public List<Rate> starCourse() {
        List<Rate> list = new ArrayList<>();
        try {
            String sql = "select AVG(star), courseID from Rate group by courseID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Rate(rs.getInt(1), new Course(rs.getInt(2))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
