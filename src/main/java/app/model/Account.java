package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;

/**
 *
 * @author vasil
 */
@Data
public class Account implements Serializable {

    private Long id;

    @Min(value = 20, message = "Счет должен быть 20 символов")
    @Max(value = 20, message = "Счет должен быть 20 символов")
    @JsonProperty("account_number")
    private String accountNum;
    @JsonProperty("user")
    private Long userId;
    @JsonProperty("balance")
    private BigDecimal balance = new BigDecimal(0);

}
