/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Model.Webshop.CustomerOrder;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jacob Nørgaard
 */
@Stateless
public class CustomerOrderFacade extends AbstractFacade<CustomerOrder> {
    @PersistenceContext(unitName = "DalsgaardPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerOrderFacade() {
        super(CustomerOrder.class);
    }

    public Collection<CustomerOrder> findByCustomerId(Long customerId) {
        Query query = em.createNamedQuery("CustomerOrder.findByCustomerId");
        query.setParameter("customerId", customerId);
        List resultList = query.getResultList();
        
        return resultList;
    }

    public Collection<CustomerOrder> findByFirstName(String firstName) {
        Query query = em.createNamedQuery("CustomerOrder.findByFirstName");
        query.setParameter("firstName", firstName);
        List resultList = query.getResultList();
        
        return resultList;
    }

    public Collection<CustomerOrder> findByLastName(String lastName) {
        Query query = em.createNamedQuery("CustomerOrder.findByLastName");
        query.setParameter("lastName", lastName);
        List resultList = query.getResultList();
        
        return resultList;
    }
}
