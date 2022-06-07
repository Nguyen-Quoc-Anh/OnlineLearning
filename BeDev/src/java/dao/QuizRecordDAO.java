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
                list.add(new QuizRecord(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getFloat(4), 0));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
