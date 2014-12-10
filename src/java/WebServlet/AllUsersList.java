/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServlet;

import JavaBean.UserBean;
import JavaBean.UsersBean;
import Model.Webshop.BeanGenerator;
import Model.Webshop.Customer;
import SessionBean.CustomerFacade;
import java.io.IOException;
import java.util.ArrayList;
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
            String userId = request.getParameter("user");
            if (userId == null) {
            
                List<Customer> allUsers = customerSessionFacade.findAll();
                UsersBean bean = BeanGenerator.getUsersBean(allUsers);
                sendData(bean, request, response);
            }
            
            else {
                Customer find = customerSessionFacade.find(userId);
                UserBean bean = BeanGenerator.getUserBean(find);
                RequestDispatcher dispatcher = request.getRequestDispatcher("memberInfo.jsp");
                request.setAttribute("user", bean);
                dispatcher.forward(request, response);
            }
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
