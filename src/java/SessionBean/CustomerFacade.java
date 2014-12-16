/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean;

import Model.Webshop.Customer;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Torvald
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "DalsgaardPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
        public Object findForLogin(String email, String password)
    {
        Query query = em.createNamedQuery("Customer.findByPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);
        Object customer = query.getSingleResult();
        
        return customer;
    }
        
        public Object findByUserName(String username) {
            Query query = em.createNamedQuery("Customer.findByUserName");
            query.setParameter("username", username);
            Object user = query.getSingleResult();
            
            return user;
        }
        
        public Collection<Customer> findByPassword(String password)
        {
            Query query = em.createNamedQuery("Customer.findByPassword");
            query.setParameter("password", password);
            Collection<Customer> customers = query.getResultList();

            return customers;
        }
        
        public Collection<Customer> findByFirstName(String firstName)
        {
            Query query = em.createNamedQuery("Customer.findByFirstName");
            query.setParameter("firstName", firstName);
            Collection<Customer> customers = query.getResultList();

            return customers;
        }
        
        public Collection<Customer> findByLastName(String lastName)
        {
            Query query = em.createNamedQuery("Customer.findByLastName");
            query.setParameter("lastName", lastName);
            Collection<Customer> customers = query.getResultList();

            return customers;
        }
        
        public Collection<Customer> findByAddress(String address)
        {
            Query query = em.createNamedQuery("Customer.findByAddress");
            query.setParameter("address", address);
            Collection<Customer> customers = query.getResultList();

            return customers;
        }
        
        public Collection<Customer> findByEmail(String email)
        {
            Query query = em.createNamedQuery("Customer.findByEmail");
            query.setParameter("email", email);
            Collection<Customer> customers = query.getResultList();

            return customers;
        }
        
        public Collection<Customer> findByIsPayingMember(String isPayingMember)
        {
            Query query = em.createNamedQuery("Customer.findByIsPayingMember");
            query.setParameter("isPayingMember", isPayingMember);
            Collection<Customer> customers = query.getResultList();

            return customers;
        }
        
        public Collection<Customer> findAllUsers()
        {
        Query query = em.createNamedQuery("Customer.findAllUsers");
        Collection<Customer> users = query.getResultList();
        
        return users;
        }
}
