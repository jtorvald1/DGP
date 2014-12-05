
package WebServlet;

import JavaBean.ProductBean;
import Model.Webshop.Product;
import SessionBean.ProductFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Nicole
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

    @EJB
    private ProductFacade productSessionFacade;
 
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        
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
                //case "brand&category": products = productSessionFacade.findByBrandAndCategory(searchBy, searchFor); break;
            }

            ArrayList<ProductBean> searchResult = getBeans(products);           
            
            request.setAttribute("searchResult", searchResult);
            request.getSession().setAttribute("searchResult", searchResult);

            RequestDispatcher dispatcher = request.getRequestDispatcher("Produkt.jsp");
            dispatcher.forward(request, response);
        }            
        catch(Exception ex)
            {
                System.out.println(ex);
            }     
    }
    
    private ArrayList<ProductBean> getBeans(Collection<Product> allProducts)
    {
        ArrayList<ProductBean> list = new ArrayList<>();
        
        for(Product product : allProducts) {
            
            ProductBean productBean = getProductBean(product);            
            list.add(productBean);
    }
        
        return list;
    }
    
    private ProductBean getProductBean(Product product)
    {
        ProductBean productBean = new ProductBean();
        productBean.setProductId(product.getProductId());
        productBean.setDescription(product.getDescription());
        productBean.setSize(product.getSize());
        productBean.setBrand(product.getBrand());
        productBean.setPrice(product.getPrice());
        productBean.setColor(product.getColor());
        
        return productBean;                
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
