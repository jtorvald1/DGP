
package WebServlet;

import JavaBean.CartItem;
import JavaBean.ShoppingCart;
import Model.CustomerOrder;
import Model.Item;
import SessionBean.CustomerOrderFacade;
import SessionBean.ItemFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        try
        {
            HttpSession ShoppingSession = request.getSession();
            ShoppingCart cart = (ShoppingCart)ShoppingSession.getAttribute("cart");

            ArrayList<CartItem> cartItems = cart.getItems();
            
            ArrayList<Item> items = convertToEntityBeans(cartItems);
            
            createOrder(items);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private ArrayList<Item> convertToEntityBeans(ArrayList<CartItem> cartItems)
    {
        ArrayList<Item> items = new ArrayList<Item>();
        
        for(CartItem cartItem : cartItems) {
            Long cartItemId = cartItem.getItemId();
            Item item = itemFacade.find(cartItemId);
            items.add(item);
        }
        
        return items;
    }
    
    private void createOrder(ArrayList<Item> items) throws IllegalStateException, SecurityException, SystemException
    {
        try
        {
            userTransaction.begin();
            
            CustomerOrder order = new CustomerOrder(items);
            order.setDateTime(new Date().toString());
            customerOrderFacade.create(order);
            
            for(Item item: items) {
                item.setOrder(order);
                itemFacade.create(item);
            }            
            
            userTransaction.commit();
        }
        catch(Exception ex)
        {
            userTransaction.rollback();
        }
        
        
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
