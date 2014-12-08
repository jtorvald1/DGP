/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServlet;

import JavaBean.UserBean;
import Model.Webshop.Customer;
import SessionBean.CustomerFacade;
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
            
            Customer user = (Customer) customerFacade.findByPassword(email, password);
            UserBean userBean = getUserBean(user);
            
            if(user != null)
            {
                request.getSession().setAttribute("user", userBean);
                response.sendRedirect("index.jsp");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private UserBean getUserBean(Customer user) 
    {
        UserBean userBean = new UserBean();
        userBean.setUserId(user.getCustomerId());
        userBean.setFirstName(user.getFirstName());
        userBean.setlastName(user.getLastName());
        userBean.setUserName(user.getUserName());
        userBean.setEmail(user.getEmail());
        userBean.setAddress(user.getAddress());
        userBean.setOrders(user.getOrders());
        
        return userBean;  
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
