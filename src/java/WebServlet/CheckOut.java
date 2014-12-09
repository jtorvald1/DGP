
package WebServlet;

import JavaBean.CartItem;
import JavaBean.ProductBean;
import JavaBean.ShoppingCart;
<<<<<<< HEAD
import JavaBean.UserBean;
import Model.Customer;
import Model.CustomerOrder;
import Model.Item;
import SessionBean.CustomerFacade;
=======
import Model.Webshop.CustomerOrder;
import Model.Webshop.Item;
>>>>>>> d7950a2d799517f65159c0a7a8d6a1e6a4ef3376
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
    @EJB
    private CustomerFacade customerFacade;
    
    @Resource
    private UserTransaction userTransaction;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalStateException, SecurityException, SystemException {
      
        try
        {
            HttpSession ShoppingSession = request.getSession();
            ShoppingCart cart = (ShoppingCart)ShoppingSession.getAttribute("cart");
            UserBean userMan = (UserBean)ShoppingSession.getAttribute("user");
            System.out.println(userMan);
          /*  Customer findU = findU(userMan);

            userTransaction.begin();
            
            ArrayList<Item> items = getItemsFromDB(cart);
            createOrder(items, findU);
            
            userTransaction.commit();*/
        }
                  
        catch(Exception ex)
        {
            System.out.println(ex);
            //userTransaction.rollback();
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
    
    private void createOrder(ArrayList<Item> items, Customer userMan)
    {
        try
        {
            CustomerOrder order = new CustomerOrder();
            order.setDateTime(new Date().toString());
            order.setCustomer(userMan);
            System.out.println(userMan);
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
    
    
    private Customer findU(UserBean userMan)
    {
        Customer findU = customerFacade.find(userMan.getUserId());
        System.out.println(userMan);
        return findU;
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
