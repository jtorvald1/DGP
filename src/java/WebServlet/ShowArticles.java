/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServlet;

import JavaBean.ArticleBean;
import JavaBean.ProductBean;
import JavaBean.ProductsBean;
import Model.News.Article;
import Model.Product;
import SessionBean.ProductFacade;
import javax.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author User
 */
@WebServlet(name = "ShowArticles", urlPatterns = {"/ShowArticles"})
public class ShowArticles extends HttpServlet {
    

      
    private void doPost(ArticleBean bean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AllArticles.jsp");
            request.setAttribute("result", bean);
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Search</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Search at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    
    private ArticleBean getBeans(Collection<Article> allArticles)
    {
        ArticleBean bean = new ArticleBean();
        
        for(Article article : allArticles) {

            ArticleBean articleBean = getArticleBean(article);
            
            bean.getAllArticles().add(articleBean);
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
