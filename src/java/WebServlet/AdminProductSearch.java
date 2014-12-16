
package WebServlet;

import JavaBean.ItemsBean;
import JavaBean.ProductsBean;
import Model.HelperClasses.JavaBeanGenerator;
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

@WebServlet(name = "AdminProductSearch", urlPatterns = {"/AdminProductSearch"})
public class AdminProductSearch extends HttpServlet {

    @EJB
    private ProductFacade productFacade;
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try
        {
            String searchBy = request.getParameter("searchBy");
            String value = request.getParameter("value");
            
            Collection<Product> products;
            
            switch(searchBy)
            {
                case "productId": 
                    Product product = productFacade.find(Long.parseLong(value));
                    products = addToList(product, request); break;
                case "category": products = productFacade.findByCategory(value); break;
                case "brand": products = productFacade.findByBrand(value); break;
                case "color": products = productFacade.findByColor(value); break;
                case "size": products = productFacade.findBySize(value); break;
                case "price": products = productFacade.findByPrice(Double.parseDouble(value)); break;
                case "weight": products = productFacade.findByWeight(Double.parseDouble(value)); break;
                default: products = productFacade.findAll(); break;
            }

            ProductsBean productsBean = JavaBeanGenerator.getProductsBean(products);
            ItemsBean itemsBean = JavaBeanGenerator.getItemsBeanByProjects(products);

            request.setAttribute("products", productsBean);
            request.setAttribute("items", itemsBean);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminProducts.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private ArrayList<Product> addToList(Product product, HttpServletRequest request) 
    {
        ArrayList<Product> products = new ArrayList<>();
        if(product != null) {
            products.add(product);
            request.setAttribute("lastSearchedProduct", JavaBeanGenerator.getProductBean(product)); 
        }
             
        
        return products;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
