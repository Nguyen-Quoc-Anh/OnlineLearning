/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OptionDAO;
import dao.QuestionDAO;
import dao.QuizDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.Account;
import modal.Option;
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
        HttpSession session = request.getSession();
        QuestionDAO questionDAO = new QuestionDAO();
        OptionDAO answerDAO = new OptionDAO();
        double totalGrade = 0;
        try {
            Account account = (Account) session.getAttribute("account");
            int quizID = Integer.parseInt(request.getParameter("qid"));
            ArrayList<Question> questionsList = questionDAO.getQuestionsAndTrueOption(quizID);
            int quizRecordID = quizDAO.insertQuizRecord(account.getAccountID(), quizID);
            if (quizRecordID == -1) {   // can't insert into database
                request.setAttribute("mess", "Cannot insert quiz record.");
                processRequest(request, response);
                return;
            }
            for (Question question : questionsList) {
                // get checked option
                String[] studentOptions = request.getParameterValues(Integer.toString(question.getQuestionID()));
                if (studentOptions == null) {   // student not answer this question
                    answerDAO.insertOptionRecord(question.getQuestionID(), -1, quizRecordID);
                    continue;
                }
                for (int j = 0; j < studentOptions.length; j++) {
                    int index = question.getOptionList().indexOf(new Option(Integer.parseInt(studentOptions[j])));
                    if (index != -1) {  // option student checked is true
                        totalGrade += question.getOptionList().get(index).getPoint();   // add point
                    }
                    answerDAO.insertOptionRecord(question.getQuestionID(), Integer.parseInt(studentOptions[j]), quizRecordID);
                }
            }
            quizDAO.updateQuizRecordGrade(totalGrade, quizRecordID);
            response.sendRedirect("QuizReview?rid=" + quizRecordID + "&qid=" + quizID);    // redirect to view result
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("Error");
        }
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
