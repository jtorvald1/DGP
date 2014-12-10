
package WebServlet;

import Model.News.Article;
import SessionBean.ArticleFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "NewArticle", urlPatterns = {"/NewArticle"})
public class CreateArticle extends HttpServlet {
              
    @EJB
    private ArticleFacade articleFacade;
    
    @Resource
    private UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        try
        {
            String headline = request.getParameter("headline");
            String category = request.getParameter("category");
            String articleContent = request.getParameter("articleContent");
            
            Date myDate = new Date();
            SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
            String mdy = mdyFormat.format(myDate);
            
            Article newArticle = new Article();
            newArticle.setHeadline(headline);
            newArticle.setCategory(category);
            newArticle.setText(articleContent);
            newArticle.setCreationDate(mdy);
            
            utx.begin();
            
            articleFacade.create(newArticle);
            
            request.getRequestDispatcher("/NewArticle.jsp").forward(request, response);
            
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
