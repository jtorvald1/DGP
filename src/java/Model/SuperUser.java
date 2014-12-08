
package Model.Webshop;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class SuperUser extends Customer implements Serializable {
    
    public SuperUser()
    {
        
    }
}
