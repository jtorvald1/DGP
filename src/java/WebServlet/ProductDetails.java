
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

@WebServlet(name = "ProductDetails", urlPatterns = {"/ProductDetails"})
public class ProductDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession shoppingSession = request.getSession();
        
        ProductsBean lastSearchedProducts = (ProductsBean) shoppingSession.getAttribute("lastSearchedProducts");
        String productNumberString = (String) request.getParameter("productNumber");
        int productNumber = Integer.parseInt(productNumberString);
            
        ProductBean productToShow = lastSearchedProducts.getAllProducts().get(productNumber);
        
        request.setAttribute("detailedProduct", productToShow);
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
