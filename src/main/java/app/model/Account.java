package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;

/**
 *
 * @author vasil
 */
@Entity
@Table(name = "t_account")
@Data
public class Account implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "account_num")
    @Min(value = 20, message = "Счет должен быть 20 символов")
    @Max(value = 20, message = "Счет должен быть 20 символов")
    @JsonProperty("account_number")
    String accountNum;
    
    

}
