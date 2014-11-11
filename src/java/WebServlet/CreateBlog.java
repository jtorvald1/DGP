
package WebServlet;

import Model.News.Blog;
import java.io.IOException;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Jacob Nørgaard
 */
@WebServlet(name = "CreateBlog", urlPatterns = {"/CreateBlog"})
public class CreateBlog extends HttpServlet {
              
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        EntityManager em = null;
        
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
            
            utx.begin();
            
            em = emf.createEntityManager();
            em.persist(newBlog);
            
            utx.commit();
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            em.close();
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
