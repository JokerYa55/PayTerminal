package app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author vasil
 */
@Entity
@Table(name = "t_user_attribute")
@Data
public class UserAttributeModel {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "attribute_name")
    String attrName;
    @Column(name = "attribute_value")
    String attrValue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserModel userId;

}
