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
import modal.Expert;

/**
 *
 * @author admin
 */
public class ExpertDAO extends DBContext {

    public List<Expert> listExpert() {
        List<Expert> list = new ArrayList<>();
        try {
            String sql = "select * from Expert";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Expert(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Expert profile(int id) {
        try {
            String sql = "select e.expertID, e.name, e.phone, e.imageURL, a.email, e.description from Expert e, Account a\n"
                    + "	where e.expertID = a.accountID and a.accountID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Expert(rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(6), new Account(rs.getInt(1), rs.getString(5), "", true, null, true));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void editProfileExpert(int id, String name, String phone, String description) {
        try {
            String sql = "update Expert\n"
                    + "	set name = ? and phone = ? and description = ?\n"
                    + "	where expertID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setNString(1, name);
            stm.setString(2, phone);
            stm.setNString(3, description);
            stm.setInt(4, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ExpertDAO dao = new ExpertDAO();
        List<Expert> list = dao.listExpert();
        System.out.println(list.size());
    }
}
