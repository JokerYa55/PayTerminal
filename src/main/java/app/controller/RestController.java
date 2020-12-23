package app.controller;

import app.dao.UserModelDao;
import app.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController {

    @Autowired
    UserModelDao userDao;
    
    @GetMapping(path = "/test")
    public String test() {
        log.info("test");
        UserModel user = userDao.findById(1L).get();
        log.info("res = {}", user);
        userDao.delete(user);
        return "test";
    }
}
