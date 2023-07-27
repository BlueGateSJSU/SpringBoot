package com.example.sjsu.API;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app")
@RestController
@RequiredArgsConstructor
public class application {
    @GetMapping("alarm")
    public void al(){

    }

    @GetMapping("open")
    public void op(){

    }

    @GetMapping("close")
    public void cl(@RequestParam Boolean Closebutton){

    }
}
