
package WebServlet;

import Model.Webshop.CustomerOrder;
import Model.Webshop.Item;
import SessionBean.CustomerOrderFacade;
import SessionBean.ItemFacade;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@WebServlet(name = "AdminOrderShipment", urlPatterns = {"/AdminOrderShipment"})
public class AdminOrderShipment extends HttpServlet {
    
    @EJB
    private CustomerOrderFacade customerOrderFacade;
    @EJB
    private ItemFacade itemFacade;
    
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException 
    {
        try
        {
            String orderId = request.getParameter("orderId");
        
            CustomerOrder order = customerOrderFacade.find(Long.parseLong(orderId));
        
            if(order != null)
            {
                utx.begin();
                
                orderShipped(order);
                customerOrderFacade.edit(order);

                utx.commit();
            }
            response.sendRedirect("AdminOrders.jsp");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            utx.rollback();
        }
    }

    private void orderShipped(CustomerOrder order)
    {
        order.setShipped(true);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
