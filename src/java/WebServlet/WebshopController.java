
package WebServlet;

import JavaBean.ShoppingCart;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "WebshopController", urlPatterns = {"/WebshopController"})
public class WebshopController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession ShoppingSession = request.getSession();
        ShoppingCart cart = (ShoppingCart)ShoppingSession.getAttribute("cart");
        
        if(cart == null) {
            cart = new ShoppingCart();
            ShoppingSession.setAttribute("cart", cart);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/AllProducts");
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
