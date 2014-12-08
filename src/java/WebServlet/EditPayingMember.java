
package WebServlet;

import Model.Customer;
import Model.PayingMember;
import Model.RegisteredCustomer;
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
@WebServlet(name = "EditPayingMember", urlPatterns = {"/EditPayingMember"})
public class EditPayingMember extends HttpServlet {
    
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
            String membershipPeriod = "03-10-2014";
            String membershipFee = "300";
            
            HttpSession userSession = request.getSession();
            UserBean user = (UserBean) userSession.getAttribute("user");
            

            //Either Username needs to be unchangeable, or this could find the user by the ID instead. 
            //Because if the user changes the username, we won't be able to find the newly created/updated user
            //to update the bean/session.
            //OR an easier idea, it could just log out, and redirect you to a "login" page and make you log back in.
            Customer customer = (Customer) customerFacade.findByUserName(user.getUserName());
            if (customer instanceof PayingMember) {
                PayingMember payingCustomer = (PayingMember) customer;

                payingCustomer.setFirstName(firstName);
                payingCustomer.setLastName(lastName);
                payingCustomer.setAddress(address);
                payingCustomer.setEmail(email);
                payingCustomer.setUserName(userName);
                payingCustomer.setPassword(password);
                payingCustomer.setMembershipFee(Double.parseDouble(membershipFee));
                payingCustomer.setMembershipPeriod(membershipPeriod);
                
            utx.begin();
            
            customerFacade.edit(payingCustomer);
            
            utx.commit();
            
            response.sendRedirect("index.jsp");
            }
            
            else if (customer instanceof RegisteredCustomer) {
                RegisteredCustomer nonpayingCustomer = (RegisteredCustomer) customer;
                
                
            utx.begin();
            
            customerFacade.remove(nonpayingCustomer);
            
            utx.commit();
            
                PayingMember payingCustomer = new PayingMember();
                payingCustomer.setFirstName(firstName);
                payingCustomer.setLastName(lastName);
                payingCustomer.setAddress(address);
                payingCustomer.setEmail(email);
                payingCustomer.setUserName(userName);
                payingCustomer.setPassword(password);
                payingCustomer.setMembershipFee(Double.parseDouble(membershipFee));
                payingCustomer.setMembershipPeriod(membershipPeriod);
            
            utx.begin();
            
            customerFacade.create(payingCustomer);
            
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
