/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServlet;

import JavaBean.SearchBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
/**
 *
 * @author Nicole
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        
        try {
           
            String searchBy = request.getParameter("SearchBy");
            String searchFor = request.getParameter("SearchFor");
            String result = new String("SearchResult");
                
           // Query query = em.createQuery("select * from PRODUCT order by PRODUCT_ID");
           // List<AllProducts> products= query.getResultList();
   
            SearchBean searchbean= new SearchBean();
            searchbean.setSearchBy(searchBy);
            searchbean.setSearchFor(searchFor);
            searchbean.setResult(result);

            request.setAttribute("bean", searchbean);

            RequestDispatcher dispatcher =
            request.getRequestDispatcher("SearchResult.jsp");
            dispatcher.forward(request, response);   

        }            
            catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
            
    }
            /*  Query query = em.createQuery("select * from PRODUCT order by PRODUCT_ID");
            List<AllProducts> products= query.getResultList();
            }
               Query query = em.createQuery("select * from PRODUCT order by PRODUCT_ID");
            List<AllProducts> products= query.getResultList();
            }   
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Search</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Search at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
