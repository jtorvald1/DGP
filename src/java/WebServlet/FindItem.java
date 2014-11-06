
package WebServlet;

import JavaBean.CartItem;
import JavaBean.ProductBean;
import JavaBean.ProductsBean;
import JavaBean.SearchBean;
import Model.Item;
import Model.Product;
import SessionBean.ItemFacade;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FindItem", urlPatterns = {"/FindItem"})
public class FindItem extends HttpServlet {

    @EJB
    private ItemFacade itemFacade;
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            SearchBean searchbean = (SearchBean) request.getSession().getAttribute("bean");                 
            List<Item> items = itemFacade.findAvailable(searchbean.getSearchResult().get(0).getProductId().toString());
            Item item = items.get(0);
            
            CartItem cartItem = getCartItem(item);
            
            request.setAttribute("cartItem", cartItem);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddToCart");
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        finally
        {

        }
    }
    
    private CartItem getCartItem(Item item)
    {
        CartItem cartitem = new CartItem();
        cartitem.setBrand(item.getProduct().getBrand());
        cartitem.setDescription(item.getProduct().getDescription());
        cartitem.setColor(item.getProduct().getColor());
        cartitem.setPrice(item.getProduct().getPrice());
        
        return cartitem;                
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
