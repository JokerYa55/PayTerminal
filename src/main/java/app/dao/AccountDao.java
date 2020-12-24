package app.dao;

import app.model.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author vasil
 */
@Service
public class AccountDao implements DaoInterface<Account, Long> {

    private static final String GET_BY_ID_SQL_TEXT = "SELECT id, account_num, user_id, balance FROM public.t_account where id = ?";
    private static final String GET_BY_ACCOUNT_NUMBER_SQL_TEXT = "SELECT id, account_num, user_id, balance FROM public.t_account where account_num = ?";
    private static final String GET_LIST_SQL_TEXT = "select id, first_name, last_name, patronumic from t_user limit ? offset ?";
    private static final String GET_ALL_SQL_TEXT = "select id, first_name, last_name, patronumic from t_user order by id";
    private static final String UPDATE_SQL_TEXT = "update t_user set first_name = ?, last_name = ?, patronumic = ? where id = ?";
    private static final String DELETE_SQL_TEXT = "delete from t_user where id = ?";
    private static final String INSERT_SQL_TEXT = "insert into t_user(first_name, last_name, patronumic) values(?,?,?)";

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate template;

    public class AccountRowMapper implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet rs, int i) throws SQLException {
            return new Account(rs.getLong("id"), rs.getString("account_num"), rs.getLong("user_id"), rs.getBigDecimal("balance"));
        }
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.of(template.queryForObject(GET_BY_ID_SQL_TEXT, new Object[]{id}, new AccountRowMapper()));
    }

    public Optional<Account> findByAccountNumber(String accountNumber) {
        return Optional.of(template.queryForObject(GET_BY_ACCOUNT_NUMBER_SQL_TEXT, new Object[]{accountNumber}, new AccountRowMapper()));
    }
    
    @Override
    public List<Account> getItemList(long resCount, long skipCount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getAllList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account add(Account item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account update(Account item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Account item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void postConstruct() {
        template = new JdbcTemplate(dataSource);
    }

}
