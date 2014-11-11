/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.News;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jacob Nørgaard
 */
@Entity(name = "ARTICLES")
@NamedQueries({                                        
@NamedQuery(name = "Article.AllArticles", query = "SELECT a FROM ARTICLES a")
})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ARTICLE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long articleId;
    
    @Column(name = "HEADLINE")
    private String headline;
    
    @Column(name = "TEXT")
    private String text;
        
    @Column(name = "CREATION_DATE")
    private String creationDate;
            
    @Column(name = "CATEGORY")
    private String category;
    
    
    
    public Article() {
    }

    public Article(String headline, String text, String creationDate, String category) {
        this.headline = headline;
        this.text = text;
        this.creationDate = creationDate;
        this.category = category;
    }
    
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        return "Article{" + "articleId=" + articleId + ", headline=" + headline + ", text=" + text + ", creationDate=" + creationDate + ", category=" + category + '}';
    }
}