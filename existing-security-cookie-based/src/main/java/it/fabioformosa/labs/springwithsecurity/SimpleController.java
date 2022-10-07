package it.fabioformosa.labs.springwithsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ping")
public class SimpleController {

    @GetMapping
    public String ping(){
        log.debug("ping...");
        return "pong";
    }

}
