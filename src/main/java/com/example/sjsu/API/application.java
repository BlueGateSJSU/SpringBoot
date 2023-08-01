package com.example.sjsu.API;

import com.example.sjsu.FastAPI.applicationService;
import com.example.sjsu.FastAPI.studyYolo;
import com.example.sjsu.domain.dog;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/app")
@RestController
@RequiredArgsConstructor
public class application {

    private applicationService applicationservice;
    private FaceRecognitionController faceRecognitionController;
    public application(applicationService applicationservice, FaceRecognitionController faceRecognitionController) {
        this.applicationservice = applicationservice;
        this.faceRecognitionController = faceRecognitionController;
    }

    @GetMapping("main")
    public List<dog> mainpage(){
        List<dog> dogs = applicationservice.find();
        System.out.print(dogs);
        return dogs;
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
