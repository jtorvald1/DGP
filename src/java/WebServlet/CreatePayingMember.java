/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServlet;

import Model.Customer;
import Model.PayingMember;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "CreatePayingMember", urlPatterns = {"/CreatePayingMember"})
public class CreatePayingMember extends HttpServlet {
    
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
            String membershipPeriod = "03-10-2014";
            String membershipFee = "300";
            
            PayingMember payingCustomer = new PayingMember();
            payingCustomer.setFirstName(firstName);
            payingCustomer.setLastName(lastName);
            payingCustomer.setAddress(address);
            payingCustomer.setMembershipFee(Double.parseDouble(membershipFee));
            payingCustomer.setMembershipPeriod(membershipPeriod);
            
            utx.begin();
            
            em = emf.createEntityManager();
            em.persist(payingCustomer);
            
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
