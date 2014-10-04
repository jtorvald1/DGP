
package Model;

import Model.News.Article;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "REGISTERED_CUSTOMERS")
public class RegisteredCustomer extends Customer implements Serializable { 

    @OneToMany(mappedBy = "customer")
    private Article article;
    
    public RegisteredCustomer() {
    }
}
