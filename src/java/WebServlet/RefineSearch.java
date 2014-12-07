
package WebServlet;

import JavaBean.ProductBean;
import JavaBean.ProductsBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RefineSearch", urlPatterns = {"/RefineSearch"})
public class RefineSearch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession shoppingSession = request.getSession();
        
        ProductsBean searchResult = (ProductsBean) shoppingSession.getAttribute("searchResult");
        String size = (String) request.getParameter("size");
        String color = (String) request.getParameter("color");
                    
        ProductBean productToShow = searchResult.searchByColorAndSize(size, color);
        
        shoppingSession.setAttribute("productToShow", productToShow);
        RequestDispatcher dispatcher = request.getRequestDispatcher("produkt.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}