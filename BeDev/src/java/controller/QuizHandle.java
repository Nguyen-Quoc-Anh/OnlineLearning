/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import dao.QuizDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Answer;
import modal.Question;
import modal.Quiz;

/**
 *
 * @author ACER
 */
@WebServlet(name = "QuizHandle", urlPatterns = {"/QuizHandle"})
public class QuizHandle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("//view//quizhandle.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        QuizDAO quizDAO = new QuizDAO();
        QuestionDAO questionDAO = new QuestionDAO();
        try {
            int quizID = Integer.parseInt(request.getParameter("qid"));
            Quiz quiz = quizDAO.getQuizByID(quizID);
            if (quiz == null) {
                throw new Exception();
            }
            request.setAttribute("questionList", questionDAO.getQuestionByQuizID(quizID));
            request.setAttribute("quiz", quiz);
        } catch (Exception e) {
            response.sendRedirect("Error");
            return;
        }

        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        QuizDAO quizDAO = new QuizDAO();
        QuestionDAO questionDAO = new QuestionDAO();
        try {
            int quizID = Integer.parseInt(request.getParameter("qid"));
            Quiz quiz = quizDAO.getQuizByID(quizID);
            if (quiz == null) {
                throw new Exception();
            }
            ArrayList<Question> questionsList = questionDAO.getQuestionByQuizID(quizID);
            ArrayList<Question> answeredRecord = new ArrayList<>();
            double pointPerQuestion = 10 / questionsList.size();
            for (int i = 0; i < questionsList.size(); i++) {
                int numberOfTrueAnswer = 0;
                for (Answer a : questionsList.get(i).getAnswerList()) {
                    if (a.isTrue()) {
                        numberOfTrueAnswer++;
                    }
                }

                String[] answers = request.getParameterValues(Integer.toString(questionsList.get(i).getQuestionID()));
                if (answers == null) {
                    continue;
                }
                ArrayList<Answer> answersList = new ArrayList<>();
                for (int j = 0; j < answers.length; j++) {
                    answersList.add(new Answer(Integer.parseInt(answers[j]), pointPerQuestion / numberOfTrueAnswer));
                }

                Question question = new Question(questionsList.get(i).getQuestionID());
                question.setPointPerQuestion(pointPerQuestion);
                question.setAnswerList(answersList);
                answeredRecord.add(question);
            }
            double totalPoint = 0;

            for (Question question : questionsList) {
                if (answeredRecord.contains(question)) {
                    for (Answer answer : question.getAnswerList()) {
                        Question q = answeredRecord.get(answeredRecord.indexOf(question));
                        q.setPointPerQuestion(0);
                        if (q.getAnswerList().contains(answer) && answer.isTrue()) {
                            double point = q.getAnswerList().get(q.getAnswerList().indexOf(answer)).getPoint();
                            totalPoint += point;
                            q.setPointPerQuestion(q.getPointPerQuestion() + point);
                        }
                    }
                }
            }
            System.out.println(totalPoint);
            request.setAttribute("totalPoint", totalPoint);
            request.setAttribute("answeredList", answeredRecord);
            request.setAttribute("questionList", questionsList);
            request.setAttribute("quiz", quiz);
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("Error");
            return;
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
