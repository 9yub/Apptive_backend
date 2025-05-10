package com.example.apptive_3team;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class pingController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }


}
