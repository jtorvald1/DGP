/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaBean;

import java.util.ArrayList;

public class ArticlesBean {
    
    private ArrayList<ArticleBean> allArticles = new ArrayList<ArticleBean>();
    

    public ArticlesBean() {
    }

    public ArrayList<ArticleBean> getArticles() {
        return allArticles;
    }

    public void setArticles(ArrayList<ArticleBean> allArticles) {
        this.allArticles= allArticles;
    }

    @Override
    public String toString() {
        return "ArticlesBean{" + "allArticles=" + allArticles + '}';
    }
}
