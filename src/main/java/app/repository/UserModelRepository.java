package app.repository;

import app.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vasil
 */
@Repository
public interface UserModelRepository extends CrudRepository<UserModel, Long> {

}
