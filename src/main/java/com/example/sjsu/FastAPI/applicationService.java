package com.example.sjsu.FastAPI;

import com.example.sjsu.Repository.dogRepository;
import com.example.sjsu.domain.dog;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class applicationService {

    private dogRepository dogRepository;

    public applicationService(dogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<dog> find(){
        return dogRepository.findAll();
    }

    public void closeAndOpen(Boolean closeButton) {
        final String uri = "http://edu.sky100.kr:10200/items/4";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Boolean> requestEntity = new HttpEntity<>(closeButton, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String response = responseEntity.getBody();
            System.out.println("서버 응답: " + response);
        } else {
            System.out.println("통신 실패: " + responseEntity.getStatusCodeValue());
        }
    }
}
