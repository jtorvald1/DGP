/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean;

import Model.Webshop.PayingMember;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Torvald
 */
@Stateless
public class PayingMemberFacade extends AbstractFacade<PayingMember> {
    @PersistenceContext(unitName = "DalsgaardPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PayingMemberFacade() {
        super(PayingMember.class);
    }
    
        public Object findByPassword(String email, String password)
    {
        Query query = em.createNamedQuery("PayingMember.findByPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);
        Object member = query.getSingleResult();
        
        
        return member;
    }
    
}
