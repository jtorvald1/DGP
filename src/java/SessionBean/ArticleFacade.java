/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean;

import Model.News.Article;
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
public class ArticleFacade extends AbstractFacade<Article> {
    @PersistenceContext(unitName = "DalsgaardPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }

    public Collection<Article> AllArticles()
    {
        Query query = em.createNamedQuery("Article.AllArticles");
        Collection<Article> articles = query.getResultList();
        
        return articles;
    }
    
    public Collection<Article> searchByCategory(String category)
    {
        Query query = em.createNamedQuery("Article.searchByCategory");
        query.setParameter("category", category);
        Collection<Article> articles = query.getResultList();
        
        return articles;
    }
}
