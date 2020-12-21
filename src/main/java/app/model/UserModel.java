package app.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author vasil
 */
@Entity
@Table(name = "t_user")
@Data
public class UserModel {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "patronumic")
    String patrinumic;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", orphanRemoval = true, fetch = FetchType.EAGER)
    private Collection<UserAttributeModel> userAttributes;

}
