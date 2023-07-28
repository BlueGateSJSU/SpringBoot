package com.example.sjsu.API;

import com.example.sjsu.FastAPI.applicationService;
import com.example.sjsu.FastAPI.studyYolo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app")
@RestController
@RequiredArgsConstructor
public class application {

    private applicationService applicationservice;

    public application(applicationService applicationservice) {
        this.applicationservice = applicationservice;
    }
    @GetMapping("alarm")
    public void al(){

    }

    @GetMapping("open")
    public void op(){

    }

    @GetMapping("close")
    public ResponseEntity<String> cl(@RequestParam Boolean Closebutton){

        applicationservice.closeAndOpen(Closebutton);

        if(Closebutton){
            return ResponseEntity.ok().body("문이 잠겼습니다.");
        }else{
            return ResponseEntity.ok().body("문이 열렸습니다.");
        }
    }
}
