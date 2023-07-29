package com.example.sjsu.API;

import com.example.sjsu.socket.FaceRecognitionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class FaceRecognitionController {

    @Autowired
    private FaceRecognitionHandler faceRecognitionHandler;

    @PostMapping
    public String receiveNotification(@RequestBody String message){

        System.out.print("Received message" + message);

        faceRecognitionHandler.sendMessageToClients(message);
        
        return "Notification received";
    }
}
