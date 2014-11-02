
package JavaBean;

import java.util.ArrayList;

/**
 *
 * @author Nicole
 */

public class SearchBean {
    
    private String searchBy;
    private String searchFor;
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
                   
    public ArrayList<ProductBean> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(ArrayList<ProductBean> searchResult) {
        this.searchResult = searchResult;
    }

    @Override
    public String toString() {
        return "SearchBean{" + "searchBy=" + searchBy + ", searchFor=" + searchFor + ", searchResult=" + searchResult + '}';
    }
}
           
        

