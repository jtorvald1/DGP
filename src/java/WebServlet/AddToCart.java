
package WebServlet;

import JavaBean.CartItem;
import JavaBean.ProductBean;
import JavaBean.SearchBean;
import JavaBean.ShoppingCart;
import java.io.IOException;
import java.util.ArrayList;
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

            SearchBean searchbean = (SearchBean) request.getSession().getAttribute("bean");
            ProductBean productBean = searchbean.getSearchResult().get(0);
            
            if(!alreadyInCart(productBean, cart))
                putInNewProduct(productBean, cart);
            
            cart.incrementNumber();

            request.setAttribute("bean", cart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ShoppingCart.jsp");

            dispatcher.forward(request, response);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private boolean alreadyInCart(ProductBean productBean, ShoppingCart cart)
    {
        ArrayList<CartItem> cartItems = cart.getItems();
        
        for(CartItem cartItem: cartItems)
        {
            ProductBean product = cartItem.getProduct();
            if(product.getProductId().equals(productBean.getProductId()))
            {
                cartItem.incrementQuantity();
                
                return true;
            }
        }
        return false;
    }
    
    private void putInNewProduct(ProductBean productBean, ShoppingCart cart) {
        CartItem newCartItem = new CartItem();
        newCartItem.setProduct(productBean);
        cart.getItems().add(newCartItem);
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
