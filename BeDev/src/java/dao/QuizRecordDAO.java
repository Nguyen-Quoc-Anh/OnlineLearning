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
import modal.QuizRecord;

/**
 *
 * @author admin
 */
public class QuizRecordDAO extends DBContext {

    /**
     * This method get list of quiz record done by student
     *
     * @param sid is student id
     * @param qid is quiz id
     * @return a quiz record
     */
    public ArrayList<QuizRecord> listRecord(int sid, int qid) {
        ArrayList<QuizRecord> list = new ArrayList<>();
        try {
            String sql = "select quizRecordID, quizID, time, grade from Quiz_Record\n"
                    + "where studentID = ? and quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.setInt(2, qid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new QuizRecord(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3).toLocalDateTime(), rs.getFloat(4), 0));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     * This method is a record of grade and passrate of quiz in a quiz record
     * completed by student
     *
     * @param rid is recordID
     * @param qid is quiz id
     * @param sid is student id
     * @return a quiz record
     */
    public QuizRecord compareGrade(int rid, int qid, int sid) {
        try {
            String sql = "select qr.grade, q.passRate, q.quizName from Quiz_Record qr, Quiz q\n"
                    + "where qr.quizID =  q.quizID and qr.quizRecordID = ? and q.quizID = ? and qr.studentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rid);
            stm.setInt(2, qid);
            stm.setInt(3, sid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new QuizRecord(rs.getFloat(1), rs.getInt(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    /**
     * This method used to check quiz record existed in database
     * @param sid is student id
     * @param rid is record id
     * @return number of quiz record
     */
    public int checkExistQuizRecord(int sid, int rid) {
        try {
            String sql = "select count(qr.quizRecordID) from Quiz_Record qr\n"
                    + "where qr.studentID = ? and qr.quizRecordID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.setInt(2, rid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    /**
     * This method get name of a quiz
     *
     * @param qid is a quiz id
     * @return a name of quiz
     */
    public QuizRecord nameOfQuiz(int qid) {
        try {
            String sql = "select quizName from Quiz\n"
                    + "where quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, qid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new QuizRecord(0, 0, rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        QuizRecordDAO d = new QuizRecordDAO();
        int k = d.checkExistQuizRecord(10, 1);
        System.out.println(k);
    }
}
