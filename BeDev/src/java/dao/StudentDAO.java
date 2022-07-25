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
import java.time.LocalDateTime;
import java.util.ArrayList;
import modal.Account;
import modal.Course;
import modal.Expert;
import modal.Option;
import modal.Student;
import modal.Transaction;

/**
 *
 * @author ACER
 */
public class StudentDAO extends DBContext {

    /**
     * This method get information of a student from database
     *
     * @param id is id of student
     * @return a student
     */
    public Student profile(int id) {
        try {
            String sql = "select s.studentID, s.name, s.cashInWallet, s.imageURL, a.email from Student s, Account a\n"
                    + "	where s.studentID = a.accountID and a.accountID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Student(new Account(rs.getInt(1), rs.getString(5), "", true, null, true), rs.getString(2), rs.getDouble(3), rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method allows student update information and insert it to database
     *
     * @param id is id of student
     * @param name is name updated
     */
    public void editProfile(int id, String name) {
        try {
            String sql = "update Student\n"
                    + "	set name = ?\n"
                    + "	where studentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setNString(1, name);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Transaction> listTransactionByStudent(int sid) {
        ArrayList<Transaction> list = new ArrayList<>();
        try {
            String sql = "select th.*, c.courseImage, c.courseName, c.description, c.expertID, e.name from Transaction_History th, Course c, Expert e\n"
                    + "where studentID = ? and th.courseID = c.courseID and c.expertID = e.expertID\n"
                    + "order by [time] desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Transaction(rs.getInt(1), new Student(new Account(rs.getInt(2))), rs.getTimestamp(3).toLocalDateTime(), 
                        rs.getFloat(4), new Course(rs.getInt(5), rs.getString(7), rs.getString(8), rs.getString(6), null), new Expert(rs.getInt(9), rs.getString(10), null)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s = dao.profile(10);
        System.out.println(s);
    }
}
