package app.service;

import app.dao.AccountDao;
import app.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

/**
 *
 * @author vasil
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    CacheManager cacheManager;

    public Account getAccountByNum(String accountNum) {
        Cache cache = cacheManager.getCache("account");
        Cache.ValueWrapper valWripper = cache.get(accountNum);
        if (valWripper != null) {
            return (Account) valWripper.get();
        } else {
            // Получаем данные из БД
            Account account = accountDao.findByAccountNumber(accountNum).get();
            cache.put(account.getAccountNum(), account);
            return (Account) cache.get(accountNum).get();
        }
    }

}
