
package WebServlet;

import JavaBean.ProductBean;
import JavaBean.ProductsBean;
import Model.HelperClasses.Base64Encoder;
import Model.HelperClasses.JavaBeanGenerator;
import Model.Webshop.Product;
import SessionBean.ProductFacade;
import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Nicole
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

    @EJB
    private ProductFacade productSessionFacade;
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        
        try
        {
            String searchBy = request.getParameter("searchBy");
            String value = request.getParameter("value");
            
            Collection<Product> products = null;
            
            switch(searchBy) 
            {
                case "brand": products = productSessionFacade.findByBrand(value); break;
                case "color": products = productSessionFacade.findByColor(value); break;
                case "size": products = productSessionFacade.findBySize(value); break;
                //....
            }

            ProductsBean searchResult = JavaBeanGenerator.getProductsBean(products);           
            
            HttpSession session = request.getSession();
            session.setAttribute("productToShow", searchResult.getAllProducts().get(0));
            session.setAttribute("searchResult", searchResult);

            RequestDispatcher dispatcher = request.getRequestDispatcher("produkt.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
