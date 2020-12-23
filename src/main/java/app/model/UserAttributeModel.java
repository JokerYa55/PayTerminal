package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author vasil
 */
@Data
public class UserAttributeModel implements Serializable {

    @JsonProperty("id")
    Long id;
    @JsonProperty("attr_name")
    String attrName;
    @JsonProperty("attr_value")
    String attrValue;
    @JsonProperty("user_id")
    private Long userId;

}
