
package WebServlet;

import Model.News.Blog;
import SessionBean.BlogFacade;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;


@WebServlet(name = "NewBlog", urlPatterns = {"/NewBlog"})
public class CreateBlog extends HttpServlet {
              
    @EJB
    private BlogFacade blogFacade;
    
    @Resource
    private UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
        try
        {
            String headline = request.getParameter("headline");
            String category = request.getParameter("category");
            String blogContent = request.getParameter("blogContent");
            
            Blog newBlog = new Blog();
            newBlog.setHeadline(headline);
            newBlog.setCategory(category);
            newBlog.setText(blogContent);
            newBlog.setCreationDate(new Date().toString());
            
            Date myDate = new Date();
            SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
            String mdy = mdyFormat.format(myDate);
            
            utx.begin();
            
            blogFacade.create(newBlog);
            
            request.getRequestDispatcher("/NewBlog.jsp").forward(request, response);
            
            utx.commit();
        }
        catch(Exception e)
        {
            
        }
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
    }
}
