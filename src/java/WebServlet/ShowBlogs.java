/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServlet;

import JavaBean.BlogBean;
import JavaBean.BlogsBean;
import Model.News.Blog;
import SessionBean.BlogFacade;
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
@WebServlet(name = "ShowBlogs", urlPatterns = {"/ShowBlogs"})
public class ShowBlogs extends HttpServlet {
    
    @EJB
    private BlogFacade blogSessionFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            List<Blog> allBlogs = blogSessionFacade.findAll();
            BlogsBean bean = getBean(allBlogs);
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
    
    private void sendData(BlogsBean bean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("allBlogs.jsp");
            request.setAttribute("result", bean);
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private BlogsBean getBean(Collection<Blog> getBlogs)
    {
        BlogsBean bean = new BlogsBean();
        
        for(Blog blog : getBlogs) {
  
            BlogBean blogBean = getBlogBean(blog);
            
            bean.getBlogs().add(blogBean);
        }
        
        return bean;
    }
    
    private BlogBean getBlogBean(Blog blog) {
        BlogBean blogBean = new BlogBean();
        blogBean.setHeadline(blog.getHeadline());
        blogBean.setText(blog.getText());
        blogBean.setCreationDate(blog.getCreationDate());
        blogBean.setCategory(blog.getCategory());
        
        return blogBean;  
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
