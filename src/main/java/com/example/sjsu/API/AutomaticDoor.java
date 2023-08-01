package com.example.sjsu.API;

import com.example.sjsu.DTO.dogForm;
import com.example.sjsu.FastAPI.studyYolo;
//import com.example.sjsu.Repository.dogRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

@RequestMapping("/ai")
@RestController
public class AutomaticDoor {

    private studyYolo studyyolo;
    public AutomaticDoor(studyYolo studyyolo) {
        this.studyyolo = studyyolo;
    }

    @PostMapping(path = "/yolo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> studyyolo(
            @RequestPart("img") List<MultipartFile> img,
            @RequestPart("profile") MultipartFile profile,
            @RequestPart("name") String name) {

        // 비즈니스 로직을 처리
        byte[] Profile = convertToBytes(profile);
        studyyolo.join(name, Profile);

        return ResponseEntity.ok().body("학습성공!");
    }

    private byte[] convertToBytes(MultipartFile file) {
        try {
            return file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert MultipartFile to byte array: " + e.getMessage());
        }
    }

}
