package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author vasil
 */
@Getter
@AllArgsConstructor
@ToString
@Slf4j
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

    /**
     *
     * @param operType
     * @param sum
     */
    public synchronized void ubpBalance(BalanceOperType operType, BigDecimal sum) {
        switch (operType) {
            case DECREACE:
                log.info("Уменьшение баланса");
                balance = balance.subtract(sum);
                break;
            case INCREASE:
                log.info("Увеличение баланса");
                balance.add(sum);
                break;
        }

    }
}
