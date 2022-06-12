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
     * @param questionID id of question
     * @param optionID id of option
     * @param quizRecordID id of record
     */
    public void insertOptionRecord(int questionID, int optionID, int quizRecordID) {
        String sql;
        PreparedStatement stm;
        try {
            sql = "insert into Answer_Record (quizRecordID, questionID, answerID) values (?, ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, quizRecordID);
            stm.setInt(2, questionID);
            stm.setInt(3, optionID);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int numberTrueOption(int questionID) {
        try {
            String sql = "select count(o.isTrue) from [Option] o\n"
                    + "where o.isTrue = 1 and o.questionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    /**
     * This method get list answer of question in a record
     * @param rid is record id
     * @param questionId is question id
     * @return 
     */
    public ArrayList<Option> getAnswerByRecordIdAndQuestionId(int rid, int questionId) {
        ArrayList<Option> opList = new ArrayList<>();
        try {
            String sql = "select ar.answerID from Answer_Record ar\n"
                    + "where ar.quizRecordID = ? and ar.questionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rid);
            stm.setInt(2, questionId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                opList.add(new Option(rs.getInt(1)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return opList;
    }
    
    /**
     * This method get list option compare between option of question and answer of student
     * @param rid is record id
     * @param questionID is question id
     * @return 
     */
    public ArrayList<Option> listCompareResult(int rid, int questionID) {
        ArrayList<Option> answers = new ArrayList<>();
        try {
            String sql = "select o.optionID, o.content, o.isTrue, ar.answerID from [Option] o\n"
                    + "left join Answer_Record ar\n"
                    + "on o.questionID = ar.questionID and o.optionID = ar.answerID and ar.quizRecordID = ?\n"
                    + "where o.questionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rid);
            stm.setInt(2, questionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                answers.add(new Option(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return answers;
    }

    public static void main(String[] args) {
        OptionDAO dao = new OptionDAO();
        ArrayList<Option> blabla = dao.listCompareResult(1,11);
        for (Option option : blabla) {
            System.out.println(option.getAnswerOption());
        }
    }

}
