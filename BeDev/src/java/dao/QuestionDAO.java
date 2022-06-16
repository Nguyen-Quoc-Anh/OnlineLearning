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
        try {
            String sql = "select ques.questionID, ques.content, ques.explaination, o.optionID, o.content, t.NumberOfTrueOption\n"
                    + "from Question ques join [Option] o \n"
                    + "on ques.quizID = ? and ques.status = 1 and o.questionID = ques.questionID\n"
                    + "join (select ques.questionID, count(op.optionID) as NumberOfTrueOption\n"
                    + "from Question ques join [Option] op on ques.questionID = op.questionID and ques.quizID = ? and ques.status = 1 and op.isTrue = 1\n"
                    + "group by ques.questionID) t on t.questionID = ques.questionID";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            stm.setInt(2, quizID);
            ResultSet rs = stm.executeQuery();
            int questionID = 0, temp = 0;
            Question question = new Question();
            ArrayList<Option> options = new ArrayList<>();
            while (rs.next()) {
                temp = rs.getInt(1);
                if (temp != questionID) {   // new question
                    if (questionID != 0) {
                        question.setOptionList(options);
                        questions.add(question);
                    }
                    questionID = temp;
                    question = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), new Quiz(quizID), true);
                    question.setMultipleChoice(rs.getInt(6) > 1);
                    options = new ArrayList<>();
                }
                options.add(new Option(rs.getInt(4), question, rs.getNString(5)));
            }
            question.setOptionList(options);
            questions.add(question);
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
            String sql = "declare @pointPerQuestion float;\n"
                    + "set @pointPerQuestion = (select 10.0/count(q.questionID) from Question q where q.quizID = ? and q.status = 1);\n"
                    + "\n"
                    + "select ques.questionID, o.optionID, t.PointPerTrueOption\n"
                    + "from Question ques join [Option] o\n"
                    + "on ques.quizID = ? and ques.status = 1 and o.questionID = ques.questionID and o.isTrue = 1\n"
                    + "join (select ques.questionID, @pointPerQuestion/count(op.optionID) as PointPerTrueOption\n"
                    + "from Question ques join [Option] op on ques.questionID = op.questionID and ques.quizID = ? and ques.status = 1 and op.isTrue = 1\n"
                    + "group by ques.questionID) t on t.questionID = ques.questionID";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            stm.setInt(2, quizID);
            stm.setInt(3, quizID);
            ResultSet rs = stm.executeQuery();
            int questionID = 0, temp = 0;
            Question question = new Question();
            ArrayList<Option> options = new ArrayList<>();
            while (rs.next()) {
                temp = rs.getInt(1);
                if (temp != questionID) {   // new question
                    if (questionID != 0) {
                        question.setOptionList(options);
                        questions.add(question);
                    }
                    questionID = temp;
                    question = new Question(rs.getInt(1));
                    options = new ArrayList<>();
                }
                options.add(new Option(rs.getInt(2), rs.getDouble(3)));
            }
            question.setOptionList(options);
            questions.add(question);
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
        try {
            String sql = "select q.questionID, q.content, q.explaination from Question q\n"
                    + "where q.quizID = ? and q.status = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), optionDAO.numberTrueOption(rs.getInt(1)));
                ArrayList<Option> listOption = optionDAO.getOptionsByQuestionID(rs.getInt(1)); // list option of a question
                ArrayList<Option> listAnswer = optionDAO.getAnswerByRecordIdAndQuestionId(rid, rs.getInt(1)); // list answer of question in a record
                ArrayList<Option> listCompare = optionDAO.listCompareResult(rid, rs.getInt(1)); //list option compare between option of question and answer of student
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
