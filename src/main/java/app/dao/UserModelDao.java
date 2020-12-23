package app.dao;

import app.model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author vasil
 */
@Service
@Slf4j
public class UserModelDao implements DaoInterface<UserModel, Long> {

    private static final String GET_BY_ID_SQL_TEXT = "select id, first_name, last_name, patronumic from t_user where id = ?";
    private static final String GET_LIST_SQL_TEXT = "select id, first_name, last_name, patronumic from t_user limit ? offset ?";
    private static final String GET_ALL_SQL_TEXT = "select id, first_name, last_name, patronumic from t_user order by id";
    private static final String UPDATE_SQL_TEXT = "";
    private static final String DELETE_SQL_TEXT = "delete from t_user where id = ?";

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate template;

    public class UserModelRowMapper implements RowMapper<UserModel> {
        @Override
        public UserModel mapRow(ResultSet rs, int i) throws SQLException {
            return new UserModel(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("patronumic"));
        }
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return Optional.of(template.queryForObject(GET_BY_ID_SQL_TEXT, new Object[]{id}, new UserModelRowMapper()));
    }

    @Override
    public List<UserModel> getItemList(long resCount, long skipCount) {
        return template.query(GET_LIST_SQL_TEXT, new Object[]{resCount, skipCount}, new UserModelRowMapper());
    }

    @Override
    public List<UserModel> getAllList() {
        return template.query(GET_ALL_SQL_TEXT, new UserModelRowMapper());
    }

    @Override
    public UserModel update(UserModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(UserModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void postConstruct() {
        template = new JdbcTemplate(dataSource);
    }

}
