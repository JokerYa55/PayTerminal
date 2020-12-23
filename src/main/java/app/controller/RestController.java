package app.controller;

import app.dao.UserModelDao;
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
        log.info("res = {}",userDao.getItemList(2, 0));
        return "test";
    }
}
