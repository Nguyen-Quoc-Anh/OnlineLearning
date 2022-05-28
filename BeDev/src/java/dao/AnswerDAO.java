/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modal.Answer;
import modal.Question;

/**
 *
 * @author ACER
 */
public class AnswerDAO extends DBContext {

    public ArrayList<Answer> getAnswersByQuestionID(int questionID) {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            String sql = "select * from Answer where questionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                answers.add(new Answer(rs.getInt(1), new Question(rs.getInt(2)), rs.getString(3), rs.getBoolean(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return answers;
    }
}
