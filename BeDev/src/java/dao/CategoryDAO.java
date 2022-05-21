/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modal.Category;

/**
 *
 * @author Admin
 */
public class CategoryDAO {
    public List<Category> listCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category";
        try {
            Connection con = new DBContext().connection;
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        for (Category category : dao.listCategory()) {
            System.out.println(category.toString());
        }
    }
}
