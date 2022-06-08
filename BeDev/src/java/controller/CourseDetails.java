/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.ChapterDAO;
import dao.CourseDAO;
import dao.RateDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Category;
import modal.Chapter;
import modal.Course;
import modal.Rate;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CourseDetails", urlPatterns = {"/CourseDetails"})
public class CourseDetails extends HttpServlet {

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
        CourseDAO courseDAO = new CourseDAO();
        String courseID = request.getParameter("courseID");
        Course course = courseDAO.getCourseById(courseID);
        request.setAttribute("course", course);
        
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> listCategory = categoryDAO.listCategoryByCourse(courseID);
        request.setAttribute("categoryOfCourse", listCategory);
        
        ChapterDAO chapterDAO = new ChapterDAO();
        List<Chapter> listChapter = chapterDAO.listChapter(courseID);
        request.setAttribute("listChapter", listChapter);
        
        RateDAO rateDAO = new RateDAO();
        List<Rate> listRate = rateDAO.listRateByCourse(courseID);
        request.setAttribute("listRate", listRate);
        
        
        List<Course> relatedCourse = courseDAO.relatedCourse(courseID, listCategory.get(0).getCategoryID());
        request.setAttribute("relatedCourse", relatedCourse);
        request.getRequestDispatcher("//view//courseDetails.jsp").forward(request, response);
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
