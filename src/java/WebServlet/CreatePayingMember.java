
package WebServlet;

import Model.PayingMember;
import SessionBean.PayingMemberFacade;
import java.io.IOException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Jacob Nørgaard
 */
@WebServlet(name = "CreatePayingMember", urlPatterns = {"/CreatePayingMember"})
public class CreatePayingMember extends HttpServlet {
    
    @EJB
    private PayingMemberFacade payingMemberFacade;
    
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
            
            payingMemberFacade.create(payingCustomer);
            
            utx.commit();
            
            response.sendRedirect("index.jsp");
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
