
package Model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity(name = "SuperUser")
public class SuperUser extends Customer implements Serializable {
    
    public SuperUser()
    {
        
    }
}
