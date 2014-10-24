/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBean;

import java.util.ArrayList;

/**
 *
 * @author Nicole
 */

public class SearchBean {
    
    private String searchBy;
    private String searchFor;
    private String result;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
    }
                   
    public ArrayList<ProductBean> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(ArrayList<ProductBean> searchResult) {
        this.searchResult = searchResult;
    }
}
           
        

