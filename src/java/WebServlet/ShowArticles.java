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
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ShowArticles", urlPatterns = {"/ShowArticles"})
public class ShowArticles extends HttpServlet {
    
    @EJB
    private ArticleFacade articleSessionFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            List<Article> allArticles = articleSessionFacade.findAll();
            ArticlesBean bean = getBean(allArticles);
            sendData(bean, request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        finally
        {

        }
    }
    
    private void sendData(ArticlesBean bean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("allArticles.jsp");
            request.setAttribute("result", bean);
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
