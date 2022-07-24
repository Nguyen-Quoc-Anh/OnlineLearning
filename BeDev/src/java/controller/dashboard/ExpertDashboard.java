/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dashboard;

import dao.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.Account;
import modal.Course;

/**
 *
 * @author ACER
 */
public class ExpertDashboard extends HttpServlet {

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
        CourseDAO courseDAO = new CourseDAO();
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
//        int totalEnroll = courseDAO.countTotalEnrollByExpertId(account.getAccountID());
//        int totalStudent = courseDAO.countTotalStudentEnrollByExpertId(account.getAccountID());
//        double sumTotalEarningOfExpertThisMonth = courseDAO.sumTotalEarningOfExpertThisMonth(account.getAccountID());
//        double sumTotalEarningOfExpertThisYear = courseDAO.sumTotalEarningOfExpertThisYear(account.getAccountID());
//        List<Course> getListCourseAnalysisByExpertId = courseDAO.getListCourseAnalysisByExpertId(account.getAccountID());

        int totalEnroll = courseDAO.countTotalEnrollByExpertId(5);
        int totalStudentEnroll = courseDAO.countTotalStudentEnrollByExpertId(5);
        double totalEarningOfExpertLastMonth = courseDAO.getTotalEarningOfExpertLastMonth(5);
        double totalEarningOfExpert = courseDAO.getEarningOfExpertTotal(5);
        List<Course> listCourses = courseDAO.getListCourseAnalysisByExpertId(5);
        request.setAttribute("totalEnroll", totalEnroll);
        request.setAttribute("totalStudentEnroll", totalStudentEnroll);
        request.setAttribute("totalEarningOfExpertLastMonth", totalEarningOfExpertLastMonth);
        request.setAttribute("totalEarningOfExpertThisYear", totalEarningOfExpert);
        request.setAttribute("listCourses", listCourses);

        request.getRequestDispatcher("/view/expertDashboard.jsp").forward(request, response);
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
