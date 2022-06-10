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

    /**
     * This method get quiz by id.
     *
     * @param quizID id of quiz
     * @return Quiz
     */
    public Quiz getQuizByID(int quizID) {
        try {
            String sql = "select q.quizName, q.passRate from Quiz q where q.quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Quiz(quizID, rs.getNString(1), rs.getDouble(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method insert a quiz record into database.
     *
     * @param studentID id of student who take quiz
     * @param grade grade of student
     * @param quizID id of quiz
     * @return a quiz record id.
     */
    public int insertQuizRecord(int studentID, double grade, int quizID) {
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

    /**
     * This method update grade of a quiz record.
     *
     * @param grade student grade
     * @param quizRecordID id of quiz record
     */
    public void updateQuizRecordGrade(double grade, int quizRecordID) {
        try {
            String sql = "update Quiz_Record set grade = ? where quizRecordID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDouble(1, grade);
            stm.setInt(2, quizRecordID);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
