
package WebServlet;

import JavaBean.ItemsBean;
import JavaBean.ProductsBean;
import JavaBean.UsersBean;
import Model.HelperClasses.JavaBeanGenerator;
import Model.Webshop.Customer;
import Model.Webshop.Product;
import SessionBean.CustomerFacade;
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

@WebServlet(name = "AdminUserSearch", urlPatterns = {"/AdminUserSearch"})
public class AdminUserSearch extends HttpServlet {

    @EJB
    private CustomerFacade customerFacade;
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try
        {
            String searchBy = request.getParameter("searchBy");
            String value = request.getParameter("value");
            
            Collection<Customer> customers;
            
            switch(searchBy)
            {
                case "customerId": 
                    Customer customer = customerFacade.find(Long.parseLong(value));
                    customers = addToList(customer, request); break;
                case "username": customers = addToList((Customer) customerFacade.findByUserName(value), request); break;
                case "password": customers = customerFacade.findByPassword(value); break;
                case "firstName": customers = customerFacade.findByFirstName(value); break;
                case "lastName": customers = customerFacade.findByLastName(value); break;
                case "address": customers = customerFacade.findByAddress(value); break;
                case "email": customers = customerFacade.findByEmail(value); break;
                case "isPayingMember": customers = customerFacade.findByIsPayingMember(value); break;
                default: customers = customerFacade.findAll(); break;
            }

            UsersBean usersBean = JavaBeanGenerator.getUsersBean(customers);
            //ItemsBean itemsBean = JavaBeanGenerator.getItemsBeanByProjects(products);

            request.setAttribute("users", usersBean);
            //request.setAttribute("items", itemsBean);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminUsers.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private ArrayList<Customer> addToList(Customer customer, HttpServletRequest request) 
    {
        ArrayList<Customer> customers = new ArrayList<>();
        if(customer != null) {
            customers.add(customer);
            request.setAttribute("lastSearchedUser", JavaBeanGenerator.getUserBean(customer)); 
        }
             
        
        return customers;
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
