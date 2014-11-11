/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.News;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author User
 */
@Entity(name = "BLOGS")
@NamedQueries({                                        
@NamedQuery(name = "Blog.AllBlogs", query = "SELECT b FROM BLOGS b")
})
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BLOG_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long blogId;
    
    @Column(name = "HEADLINE")
    private String headline;
    
    @Column(name = "TEXT")
    private String text;
        
    @Column(name = "CREATION_DATE")
    private String creationDate;
            
    @Column(name = "CATEGORY")
    private String category;
    
    
    
    public Blog() {
    }

    public Blog(String headline, String text, String creationDate, String category) {
        this.headline = headline;
        this.text = text;
        this.creationDate = creationDate;
        this.category = category;
    }
    
    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
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
        return "Blog{" + "blogId=" + blogId + ", headline=" + headline + ", text=" + text + ", creationDate=" + creationDate + ", category=" + category + '}';
    }
}
