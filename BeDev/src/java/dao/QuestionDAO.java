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
            String sql = "select ques.questionID, ques.content, ques.explaination, count(o.optionID)\n"
                    + "from Question ques, [Option] o \n"
                    + "where ques.quizID = ? and ques.status = 1 and o.questionID = ques.questionID and o.isTrue = 1\n"
                    + "group by ques.questionID, ques.content, ques.explaination";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), new Quiz(quizID), true);
                question.setMultipleChoice(rs.getInt(4) > 1);
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
            String sql = "select ques.questionID, 10.0/count(ques.questionID)\n"
                    + "from Question ques join Question ques1 on ques.quizID = ? and ques.status = 1 and ques1.status =1\n"
                    + "group by ques.questionID";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
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
            String sql = "select count(*) from Question where quizID = ? and status = 1";
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

    public int countAnswer(int quizID, int rid, int quesID) {
        try {
            String sql = "select count(ar.answerID) from Answer_Record ar, Question q\n"
                    + "where ar.questionID = q.questionID and q.quizID = ? and ar.quizRecordID = ? and ar.questionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            stm.setInt(2, rid);
            stm.setInt(3, quesID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    /**
     * This method get list question (contain option of question and answer of
     * student) in a quiz
     *
     * @param quizID
     * @param rid
     * @return
     */
    public ArrayList<Question> listQuestionByQuizIdAndRecordId(int quizID, int rid) {
        ArrayList<Question> questions = new ArrayList<>();
        OptionDAO optionDAO = new OptionDAO();
        QuestionDAO questionDAO = new QuestionDAO();
        try {
            String sql = "select distinct(ar.questionID), q.content, q.explaination from Answer_Record ar, Question q\n"
                    + "where ar.questionID = q.questionID and ar.quizRecordID = ? and q.quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rid);
            stm.setInt(2, quizID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), optionDAO.numberTrueOption(rs.getInt(1)));
                ArrayList<Option> listOption = optionDAO.getOptionsByQuestionID(rs.getInt(1)); // list option of a question
                ArrayList<Option> listAnswer = optionDAO.getAnswerByRecordIdAndQuestionId(rid, rs.getInt(1)); // list answer of question in a record
                ArrayList<Option> listCompare = optionDAO.listCompareResult(rid, rs.getInt(1)); //list option compare between option of question and answer of student
                question.setOptionList(listOption);
                question.setAnswerList(listAnswer);
                question.setCompareList(listCompare);
                question.setNumberAnswer(questionDAO.countAnswer(quizID, rid, rs.getInt(1)));
                questions.add(question);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return questions;
    }

    /**
     * This method get list of question by id of the quiz
     * @param qid is quiz id
     * @return list of question
     */
    public ArrayList<Question> getQuestionByQuiz(int qid) {
        ArrayList<Question> questions = new ArrayList<>();
        OptionDAO optionDAO = new OptionDAO();
        try {
            String sql = "select q.questionID, q.content, q.explaination, q.status from Question q\n"
                    + "where q.quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, qid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                questions.add(new Question(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), optionDAO.checkQuestionCompleted(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return questions;
    }

    /**
     * This method allows update status of question by id of the question
     * @param questionID is question id
     * @param qid is quiz id
     */
    public void inActiveQuestion(int questionID, int qid) {
        try {
            String sql = "update Question\n"
                    + "set status = 0 where questionID = ? and quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionID);
            stm.setInt(2, qid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    /**
     * This method allows update status of question by id of the question
     * @param questionID is question id
     * @param qid is quiz id
     */
    public void activeQuestion(int questionID, int qid) {
        try {
            String sql = "update Question\n"
                    + "set status = 1 where questionID = ? and quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionID);
            stm.setInt(2, qid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    /**
     * This method allows update the question in database
     * @param content is the new content will be update
     * @param explain is the new explain will be update
     * @param quesID is id of question
     * @param qid  is id of quiz
     */
    public void editQuestion(String content, String explain, int quesID, int qid) {
        try {
            String sql = "update Question\n"
                    + "set content = ?, explaination = ?\n"
                    + "where questionID = ? and quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setNString(1, content);
            stm.setNString(2, explain);
            stm.setInt(3, quesID);
            stm.setInt(4, qid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    /**
     * This method allows delete question in database by id of the question
     * @param questionID is question id
     * @param qid is quiz id
     */ 
    public void deleteQuestion(int questionID, int qid) {
        try {
            String sql = "delete from [Option]\n"
                    + "where questionID = ?\n"
                    + "delete from Question\n"
                    + "where questionID = ? and quizID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionID);
            stm.setInt(2, questionID);
            stm.setInt(3, qid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    /**
     * This method get the question by the id of the question
     * @param questionID is question id
     * @return a question
     */
    public Question getQuestion(int questionID) {
        try {
            String sql = "select q.questionID, q.content, q.explaination, q.quizID from Question q\n"
                    + "where q.questionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Question(rs.getInt(1), rs.getString(2), rs.getString(3), new Quiz(rs.getInt(4)), true);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        QuestionDAO d = new QuestionDAO();
        ArrayList<Question> list = d.getQuestionByQuiz(1);
        System.out.println(list.size());
    }
}
