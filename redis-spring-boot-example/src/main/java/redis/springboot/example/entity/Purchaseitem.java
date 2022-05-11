package redis.springboot.example.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchaseitem implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    private Integer qty;
    private BigDecimal unitprice;

    @ManyToOne
    private Item item;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Purchase purchase;

    public Purchaseitem(Integer id) {
        this.id = id;
    }
}
