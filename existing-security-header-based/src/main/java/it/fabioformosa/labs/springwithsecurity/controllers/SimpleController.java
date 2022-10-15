package it.fabioformosa.labs.springwithsecurity.controllers;

import it.fabioformosa.quartzmanager.api.security.properties.InMemoryAccountProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ping")
public class SimpleController {

    @Autowired
    private InMemoryAccountProperties inMemoryAccountProperties;

    @GetMapping
    public String ping(){
        log.debug("ping...");
        return "pong";
    }

}
