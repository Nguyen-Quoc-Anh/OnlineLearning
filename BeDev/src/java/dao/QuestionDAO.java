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
            String sql = "declare @pointPerQuestion float;\n"
                    + "set @pointPerQuestion = (select 10.0/count(q.questionID) from Question q where q.quizID = ? and q.status = 1);\n"
                    + "select ques.questionID, ques.content, o.optionID, o.content, o.isTrue, t.PointPerTrueOption, t.NumberOfTrueAnswer\n"
                    + "from Question ques join [Option] o\n"
                    + "on ques.quizID = ? and ques.status = 1 and o.questionID = ques.questionID\n"
                    + "join (select ques.questionID, @pointPerQuestion/count(op.optionID) as PointPerTrueOption, count(op.optionID) as NumberOfTrueAnswer\n"
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
                    question = new Question(rs.getInt(1), rs.getString(2), "", new Quiz(quizID), true);
                    question.setMultipleChoice(rs.getInt(7) > 1);
                    options = new ArrayList<>();
                }
                options.add(new Option(rs.getInt(3), rs.getNString(4), rs.getBoolean(5), rs.getDouble(6)));
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

    public static void main(String[] args) {
        QuestionDAO d = new QuestionDAO();
        ArrayList<Question> list = d.listQuestionByQuizIdAndRecordId(1, 2);
        System.out.println(list.size());
    }
}
