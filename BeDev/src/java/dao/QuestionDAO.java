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
import modal.Quiz;

/**
 *
 * @author ACER
 */
public class QuestionDAO extends DBContext {

    /**
     * This method get questions of quiz by id
     *
     * @param quizID id of quiz
     * @return list contain questions
     */
    public ArrayList<Question> getQuestionByQuizID(int quizID) {
        ArrayList<Question> questions = new ArrayList<>();
        OptionDAO answerDAO = new OptionDAO();
        try {
            String sql = "select ques.questionID, ques.content, ques.explaination, ques.status, \n"
                    + "(select count(o.optionID) from [Option] o where o.isTrue = 1 and o.questionID = ques.questionID) as NumberOfTrueOption\n"
                    + "from Question ques where ques.quizID = ? and ques.status = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), new Quiz(quizID), rs.getBoolean(4));
                question.setMultipleChoice(rs.getInt(5) > 1);
                ArrayList<Option> option = answerDAO.getOptionsByQuestionID(question.getQuestionID());
                question.setOptionList(option);
                questions.add(question);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return questions;
    }

    /**
     * This method get questions of quiz by id. Each question contain only true
     * option
     *
     * @param quizID id of quiz
     * @return list contain questions
     */
    public ArrayList<Question> getQuestionsAndTrueOption(int quizID) {
        ArrayList<Question> questions = new ArrayList<>();
        OptionDAO answerDAO = new OptionDAO();
        try {
            String sql = "select ques.questionID, \n"
                    + "(10.0/(select count(*) from Question q where q.quizID = ? and q.status = 1)) as PointPerQuestion \n"
                    + "from Question ques where ques.quizID = ? and ques.status = 1\n"
                    + "group by ques.quizID, ques.questionID";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            stm.setInt(2, quizID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getDouble(2));
                ArrayList<Option> option = answerDAO.getTrueOptionsByQuestionID(question);
                question.setOptionList(option);
                questions.add(question);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return questions;
    }

    /**
     * This method count number of questions in quiz
     *
     * @param quizID id of quiz
     * @return number of questions
     */
    public int countQuestionsInQuiz(int quizID) {
        try {
            String sql = "select count(*) from Question where quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public ArrayList<Question> listQuestionByQuizID(int quizID, int rid) {
        ArrayList<Question> questions = new ArrayList<>();
        OptionDAO optionDAO = new OptionDAO();
        try {
            String sql = "select q.questionID, q.content, q.explaination from Question q\n"
                    + "where q.quizID = ? and q.status = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), optionDAO.numberTrueOption(rs.getInt(1)));
                ArrayList<Option> listOption = optionDAO.getOptionsByQuestionID(quizID);
                ArrayList<Answer> listAnswer = optionDAO.getAnswerByRecordIdAndQuestionId(rid, rs.getInt(1));
                ArrayList<Answer> listCompare = optionDAO.listCompareResult(rid);
                question.setOptionList(listOption);
                question.setAnswerList(listAnswer);
                question.setCompareList(listCompare);
                questions.add(question);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return questions;
    }
}
