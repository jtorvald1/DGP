
package JavaBean;

import java.util.ArrayList;

/**
 *
 * @author Nicole
 */

public class SearchBean {
    
    private String searchBy;
    private String searchFor;
    //private String result;
    private ArrayList<ProductBean> searchResult;
    
    public SearchBean() {    
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public String getSearchFor() {
        return searchFor;
    }

    public void setSearchFor(String searchFor) {
        this.searchFor = searchFor;
    }

    /*public String getResult() {
        return result;
    }*/

    /*public void setResult(String result) throws NoSuchMethodException, IllegalAccessException, 
            IllegalArgumentException, InvocationTargetException 
        {
        // create array list object       
        //ArrayList resultList = null;
        ProductsBean pb = new ProductsBean();
        ArrayList allProdsList = null;
        allProdsList.add(pb.getAllProducts());
               
        ArrayList<String> prodsList = new ArrayList<String>();
            
        for( Object object : allProdsList ) {
            prodsList.addAll(allProdsList);
        }
        
        List <String> resultList = new ArrayList<String>(); 
           for (String string : prodsList) {
               if(string.matches(searchFor)){
                   resultList.add(string);
               }
           }
           StringBuilder sb = new StringBuilder();
            for (String s : resultList)
            {
                sb.append(s);
                sb.append("\t");
            }
            this.result = sb.toString();
         }*/
                   
    public ArrayList<ProductBean> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(ArrayList<ProductBean> searchResult) {
        this.searchResult = searchResult;
    }
}
           
        

