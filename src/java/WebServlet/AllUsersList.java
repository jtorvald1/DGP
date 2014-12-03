/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServlet;

import JavaBean.UserBean;
import JavaBean.UsersBean;
import Model.Customer;
import SessionBean.CustomerFacade;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "AllUsersList", urlPatterns = {"/AllUsersList"})
public class AllUsersList extends HttpServlet {
    
    @EJB
    private CustomerFacade customerSessionFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            List<Customer> allUsers = customerSessionFacade.findAll();
            UsersBean bean = getBean(allUsers);
            sendData(bean, request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        finally
        {

        }
    }
    
    private void sendData(UsersBean bean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("allUsers.jsp");
            request.setAttribute("result", bean);
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private UsersBean getBean(Collection<Customer> getUsers)
    {
        UsersBean bean = new UsersBean();
        
        for(Customer user : getUsers) {
  
            UserBean userBean = getUserBean(user);
            
            bean.getUsers().add(userBean);
        }
        
        return bean;
    }
    
    private UserBean getUserBean(Customer user) {
        UserBean userBean = new UserBean();
        userBean.setFirstName(user.getFirstName());
        userBean.setlastName(user.getLastName());
        userBean.setEmail(user.getEmail());
        
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
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
