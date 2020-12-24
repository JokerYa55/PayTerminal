package app.controller;

import app.dao.AccountDao;
import app.dao.UserModelDao;
import app.model.UserModel;
import app.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController {

    @Autowired
    UserModelDao userDao;

    @Autowired
    AccountDao accountDao;

    @Autowired
    AccountService accountService;

    @GetMapping(path = "/test")
    public String test() {
        log.info("test");
        UserModel user = userDao.add(new UserModel(null, "test", "test", "test"));
        log.info("res = {}", user);
        //userDao.delete(user);
        return "test";
    }

    @GetMapping(path = "/account/{account_num}")
    public String account(@PathVariable(name = "account_num") String accountNum) {
        return accountService.getAccountByNum(accountNum).toString();
    }
}
