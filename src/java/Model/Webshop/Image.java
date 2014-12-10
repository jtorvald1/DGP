
package Model.Webshop;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity(name = "IMAGES")
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM IMAGES i")
})
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IMAGE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    
    @OneToOne(mappedBy = "image")
    @JoinColumn(name = "IMAGE_ID")
    private Product product;

    @Column(name = "FILE_NAME")
    private String fileName;
    
    @Lob
    @Column(name = "CONTENT")
    private byte[] content;

    public Image() {
    }

    public Image(Product product, String fileName, byte[] content) {
        this.product = product;
        this.fileName = fileName;
        this.content = content;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Image{" + "imageId=" + imageId + ", product=" + product + ", fileName=" + fileName + ", content=" + content + '}';
    }
}