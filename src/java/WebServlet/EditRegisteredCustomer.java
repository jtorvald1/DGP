
package WebServlet;

import Model.Webshop.Customer;
import Model.Webshop.PayingMember;
import Model.Webshop.RegisteredCustomer;
import SessionBean.CustomerFacade;
import JavaBean.UserBean;
import java.io.IOException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Torvald
 */
@WebServlet(name = "EditRegisteredCustomer", urlPatterns = {"/EditRegisteredCustomer"})
public class EditRegisteredCustomer extends HttpServlet {
    
    @EJB
    private CustomerFacade customerFacade;
    
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        try 
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String userName = request.getParameter("email");
            String password = request.getParameter("password");
            
            HttpSession userSession = request.getSession();
            UserBean user = (UserBean) userSession.getAttribute("user");
            

            //Either Username needs to be unchangeable, or this could find the user by the ID instead. 
            //Because if the user changes the username, we won't be able to find the newly created/updated user
            //to update the bean/session.
            //OR an easier idea, it could just log out, and redirect you to a "login" page and make you log back in.
            Customer customer = (Customer) customerFacade.findByUserName(user.getUserName());
            if (customer instanceof RegisteredCustomer) {
                RegisteredCustomer nonpayingCustomer = (RegisteredCustomer) customer;
            
                    nonpayingCustomer.setFirstName(firstName);
                    nonpayingCustomer.setLastName(lastName);
                    nonpayingCustomer.setAddress(address);
                    nonpayingCustomer.setEmail(email);
                    nonpayingCustomer.setUserName(userName);
                    nonpayingCustomer.setPassword(password);
                
            utx.begin();
            
            customerFacade.edit(nonpayingCustomer);
            
            utx.commit();
            
            response.sendRedirect("index.jsp");
            }
            
            else if (customer instanceof PayingMember) {
                PayingMember payingCustomer = (PayingMember) customer;
                
                
            utx.begin();
            
            customerFacade.remove(payingCustomer);
            
            utx.commit();
            
                RegisteredCustomer nonpayingCustomer = new RegisteredCustomer();
                    nonpayingCustomer.setFirstName(firstName);
                    nonpayingCustomer.setLastName(lastName);
                    nonpayingCustomer.setAddress(address);
                    nonpayingCustomer.setEmail(email);
                    nonpayingCustomer.setUserName(userName);
                    nonpayingCustomer.setPassword(password);
            
            utx.begin();
            
            customerFacade.create(nonpayingCustomer);
            
            utx.commit();
            
            response.sendRedirect("index.jsp");
            }
            
            //This could be replaced by logging out, redirecting to login page
            Customer updatedCustomer = (Customer) customerFacade.findByUserName(user.getUserName());
                    
                    user.setFirstName(updatedCustomer.getFirstName());
                    user.setlastName(updatedCustomer.getLastName());
                    user.setUserName(updatedCustomer.getUserName());
                    user.setEmail(updatedCustomer.getEmail());
                    user.setAddress(updatedCustomer.getAddress());
                    user.setPassword(updatedCustomer.getPassword());
                    user.setOrders(updatedCustomer.getOrders());
                    request.getSession().setAttribute("user", user);

        }
        catch(Exception e)
        {
            System.out.println(e);
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
