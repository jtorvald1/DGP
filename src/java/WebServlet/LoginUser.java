/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServlet;

import Model.Customer;
import Model.PayingMember;
import Model.RegisteredCustomer;
import SessionBean.CustomerFacade;
import SessionBean.PayingMemberFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Torvald
 */


@WebServlet(name = "LoginUser", urlPatterns = {"/LoginUser"})
public class LoginUser extends HttpServlet {
    
    @EJB
    private CustomerFacade customerFacade;
    
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {  
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            

            Object user = customerFacade.findByPassword(email, password);
            
            if(user != null)
            {
                request.getSession().setAttribute("user", user);
                Customer member1 = (Customer)request.getSession().getAttribute("user");
                System.out.println(member1.getFirstName());
            }
            
            /*RequestDispatcher dispatcher = request.getRequestDispatcher("???");
            dispatcher.forward(request, response);
            */
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        finally
        {

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
