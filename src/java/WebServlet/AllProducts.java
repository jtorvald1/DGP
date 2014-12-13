
package WebServlet;

import JavaBean.ProductBean;
import JavaBean.ProductsBean;
import Model.HelperClasses.Base64Encoder;
import Model.HelperClasses.JavaBeanGenerator;
import Model.Webshop.Product;
import SessionBean.ProductFacade;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "AllProducts", urlPatterns = {"/AllProducts"})
public class AllProducts extends HttpServlet {
    
    @EJB
    private ProductFacade productSessionFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            List<Product> allProducts = productSessionFacade.findAll();
            ProductsBean lastSearchedProducts = JavaBeanGenerator.getProductsBean(allProducts);

            HttpSession session = request.getSession();
            session.setAttribute("lastSearchedProducts", lastSearchedProducts);
            sendData(lastSearchedProducts, request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private void sendData(ProductsBean bean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("webshop.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
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
    }// </editor-fold>
}