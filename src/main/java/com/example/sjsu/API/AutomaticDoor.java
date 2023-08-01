package com.example.sjsu.API;

import com.example.sjsu.FastAPI.studyYolo;
//import com.example.sjsu.Repository.dogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Blob;
import java.util.List;

@RequestMapping("/ai")
@RestController
public class AutomaticDoor {

    private studyYolo studyyolo;
    public AutomaticDoor(studyYolo studyyolo) {
        this.studyyolo = studyyolo;
    }

    @GetMapping("yolo")
    public ResponseEntity<String> studyyolo(@RequestParam List<Byte[]> img,
                                            @RequestParam Byte[] profile,
                                            @RequestParam String name){

        studyyolo.join(name ,profile);
        studyyolo.study(name, img); //FastAPI로 넘기기

        return ResponseEntity.ok().body("학습성공!");
    }
}
