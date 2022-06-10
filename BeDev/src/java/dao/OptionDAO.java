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

    public ArrayList<Answer> getAnswerByRecordIdAndQuestionId(int rid, int questionId) {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            String sql = "select ar.answerID from Answer_Record ar\n"
                    + "where ar.quizRecordID = ? and ar.questionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rid);
            stm.setInt(2, questionId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                answers.add(new Answer(new Option(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return answers;
    }

    public ArrayList<Answer> listCompareResult(int rid) {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            String sql = "SELECT O.optionID AS TRUE_OPTION, AR.answerID AS ANSWER_OPTION, O1.content AS STUDENT_ANSWER FROM Question Q\n"
                    + "LEFT JOIN Answer_Record AR\n"
                    + "ON AR.questionID = Q.questionID AND AR.quizRecordID = ?\n"
                    + "right join [OPTION] O\n"
                    + "ON O.questionID = Q.questionID AND O.isTrue = 1 AND Q.status = 1\n"
                    + "JOIN [Option] O1\n"
                    + "ON O1.optionID = AR.answerID";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                answers.add(new Answer(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return answers;
    }

    public static void main(String[] args) {
        OptionDAO dao = new OptionDAO();
        int k = dao.numberTrueOption(11);
        ArrayList<Answer> answers = dao.getAnswerByRecordIdAndQuestionId(1, 11);
        System.out.println(answers.size());
        System.out.println(k);
    }
}
