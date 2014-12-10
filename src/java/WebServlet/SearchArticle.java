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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "News", urlPatterns = {"/News"})
public class SearchArticle extends HttpServlet {
    
    @EJB
    private ArticleFacade articleFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            String category = request.getParameter("cat");
            if (category == null) {
                List<Article> allArticles = articleFacade.findAll();
                ArticlesBean bean = getBean(allArticles);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("news.jsp");
                request.setAttribute("result", bean);
                dispatcher.forward(request, response);
            }
            else {
            
            Collection<Article> articles = articleFacade.searchByCategory(category);
            
            ArticlesBean foundArticles = getBean(articles);
            request.setAttribute("result", foundArticles);
            RequestDispatcher dispatcher = request.getRequestDispatcher("news.jsp");
            dispatcher.forward(request, response);
            }
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
