/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Model.Webshop.Product;
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
    
    public Collection<Product> findById(Long productId)
    {
        Query query = em.createNamedQuery("Product.findByProductId");
        query.setParameter("productId", productId);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
    
    public Collection<Product> findByCategory(String category)
    {
        Query query = em.createNamedQuery("Product.findByCategory");
        query.setParameter("category", category);
        Collection<Product> products = query.getResultList();
        
        return products;
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
        Query query = em.createNamedQuery("Product.findBySize");
        query.setParameter("size", size);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
    
    public Collection<Product> findByColor(String color)
    {
        Query query = em.createNamedQuery("Product.findByColor");
        query.setParameter("color", color);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
    
    public Collection<Product> findByPrice(double price)
    {
        Query query = em.createNamedQuery("Product.findByPrice");
        query.setParameter("price", price);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
     
    public Collection<Product> findByWeight(double weight)
    {
        Query query = em.createNamedQuery("Product.findByWeight");
        query.setParameter("weight", weight);
        Collection<Product> products = query.getResultList();
        
        return products;
    }
}
