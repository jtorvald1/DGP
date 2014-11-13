
package JavaBean;

public class BlogBean {
    
    private Long blogId; 
    private String headline;
    private String text;
    private String creation_date;
    private String category;

    public BlogBean() {
    }

    public BlogBean(Long blogId, String headline, String text, String creation_date, String category) {
        this.blogId= blogId;
        this.headline = headline;
        this.text= text;
        this.creation_date = creation_date;
        this.category = category;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long BlogId) {
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
