
package Model.Webshop;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Jacob Nørgaard
 */
@Entity(name = "SHIPPINGS")
public class Shipping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shippingId;
    
    @Column(name = "SHIPPINGTYPE")
    private String shippingType;
    
    @Column(name = "SHIPPINGPRICE")
    private String shippingPrice;
    
    @OneToMany(mappedBy = "shipping", targetEntity = CustomerOrder.class, fetch = FetchType.EAGER)
    private Collection<CustomerOrder> orders;

    public Long getShippingId() {
        return shippingId;
    }

    public void setShippingId(Long shippingId) {
        this.shippingId = shippingId;
    }
}
