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
                return new QuizRecord(rs.getInt(1), rs.getInt(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

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
}
