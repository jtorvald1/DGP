
package WebServlet;

import Model.Webshop.Customer;
import Model.Webshop.Image;
import Model.Webshop.Item;
import Model.Webshop.PayingMember;
import Model.Webshop.Product;
import Model.Webshop.RegisteredCustomer;
import SessionBean.CustomerFacade;
import SessionBean.ItemFacade;
import SessionBean.ProductFacade;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.apache.commons.io.IOUtils;

@WebServlet(name = "AdminCustomerEdit", urlPatterns = {"/AdminCustomerEdit"})
@MultipartConfig(maxFileSize = 10000000)
public class AdminCustomerEdit extends HttpServlet {
    
    @EJB
    private CustomerFacade customerFacade;
    //@EJB
    //private ItemFacade itemFacade;
    
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalStateException, SecurityException, SystemException 
    {       
        String operation = request.getParameter("operation");
        String userId = request.getParameter("userId");
        
        
        switch(operation)
        {
            case "delete": deleteCustomer (userId, response); break;
            case "Edit customer": editCustomer(userId, request, response); break;
            case "Create new customer": createCustomer(request, response); break;
        }
    }
    
    private void deleteCustomer(String userId, HttpServletResponse response) throws IllegalStateException, SecurityException, SystemException
    {
        try
        {
            Customer customer = customerFacade.find(Long.parseLong(userId));
            
            if(customer != null)
            {
                
                utx.begin();

                customerFacade.remove(customer);
            
                utx.commit();
            }
            response.sendRedirect("AdminUsers.jsp");
        }
        catch(Exception ex)
        {
            utx.rollback();
            System.out.println(ex);
        }
    }
    

    private void editCustomer(String userId, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, SecurityException, SystemException 
    {
        if(request.getParameter("isPayingMember") != null){
            editPayingCustomer(userId, request, response);
        }
        else{
            editNonpayingMember(userId, request, response);
        }

    }
    
    private void editPayingCustomer(String userId, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, SecurityException, SystemException {
        try
        {
            Customer customer = customerFacade.find(Long.parseLong(userId));           

            if(customer != null)
            {
                if (customer instanceof PayingMember) {
                PayingMember payingCustomer = (PayingMember) customer;
                
                customer = setNewPayingMemberParameters(payingCustomer, request);
                
                utx.begin();
                
                customerFacade.edit(customer);
                
                utx.commit();
                }
                
                else if (customer instanceof RegisteredCustomer) {
                RegisteredCustomer nonpayingCustomer = (RegisteredCustomer) customer;
                
                utx.begin();
            
                customerFacade.remove(nonpayingCustomer);

                utx.commit();
                
                
                PayingMember payingCustomer = new PayingMember();
                customer = setNewPayingMemberParameters(payingCustomer, request);
                
                
                utx.begin();
                
                customerFacade.create(customer);
                
                utx.commit();
                }
            }
            response.sendRedirect("AdminUsers.jsp");
        }
        catch(Exception ex)
        {
            utx.rollback();
            System.out.println(ex);
        }
    }
    
    private void editNonpayingMember(String userId, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, SecurityException, SystemException {
        try
        {
            Customer customer = customerFacade.find(Long.parseLong(userId));           

            if(customer != null)
            {
                if (customer instanceof RegisteredCustomer) {
                RegisteredCustomer nonpayingCustomer = (RegisteredCustomer) customer;
                
                customer = setNewNonpayingMemberParameters(nonpayingCustomer, request);
                
                utx.begin();
                
                customerFacade.edit(customer);
                
                utx.commit();
                }
                
                else if (customer instanceof PayingMember) {
                PayingMember payingCustomer = (PayingMember) customer;
                
                utx.begin();
            
                customerFacade.remove(payingCustomer);

                utx.commit();
                
                
                RegisteredCustomer nonpayingCustomer = new RegisteredCustomer();
                customer = setNewNonpayingMemberParameters(nonpayingCustomer, request);
                
                
                
                utx.begin();
                
                customerFacade.create(customer);
                
                utx.commit();
                }
            }
            response.sendRedirect("AdminUsers.jsp");
        }
        catch(Exception ex)
        {
            utx.rollback();
            System.out.println(ex);
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, SecurityException, SystemException
    {
        if(request.getParameter("isPayingMember") != null){
            try
            {
                Customer customer = getPayingCustomer(request);

                utx.begin();

                customerFacade.create(customer);
                customerFacade.flushEntityManager();

                utx.commit();
                
                response.sendRedirect("AdminUsers.jsp");
            }
            
            catch(Exception ex)                
            {
                System.out.println(ex);

            }
        }
        
        else{
            try
            {
                Customer customer = getNonpayingCustomer(request);

                utx.begin();

                customerFacade.create(customer);
                customerFacade.flushEntityManager();

                utx.commit();
                
                response.sendRedirect("AdminUsers.jsp");
            }
            
            catch(Exception ex)
            {
                System.out.println(ex);

            }
        }
    }
    
    private Customer setNewPayingMemberParameters(PayingMember payingMember, HttpServletRequest request)
    {
        boolean isActive = (request.getParameter("isPayingMember") != null);
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        boolean isPayingMember = isActive;
        String membershipPeriod = "03-10-2014";
        String membershipFee = "300";
        
        payingMember.setUserName(username);
        payingMember.setPassword(password);
        payingMember.setFirstName(firstName);
        payingMember.setLastName(lastName);
        payingMember.setAddress(address);
        payingMember.setEmail(email);
        payingMember.setIsPayingMember(isPayingMember);
        payingMember.setMembershipFee(Double.parseDouble(membershipFee));
        payingMember.setMembershipPeriod(membershipPeriod);
        
        return payingMember;
    }
    
    private Customer setNewNonpayingMemberParameters(RegisteredCustomer nonpayingMember, HttpServletRequest request)
    {
        boolean isActive = (request.getParameter("isPayingMember") != null);
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        boolean isPayingMember = isActive;
        
        nonpayingMember.setUserName(username);
        nonpayingMember.setPassword(password);
        nonpayingMember.setFirstName(firstName);
        nonpayingMember.setLastName(lastName);
        nonpayingMember.setAddress(address);
        nonpayingMember.setEmail(email);
        nonpayingMember.setIsPayingMember(isPayingMember);
        
        return nonpayingMember;
    }
    
    private PayingMember getPayingCustomer(HttpServletRequest request)
    {
        PayingMember payingCustomer = null;
        
        try
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String membershipPeriod = "03-10-2014";
            String membershipFee = "300";

            
            payingCustomer = new PayingMember();
            payingCustomer.setFirstName(firstName);
            payingCustomer.setLastName(lastName);
            payingCustomer.setAddress(address);
            payingCustomer.setEmail(email);
            payingCustomer.setUserName(username);
            payingCustomer.setPassword(password);
            payingCustomer.setIsPayingMember(true);
            payingCustomer.setMembershipFee(Double.parseDouble(membershipFee));
            payingCustomer.setMembershipPeriod(membershipPeriod);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        return payingCustomer;
    }
    
    private RegisteredCustomer getNonpayingCustomer(HttpServletRequest request)
    {
        RegisteredCustomer nonpayingCustomer = null;
        
        try
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String email = request.getParameter("email");

            
            nonpayingCustomer = new RegisteredCustomer();
            nonpayingCustomer.setFirstName(firstName);
            nonpayingCustomer.setLastName(lastName);
            nonpayingCustomer.setAddress(address);
            nonpayingCustomer.setEmail(email);
            nonpayingCustomer.setUserName(username);
            nonpayingCustomer.setPassword(password);
            nonpayingCustomer.setIsPayingMember(false);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        return nonpayingCustomer;
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
    }

    
}
