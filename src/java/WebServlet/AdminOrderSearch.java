
package WebServlet;

import JavaBean.ItemsBean;
import JavaBean.OrdersBean;
import JavaBean.ProductsBean;
import Model.HelperClasses.JavaBeanGenerator;
import Model.Webshop.CustomerOrder;
import SessionBean.CustomerOrderFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminOrderSearch", urlPatterns = {"/AdminOrderSearch"})
public class AdminOrderSearch extends HttpServlet {

    @EJB
    private CustomerOrderFacade orderFacade;
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try
        {
            String searchBy = request.getParameter("searchBy");
            String value = request.getParameter("value");
            
            Collection<CustomerOrder> orders;
            
            switch(searchBy)
            {
                case "orderId": 
                    CustomerOrder order = orderFacade.find(Long.parseLong(value));
                    orders = addToList(order, request); break;
                case "customerId": orders = orderFacade.findByCustomerId(Long.parseLong(value)); break;
                case "firstName": orders = orderFacade.findByFirstName(value);break;
                case "lastName": orders = orderFacade.findByLastName(value); break;
                default: orders = orderFacade.findAll(); break;
            }

            OrdersBean ordersBean = JavaBeanGenerator.getOrdersBean(orders);
            ItemsBean itemsBean = JavaBeanGenerator.getItemsBeanByOrders(orders);

            request.setAttribute("orders", ordersBean);
            request.setAttribute("items", itemsBean);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminOrders.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private ArrayList<CustomerOrder> addToList(CustomerOrder order, HttpServletRequest request) 
    {
        ArrayList<CustomerOrder> orders = new ArrayList<>();
        if(order != null) {
            orders.add(order);
            request.setAttribute("lastSearchedOrder", JavaBeanGenerator.getOrderBean(order)); 
        }
                     
        return orders;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}