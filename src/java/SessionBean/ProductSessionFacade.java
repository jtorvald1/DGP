
package SessionBean;

import Model.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductSessionFacade extends AbstractSessionFacade{
    
    @PersistenceContext(unitName = "DalsgaardPU")
    private EntityManager em;

    public ProductSessionFacade() {
        super(Product.class);
    }
    
    public EntityManager getEntityManager()
    {
        return em;
    }
}
