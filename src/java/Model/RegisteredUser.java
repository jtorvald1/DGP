
package Model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "REGISTERED_CUSTOMERS")
public class RegisteredUser extends Customer implements Serializable { 

    public RegisteredUser() {
    }
}
