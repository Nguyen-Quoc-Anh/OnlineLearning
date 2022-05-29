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
            String sql = "select * from [Option] where questionID = ?";
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

    public boolean insertAnswerRecord(ArrayList<Question> answerList, int quizRecordID) {
        String sql;
        PreparedStatement stm;
        for (Question question : answerList) {
            for (Answer answer : question.getAnswerList()) {
                try {
                    sql = "insert into Answer_Record (quizRecordID, questionID, answerID) values (?, ?, ?)";
                    stm = connection.prepareStatement(sql);
                    stm.setInt(1, quizRecordID);
                    stm.setInt(2, question.getQuestionID());
                    stm.setInt(3, answer.getAnswerID());
                    stm.executeUpdate();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
        return true;
    }
}
