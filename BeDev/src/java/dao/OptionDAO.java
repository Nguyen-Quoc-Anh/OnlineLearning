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
import modal.Option;
import modal.Question;

/**
 *
 * @author ACER
 */
public class OptionDAO extends DBContext {

    /**
     * This method get all option of each question
     *
     * @param questionID id of question
     * @return list contain options
     */
    public ArrayList<Option> getOptionsByQuestionID(int questionID) {
        ArrayList<Option> options = new ArrayList<>();
        try {
            String sql = "select o.optionID, o.content, o.isTrue from [Option] o where o.questionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                options.add(new Option(rs.getInt(1), new Question(questionID), rs.getString(2), rs.getBoolean(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return options;
    }

    /**
     * This method get true option of each question
     *
     * @param question
     * @return list contain only true options
     */
    public ArrayList<Option> getTrueOptionsByQuestionID(Question question) {
        ArrayList<Option> options = new ArrayList<>();
        try {
            String sql = "select o.optionID, \n"
                    + "(?/(select count(o.optionID) from [Option] o where o.questionID = ? and o.isTrue = 1 group by o.questionID)) as PointPerTrueOption \n"
                    + "from [Option] o where o.questionID = ? and o.isTrue = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDouble(1, question.getPointPerQuestion());
            stm.setInt(2, question.getQuestionID());
            stm.setInt(3, question.getQuestionID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                options.add(new Option(rs.getInt(1), rs.getDouble(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return options;
    }

    /**
     * This method insert student answers into database.
     *
     * @param answerList list contain student answer
     * @param quizRecordID id of record
     */
    public void insertOptionRecord(ArrayList<Question> answerList, int quizRecordID) {
        String sql;
        PreparedStatement stm;
        for (Question question : answerList) {
            for (Option answer : question.getOptionList()) {
                try {
                    sql = "insert into Answer_Record (quizRecordID, questionID, answerID) values (?, ?, ?)";
                    stm = connection.prepareStatement(sql);
                    stm.setInt(1, quizRecordID);
                    stm.setInt(2, question.getQuestionID());
                    stm.setInt(3, answer.getOptionID());
                    stm.executeUpdate();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
