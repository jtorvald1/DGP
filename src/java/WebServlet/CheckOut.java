
package WebServlet;

import JavaBean.CartItem;
import JavaBean.ProductBean;
import JavaBean.ShoppingCart;
import Model.CustomerOrder;
import Model.Item;
import SessionBean.CustomerOrderFacade;
import SessionBean.ItemFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@WebServlet(name = "CheckOut", urlPatterns = {"/CheckOut"})
public class CheckOut extends HttpServlet {
    
    @EJB
    private ItemFacade itemFacade;
    @EJB
    private CustomerOrderFacade customerOrderFacade;
    
    @Resource
    private UserTransaction userTransaction;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalStateException, SecurityException, SystemException {
      
        try
        {
            HttpSession ShoppingSession = request.getSession();
            ShoppingCart cart = (ShoppingCart)ShoppingSession.getAttribute("cart");

            userTransaction.begin();
            
            ArrayList<Item> items = getItemsFromDB(cart);
            createOrder(items);
            
            userTransaction.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            userTransaction.rollback();
        }
    }

    private ArrayList<Item> getItemsFromDB(ShoppingCart cart)
    {
        ArrayList<CartItem> cartItems = cart.getItems();
        ArrayList<Item> checkoutItems = new ArrayList<>();
        
        for(CartItem cartItem: cartItems)
        {
            ProductBean productBean = cartItem.getProduct();          
            List<Item> items = itemFacade.findAvailable(productBean.getProductId(), cartItem.getQuantity());
            checkoutItems.addAll(items);
        }
        
        return checkoutItems; 
    }
    
    private void createOrder(ArrayList<Item> items)
    {
        try
        {
            CustomerOrder order = new CustomerOrder();
            order.setDateTime(new Date().toString());
            customerOrderFacade.create(order);
            
            for(Item item: items) {
                item.setOrder(order);
                itemFacade.edit(item);
            }            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        try
        {
            processRequest(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            processRequest(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
