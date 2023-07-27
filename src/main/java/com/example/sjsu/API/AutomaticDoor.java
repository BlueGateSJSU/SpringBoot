package com.example.sjsu.API;

import com.example.sjsu.FastAPI.studyYolo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Blob;

@RequestMapping("/ai")
@RestController
@RequiredArgsConstructor
public class AutomaticDoor {
    private final studyYolo studyyolo;
    @GetMapping("yolo")
    public ResponseEntity<String> studyyolo (@RequestParam Blob img){

        studyyolo.study(img); //FestAPI로 넘기기

        return ResponseEntity.ok().body("학습성공!");
    }
}
