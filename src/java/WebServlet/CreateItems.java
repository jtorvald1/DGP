
package WebServlet;

import Model.Webshop.Item;
import Model.Webshop.Product;
import SessionBean.ItemFacade;
import java.io.IOException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@WebServlet(name = "CreateItems", urlPatterns = {"/CreateItems"})
public class CreateItems extends HttpServlet {
    
    @EJB
    private ItemFacade itemFacade;
    
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }
    
    private void persistItems(int items, Product product) throws IllegalStateException, SecurityException, SystemException
    {
        try
        {
            utx.begin();
            
            for(int i = 0; i < items; i++) {
                Item item = new Item();
                item.setProduct(product);
                itemFacade.create(item);
            }
            
            utx.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            utx.rollback();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
        
        try
        {
            String itemsString = request.getParameter("items");
            int items = Integer.parseInt(itemsString);
            Product product = (Product)request.getAttribute("productGeneratedId");           
            
            persistItems(items, product);
        }
        catch(Exception ex)
        {
            throw new ServletException();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
