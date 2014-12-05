
package Model.Webshop;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "PAYING_MEMBERS")
@NamedQueries({
    @NamedQuery(name = "PayingMember.findByPassword", query = "SELECT u FROM PAYING_MEMBERS u WHERE u.email = :email AND u.password = :password")
})
public class PayingMember extends Customer implements Serializable {
    
    @Column(name = "MEMBERSHIP_PERIOD")
    private String membershipPeriod;
    
    @Column(name = "MEMBERSHIP_FEE")
    private double membershipFee;
    
    @OneToMany(mappedBy = "payingMember", targetEntity = Discount.class, fetch = FetchType.EAGER)
    private Collection<Discount> Discount;

    public PayingMember() {
    }

    public String getMembershipPeriod() {
        return membershipPeriod;
    }

    public void setMembershipPeriod(String membershipPeriod) {
        this.membershipPeriod = membershipPeriod;
    }

    public double getMembershipFee() {
        return membershipFee;
    }

    public void setMembershipFee(double membershipFee) {
        this.membershipFee = membershipFee;
    }

    public Collection<Discount> getDiscount() {
        return Discount;
    }

    public void setDiscount(Collection<Discount> Discount) {
        this.Discount = Discount;
    }
}