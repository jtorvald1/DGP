/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean;

import Model.Webshop.RegisteredCustomer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Torvald
 */
@Stateless
public class RegisteredCustomerFacade extends AbstractFacade<RegisteredCustomer> {
    @PersistenceContext(unitName = "DalsgaardPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegisteredCustomerFacade() {
        super(RegisteredCustomer.class);
    }
    
}
