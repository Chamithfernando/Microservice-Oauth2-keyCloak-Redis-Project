package redis.springboot.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private LocalDateTime tocreation;

    @Lob
    private String description;
    private Date date;
    private BigDecimal total;

    @OneToMany(mappedBy = "purchase",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Purchaseitem> purchaseitemList;


    public Purchase(Integer id) {
        this.id = id;
    }

    public Purchase(Integer id, String code, Date date) {
        this.id = id;
        this.code = code;
        this.date = date;

    }




}
