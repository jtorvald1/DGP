/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServlet;

import JavaBean.ArticleBean;
import JavaBean.ArticlesBean;
import Model.News.Article;
import SessionBean.ArticleFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchArticle", urlPatterns = {"/SearchArticle"})
public class SearchArticle extends HttpServlet {
    
    @EJB
    private ArticleFacade articleFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            String category = request.getParameter("cat");
            Collection<Article> articles = articleFacade.searchByCategory(category);
            
            
            ArticlesBean foundArticles = getBean(articles);
            request.setAttribute("foundArticles", foundArticles);
            RequestDispatcher dispatcher = request.getRequestDispatcher("searchArticle.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            
        }        
    }
    
        private ArticlesBean getBean(Collection<Article> getArticles)
    {
        ArticlesBean bean = new ArticlesBean();
        
        for(Article article : getArticles) {
  
            ArticleBean articleBean = getArticleBean(article);
            
            bean.getArticles().add(articleBean);
        }
        
        return bean;
    }
    
    private ArticleBean getArticleBean(Article article) {
        ArticleBean articleBean = new ArticleBean();
        articleBean.setHeadline(article.getHeadline());
        articleBean.setText(article.getText());
        articleBean.setCreationDate(article.getCreationDate());
        articleBean.setCategory(article.getCategory());
        
        return articleBean;  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
