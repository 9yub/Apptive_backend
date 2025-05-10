package com.example.apptive_3team;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pingPong {

    @GetMapping("/ping")
    public String pong() {
        return "pong";
    }
}
