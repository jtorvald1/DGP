/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.News;

import Model.RegisteredCustomer;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jacob Nørgaard
 */
@Entity(name = "ARTICLES")
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
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "CUSTOMER_ID")
    private RegisteredCustomer customer;
    
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

    public RegisteredCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(RegisteredCustomer customer) {
        this.customer = customer;
    }
    
}
