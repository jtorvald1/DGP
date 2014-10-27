
package SessionBean;

import Model.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductFacade extends AbstractFacade{
    
    @PersistenceContext(unitName = "DalsgaardPU")
    private EntityManager em;

    public ProductFacade() {
        super(Product.class);
    }
    
    public EntityManager getEntityManager()
    {
        return em;
    }
}
