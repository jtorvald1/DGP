
package Model.HelperClasses;

import JavaBean.ArticleBean;
import JavaBean.ArticlesBean;
import JavaBean.BlogBean;
import JavaBean.BlogsBean;
import JavaBean.ItemBean;
import JavaBean.ItemsBean;
import JavaBean.OrderBean;
import JavaBean.OrdersBean;
import JavaBean.ProductBean;
import JavaBean.ProductsBean;
import JavaBean.UserBean;
import JavaBean.UsersBean;
import Model.News.Article;
import Model.News.Blog;
import Model.Webshop.Customer;
import Model.Webshop.CustomerOrder;
import Model.Webshop.Item;
import Model.Webshop.Product;
import java.util.ArrayList;
import java.util.Collection;

public class JavaBeanGenerator {
    
    public static ProductsBean getProductsBean(Collection<Product> products)
    {
        ProductsBean bean = new ProductsBean();
        
        for(Product product : products) {          

            ProductBean productBean = getProductBean(product);
                        
            bean.getAllProducts().add(productBean);
        }
        
        return bean;
    }
    
    public static ProductBean getProductBean(Product product)
    {
        ProductBean productBean = new ProductBean();
        productBean.setProductId(product.getProductId());
        productBean.setDescription(product.getDescription());
        productBean.setSize(product.getSize());
        productBean.setWeight(product.getWeight());
        productBean.setBrand(product.getBrand());
        productBean.setCategory(product.getCategory());
        productBean.setPrice(product.getPrice());
        productBean.setColor(product.getColor());
        
        byte[] imageData = product.getImage().getContent();
        String imageDataString = Base64Encoder.getByteArrayString(imageData);
        
        productBean.setImage(imageDataString);
        
        return productBean;                
    }
        
    public static UsersBean getUsersBean(Collection<Customer> getUsers)
    {
        UsersBean bean = new UsersBean();
        
        for(Customer user : getUsers) {
  
            UserBean userBean = getUserBean(user);
            
            bean.getUsers().add(userBean);
        }
        
        return bean;
    }
    
    public static UserBean getUserBean(Customer user) {
        UserBean userBean = new UserBean();
        userBean.setUserId(user.getCustomerId());
        userBean.setPassword(user.getPassword());
        userBean.setFirstName(user.getFirstName());
        userBean.setlastName(user.getLastName());
        userBean.setUserName(user.getUserName());
        userBean.setEmail(user.getEmail());
        userBean.setAddress(user.getAddress());
        userBean.setIsPayingMember(user.getIsPayingMember());
        userBean.setOrders(user.getOrders());
        
        return userBean;  
    }  
    
    public static ArticlesBean getArticlesBean(Collection<Article> getArticles)
    {
        
        ArticlesBean bean = new ArticlesBean();
        
        for(Article article : getArticles) {
  
            ArticleBean articleBean = getArticleBean(article);
            
            bean.getArticles().add(articleBean);
        }
        
        return bean;
    }
    
    public static ArticleBean getArticleBean(Article article) {
        ArticleBean articleBean = new ArticleBean();
        articleBean.setHeadline(article.getHeadline());
        articleBean.setText(article.getText());
        articleBean.setCreationDate(article.getCreationDate());
        articleBean.setCategory(article.getCategory());
        
        return articleBean;  
    }
    
        
    public static BlogsBean getBlogsBean(Collection<Blog> getBlogs)
    {
        BlogsBean bean = new BlogsBean();
        
        for(Blog blog : getBlogs) {
  
            BlogBean blogBean = getBlogBean(blog);
            
            bean.getBlogs().add(blogBean);
        }
        
        return bean;
    }
    
    public static BlogBean getBlogBean(Blog blog) {
        BlogBean blogBean = new BlogBean();
        blogBean.setHeadline(blog.getHeadline());
        blogBean.setText(blog.getText());
        blogBean.setCreationDate(blog.getCreationDate());
        blogBean.setCategory(blog.getCategory());
        
        return blogBean;  
    }

    public static ItemsBean getItemsBeanByProjects(Collection<Product> products) 
    {
        ItemsBean itemsBean = new ItemsBean();
        
        for(Product product: products)
        {
            ArrayList<ItemBean> itemBeans = getItemBeansByProject(product);
            itemsBean.getItems().addAll(itemBeans);
        }
        return itemsBean;
    }

    private static ArrayList<ItemBean> getItemBeansByProject(Product product) 
    {
        Collection<Item> items = product.getItems();
        ArrayList<ItemBean> itemBeans = new ArrayList<>();
        
        for(Item item: items)
        {
            ItemBean itemBean = new ItemBean();
            itemBean.setItemId(item.getItemId());
            itemBean.setProductId(product.getProductId());
            itemBean.setStockId(new Long(1));
            if(item.getOrder() != null) 
                itemBean.setOrderId(item.getOrder().getOrderId());
            
            itemBeans.add(itemBean);
        }
        return itemBeans;
    }
    
    public static ItemsBean getItemsBeanByOrders(Collection<CustomerOrder> orders) 
    {
        ItemsBean itemsBean = new ItemsBean();
        
        for(CustomerOrder order: orders)
        {
            ArrayList<ItemBean> itemBeans = getItemBeansByOrder(order);
            itemsBean.getItems().addAll(itemBeans);
        }
        return itemsBean;
    }

    private static ArrayList<ItemBean> getItemBeansByOrder(CustomerOrder order) 
    {
        Collection<Item> items = order.getItems();
        ArrayList<ItemBean> itemBeans = new ArrayList<>();
        
        for(Item item: items)
        {
            ItemBean itemBean = new ItemBean();
            itemBean.setItemId(item.getItemId());
            itemBean.setProductId(item.getProduct().getProductId());
            itemBean.setStockId(new Long(1));
            itemBean.setOrderId(order.getOrderId());
            
            itemBeans.add(itemBean);
        }
        return itemBeans;
    }
    
    public static OrdersBean getOrdersBean(Collection<CustomerOrder> orders)
    {
        OrdersBean bean = new OrdersBean();
        
        for(CustomerOrder order : orders) {          

            OrderBean orderBean = getOrderBean(order);
                        
            bean.getOrders().add(orderBean);
        }
        return bean;
    }

    public static OrderBean getOrderBean(CustomerOrder order) 
    {
        OrderBean orderBean = new OrderBean();
        orderBean.setOrderId(order.getOrderId());
        orderBean.setOrderDate(order.getDateTime());
        orderBean.setCustomerId(order.getCustomer().getCustomerId());
        orderBean.setFirstName(order.getCustomer().getFirstName());
        orderBean.setLastName(order.getCustomer().getLastName());
        
        return orderBean;
    }
}
