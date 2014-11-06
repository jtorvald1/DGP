/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServlet;

import JavaBean.ProductBean;
import JavaBean.SearchBean;
import Model.Product;
import SessionBean.ProductFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Nicole
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

    @EJB
    private ProductFacade productSessionFacade;
 
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        
        try {
           
            String searchBy = request.getParameter("SearchBy");
            String searchFor = request.getParameter("searchText");          
            
            Collection<Product> products = productSessionFacade.findByBrand(searchBy);
            
            ArrayList<ProductBean> result = getBeans(products);
   
            SearchBean searchbean = new SearchBean();
            searchbean.setSearchBy(searchBy);
            searchbean.setSearchFor(searchFor);
            searchbean.setSearchResult(result);

            request.setAttribute("bean", searchbean);
            //request.getSession().setAttribute("bean", searchbean);

            RequestDispatcher dispatcher = request.getRequestDispatcher("SearchResult.jsp");
            dispatcher.forward(request, response);
        }            
            catch(Exception ex)
        {
            System.out.println(ex);
        }     
    }
    
        private ArrayList<ProductBean> getBeans(Collection<Product> allProducts)
    {
        ArrayList<ProductBean> list = new ArrayList<ProductBean>();
        
        for(Product product : allProducts) {
            
            ProductBean productBean = getProductBean(product);            
            list.add(productBean);
        }
        
        return list;
    }
    
    private ProductBean getProductBean(Product product)
    {
        ProductBean productBean = new ProductBean();
        productBean.setDescription(product.getDescription());
        productBean.setSize(product.getSize());
        productBean.setBrand(product.getBrand());
        productBean.setPrice(product.getPrice());
        productBean.setColor(product.getColor());
        
        return productBean;                
    }

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
