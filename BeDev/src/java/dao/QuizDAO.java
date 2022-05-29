/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modal.Quiz;

/**
 *
 * @author ACER
 */
public class QuizDAO extends DBContext {

    public Quiz getQuizByID(int quizID) {
        try {
            String sql = "select * from Quiz where quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Quiz(quizID, rs.getNString(3), rs.getDouble(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public int insertQuizRecord (int studentID, double grade, int quizID) {
        try {
            String sql = "insert into Quiz_Record (studentID, grade, quizID) values (?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, studentID);
            stm.setDouble(2, grade);
            stm.setInt(3, quizID);
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
}
