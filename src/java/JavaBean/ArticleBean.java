
package JavaBean;

import java.util.ArrayList;

public class ArticleBean {
    
    private Long ArticleId; 
    private String headline;
    private String text;
    private String creation_date;
    private String category;
    private ArrayList<ArticleBean> searchResult;
    private String searchCategory;

    public ArticleBean() {
    }

    public ArticleBean(Long ArticleId, String headline, String text, String creation_date, String category) {
        this.ArticleId= ArticleId;
        this.headline = headline;
        this.text= text;
        this.creation_date = creation_date;
        this.category = category;
    }

    public Long getArticleId() {
        return ArticleId;
    }

    public void setArticleId(Long ArticleId) {
        this.ArticleId = ArticleId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreationDate() {
        return creation_date;
    }

    public void setCreationDate(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}