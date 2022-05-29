/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EnrollDAO;
import dao.ExpertDAO;
import dao.StudentDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.Account;
import modal.Enroll;
import modal.Expert;
import modal.Student;

/**
 *
 * @author admin
 */
@WebServlet(name = "StudentProfile", urlPatterns = {"/StudentProfile"})
public class StudentProfile extends HttpServlet {

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
        request.getRequestDispatcher("//view/studentProfile.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        StudentDAO studentDao = new StudentDAO();
        ExpertDAO expertDao = new ExpertDAO();
        EnrollDAO enrollDAO = new EnrollDAO();
        try {
            if (session != null && session.getAttribute("account") != null) {
                Account account = (Account) session.getAttribute("account");
                
                if (account.getRole().getRoleID() == 2) {
                    System.out.println(account.getRole().getRoleID());
                    Student student = studentDao.profile(account.getAccountID());
                    System.out.println(student.getName());
                    int countEnroll = enrollDAO.countEnrollOfStudent(account.getAccountID());
                    request.setAttribute("student", student);
                    request.setAttribute("countEnroll", countEnroll);
                    processRequest(request, response);
                }
                if (account.getRole().getRoleID()==3) {
                    Expert expert = expertDao.profile(account.getAccountID());
                    System.out.println(expert.getExpertName());
                    System.out.println(expert.getAccount().getEmail());
                    System.out.println(expert.getPhone());                  
                    System.out.println(expert.getDescription());
                    request.setAttribute("expert", expert);
                    processRequest(request, response);
                }

            } else {
                response.sendRedirect("SignIn");
                return;
            }
        } catch (IOException e) {
            System.out.println(e);
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
        HttpSession session = request.getSession();
        EnrollDAO enrollDAO = new EnrollDAO();
        StudentDAO studentDao = new StudentDAO();
        ExpertDAO expertDao = new ExpertDAO();
        try {
            if (session != null && session.getAttribute("account") != null) {
                Account account = (Account) session.getAttribute("account");
                
                
                if (account.getRole().getRoleID() == 2) {
                    String name = request.getParameter("name");
                    studentDao.editProfile(account.getAccountID(), name);
                    
                    Student student = studentDao.profile(account.getAccountID());
                    int countEnroll = enrollDAO.countEnrollOfStudent(account.getAccountID());
                    request.setAttribute("student", student);
                    request.setAttribute("countEnroll", countEnroll);
                }
                if(account.getRole().getRoleID() == 3){
                    String name = request.getParameter("name");
                    String phone = request.getParameter("phone");
                    String des = request.getParameter("des");
                    expertDao.editProfileExpert(account.getAccountID(), name, phone, des);
                    Expert expert = expertDao.profile(account.getAccountID());
                    request.setAttribute("expert", expert);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
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
