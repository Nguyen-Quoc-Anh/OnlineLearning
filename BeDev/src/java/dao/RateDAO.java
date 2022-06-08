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
import modal.Account;
import modal.Rate;
import modal.Student;

/**
 *
 * @author Admin
 */
public class RateDAO extends DBContext {
    public List<Rate> listRateByCourse(String courseID) {
        List<Rate> list = new ArrayList<>();
        try {
            String sql = "select r.rateID, r.star, r.content, s.studentID, "
                    + "s.name, s.imageURL from Rate r inner join Student s "
                    + "on r.studentID = s.studentID where courseID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, courseID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Rate(rs.getInt(1), rs.getInt(2), new Student(new Account(rs.getInt(4)), rs.getString(5), rs.getString(6)), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        RateDAO r = new RateDAO();
        for (Rate rate : r.listRateByCourse("1")) {
            System.out.println(rate.toString());
        }
    }
}
