
package Model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "REGISTERED_CUSTOMERS")
public class RegisteredCustomer extends Customer implements Serializable { 
    
    public RegisteredCustomer() {
    }
}
