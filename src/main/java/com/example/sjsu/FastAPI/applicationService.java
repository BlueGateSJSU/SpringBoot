package com.example.sjsu.FastAPI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class applicationService {
    public void closeAndOpen(Boolean closeButton) {
        final String uri = "http://edu.sky100.kr:10200/items/4";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Boolean> requestEntity = new HttpEntity<>(closeButton, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String response = responseEntity.getBody();
            System.out.println("서버 응답: " + response);
        } else {
            System.out.println("통신 실패: " + responseEntity.getStatusCodeValue());
        }
    }
}
