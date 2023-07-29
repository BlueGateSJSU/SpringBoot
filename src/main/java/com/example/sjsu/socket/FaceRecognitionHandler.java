package com.example.sjsu.socket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class FaceRecognitionHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 얼굴 인식 결과를 클라이언트에게 전달
        // message.getPayload()를 통해 얼굴 인식 결과 데이터를 가져올 수 있습니다.
        // 예를 들어, "{ "result": "detected" }" 형식으로 전달한다고 가정합니다.
        String faceRecognitionResult = "{ \"result\": \"detected\" }";
        session.sendMessage(new TextMessage(faceRecognitionResult));
    }
}
