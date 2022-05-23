/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

<<<<<<< OURS

import dal.DBContext;
=======
import context.DBContext;
>>>>>>> THEIRS
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modal.Account;
import modal.Student;

/**
 *
 * @author Admin
 */
public class AccountDAO {
    public boolean validEmail(String email) {
        try {
            String sql = "select * from Account where email = ?";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public int signup(Student student) {
        try {
            String sql = "insert into Account(email, password, role) values (?, ?, ?); ";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, student.getAccount().getEmail());
            stm.setString(2, student.getAccount().getPassword());
            stm.setInt(3, student.getAccount().getRole().getRoleID());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            while (rs.next()) {
                student.getAccount().setAccountID(rs.getInt(1));
            }
            sql = "insert into Student(studentID, name, imageURL) values (?, ?, ?)";
            stm = new DBContext().connection.prepareStatement(sql);
            stm.setInt(1, student.getAccount().getAccountID());
            stm.setNString(2, student.getName());
            stm.setNString(3, "../BeDev/view/dist/images/avatar/user_avatar.png");
            stm.executeUpdate();
            return student.getAccount().getAccountID();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public boolean checkAccount(Account account) {
        try {
            String sql = "select * from Account where email = ? and accountID = ?";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql);
            stm.setString(1, account.getEmail());
            stm.setInt(2, account.getAccountID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean accountVerification(int id) {
        try {
            String sql = "update Account set emailVerify = 1 where accountID = ?";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean resetPassword(Account account) {
        try {
            String sql = "update Account set password = ? where email = ?";
            PreparedStatement stm = new DBContext().connection.prepareStatement(sql);
            stm.setString(1, account.getPassword());
            stm.setString(2, account.getEmail());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
