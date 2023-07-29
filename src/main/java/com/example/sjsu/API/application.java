package com.example.sjsu.API;

import com.example.sjsu.FastAPI.applicationService;
import com.example.sjsu.FastAPI.studyYolo;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

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

    /*  @PostMapping("/face_recognition_result")
    public ResponseEntity<String> uodateFaceFecognitionResult(@RequestBody boolean faceDetected){
        faceRecognitionController.sendStatusUpdate(faceDetected);

        if(faceDetected){
            return ResponseEntity.ok().body("");
        }else{
            return ResponseEntity.ok().body("");
        }
    }*/
    @GetMapping("alarm")
    public void al(){
        // 얼굴 인식을 요청하고 결과를 Front End에 전송하는 로직을 작성합니다.
        // 얼굴 인식 결과를 WebSocket을 통해 Front End로 보냅니다.
        // FaceRecognitionHandler 클래스에서 WebSocket으로 처리될 것입니다.
        // (FaceRecognitionHandler 클래스의 handleTextMessage() 메서드를 참고)
    }

    @GetMapping("open")
    public void op(){
        // 문을 열도록 요청하는 로직을 작성합니다.
        // 여기서는 얼굴 인식이 성공했다고 가정하고, Front End로 "문을 열어주세요" 메시지를 보냅니다.
        // 마찬가지로 WebSocket을 통해 전송합니다.
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
