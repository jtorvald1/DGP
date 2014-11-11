
package WebServlet;

import JavaBean.CartItem;
import JavaBean.ShoppingCart;
import Model.Item;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try
        {
            HttpSession ShoppingSession = request.getSession();
            ShoppingCart cart = (ShoppingCart)ShoppingSession.getAttribute("cart");

            CartItem cartItem = getCartItem(request);
            cart.getItems().add(cartItem);
            System.out.println(cart);
            request.setAttribute("bean", cart);
            /*RequestDispatcher dispatcher = request.getRequestDispatcher("ShoppingCart.jsp");

            dispatcher.forward(request, response);*/
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private CartItem getCartItem(HttpServletRequest request)
    {
        Item item = (Item)request.getAttribute("item");
        CartItem cartItem = new CartItem();
        
        cartItem.setBrand(item.getProduct().getBrand());
        cartItem.setColor(item.getProduct().getColor());
        cartItem.setDescription(item.getProduct().getDescription());
        //.........
        
        return cartItem; 
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
