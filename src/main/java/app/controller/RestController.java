package app.controller;

import app.repository.UserModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController {

    @Autowired
    UserModelRepository userRepository;
    
    @GetMapping(path = "/test")
    public String test() {
        userRepository.findAll();
        log.info("test");
        return "test";
    }
}
