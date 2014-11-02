
package SessionBean;

import Model.Product;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public Collection<Product> findByBrand(String brand)
    {
        Query query = em.createNamedQuery("Product.findByBrand");
        query.setParameter("brand", brand);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
}
