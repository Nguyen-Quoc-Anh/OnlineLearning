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
import modal.Account;
import modal.Rate;
import modal.Student;

/**
 *
 * @author Admin
 */
public class RateDAO extends DBContext {

    /**
     * This method get a list rate by course ID from database
     *
     * @return a list rate
     */
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

    //huy
    public boolean rateCourse(int courseID, int studentID, int star, String contentRate) {
        try {
            String sql = "Insert into Rate(star,studentID,content,courseID) values(?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, star);
            stm.setInt(2, studentID);
            stm.setNString(3, contentRate);
            stm.setInt(4, courseID);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    //huy
    public boolean checkRated(int studentID, int courseID) {
        try {
            String sql = "select * from Rate where studentID = ? and courseID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, studentID);
            stm.setInt(2, courseID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    //huy
    public Rate getRateByStudnetIdAndCourseId(int studentID, int courseID) {
        try {
            String sql = "select * from Rate where studentID = ? and courseID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, studentID);
            stm.setInt(2, courseID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Rate(rs.getInt("star"), rs.getNString("content"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //huy
    public void updateRate(int courseID, int studentID, int star, String contentRate) {
        try {
            String sql = "Update Rate \n"
                    + "set star = ? , content = ?\n"
                    + "where studentID = ? and  courseID =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, star);
            stm.setNString(2, contentRate);
            stm.setInt(3, studentID);
            stm.setInt(4, courseID);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteRate( int studentID, int courseID) {
        try {
            String sql = "Delete Rate \n"
                    + "where studentID =? and courseID =?";
            PreparedStatement stm =connection.prepareStatement(sql);
            stm.setInt(1, studentID);
            stm.setInt(2, courseID);
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        RateDAO r = new RateDAO();
        System.out.println(r.getRateByStudnetIdAndCourseId(10, 1).getContent());;
    }
}
