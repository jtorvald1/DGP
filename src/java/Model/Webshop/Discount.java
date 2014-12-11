
package Model.Webshop;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "DISCOUNTS")
public class Discount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long discountId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "DISCOUNT_ID")
    private PayingMember payingMember;
    
    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }    
}