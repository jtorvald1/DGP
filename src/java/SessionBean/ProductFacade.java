/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Model.Product;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jacob Nørgaard
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {
    @PersistenceContext(unitName = "DalsgaardPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    public Collection<Product> findByBrand(String brand)
    {
        Query query = em.createNamedQuery("Product.findByBrand");
        query.setParameter("brand", brand);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
    
    public Collection<Product> findBySize(String size)
    {
        Query query = em.createNamedQuery("Product.findByBrand");
        query.setParameter("brand", size);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
    
    public Collection<Product> findByColor(String color)
    {
        Query query = em.createNamedQuery("Product.findByBrand");
        query.setParameter("brand", color);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
    
    public Collection<Product> findByBrandAndCategory(String brand, String category)
    {
        Query query = em.createNamedQuery("Product.findByBrand&Category");
        query.setParameter("category", category);
        query.setParameter("brand", brand);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
}
