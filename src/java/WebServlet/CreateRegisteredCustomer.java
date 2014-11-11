/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServlet;

import Model.PayingMember;
import Model.RegisteredCustomer;
import java.io.IOException;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
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
@WebServlet(name = "CreateRegisteredCustomer", urlPatterns = {"/CreateRegisteredCustomer"})
public class CreateRegisteredCustomer extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = null;
        
        try 
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            
            RegisteredCustomer nonpayingCustomer = new RegisteredCustomer();
            nonpayingCustomer.setFirstName(firstName);
            nonpayingCustomer.setLastName(lastName);
            nonpayingCustomer.setAddress(address);
            nonpayingCustomer.setEmail(email);
            nonpayingCustomer.setPassword(password);
            
            utx.begin();
            
            em = emf.createEntityManager();
            em.persist(nonpayingCustomer);
            
            utx.commit();
            
            /*List customers = em.createQuery("SELECT c FROM CUSTOMERS c").getResultList();
            System.out.println(customers.toString());*/
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            em.close();
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
