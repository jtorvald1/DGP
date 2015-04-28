
package WebServlet;

import JavaBean.ItemsBean;
import JavaBean.OrderBean;
import JavaBean.OrdersBean;
import JavaBean.ProductsBean;
import Model.HelperClasses.JavaBeanGenerator;
import Model.Webshop.CustomerOrder;
import Model.Webshop.Item;
import SessionBean.CustomerOrderFacade;
import SessionBean.ItemFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    @EJB
    private ItemFacade itemFacade;
 
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
            
            HashMap<Long, Integer> productCount = new HashMap<>();
            for(CustomerOrder order: orders)
            {     
                Collection<Item> items = order.getItems();

                for(Item item: items)
                {
                    Long productId = item.getProduct().getProductId();
                    Integer get = productCount.get(productId);
                    if(get == null)
                        get = 1;
                    else
                        get++;
                    
                    productCount.put(productId, get);

                    ArrayList<OrderBean> cheeseburgers = ordersBean.getOrders();
                    for(OrderBean orderBean: cheeseburgers)
                        if (orderBean.getOrderId().equals(order.getOrderId()))
                             orderBean.setAvailable(checkIfAvailable(productCount));
                }
                productCount = new HashMap<>();
            }
            
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

    private boolean checkIfAvailable(HashMap<Long, Integer> productCount) {
        Iterator it = productCount.entrySet().iterator();
        List<Item> findAvailableForShipping = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Long id = Long.parseLong(pair.getKey().toString());
            int quantity = Integer.parseInt(pair.getValue().toString());
            findAvailableForShipping = itemFacade.findAvailableForShipping(id, quantity);           
        }
        return !findAvailableForShipping.isEmpty();
    }
}