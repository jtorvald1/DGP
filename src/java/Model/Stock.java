
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
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
@Entity(name = "STOCKS")
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "STOCK_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stockId;
    
    @Column(name = "QUANTITY")
    private int quantity;
    
    @OneToMany(mappedBy = "stock", targetEntity = Item.class, fetch = FetchType.EAGER)
    private Collection<Item> items;
    
    public Stock() {
    }
}
