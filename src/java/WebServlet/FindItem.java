
package WebServlet;

import JavaBean.ProductBean;
import JavaBean.SearchBean;
import Model.Item;
import SessionBean.ItemFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FindItem", urlPatterns = {"/FindItem"})
public class FindItem extends HttpServlet {

    @EJB
    private ItemFacade itemFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            SearchBean searchbean = (SearchBean) request.getSession().getAttribute("bean");
            ProductBean productBean = searchbean.getSearchResult().get(0);

            Item item = (Item)itemFacade.findAvailable(productBean.getProductId());
            
            /*request.setAttribute("item", item);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddToCart");
            dispatcher.forward(request, response);*/
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
