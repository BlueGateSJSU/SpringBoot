package com.example.sjsu.FastAPI;

import com.example.sjsu.DTO.dogForm;
import com.example.sjsu.Repository.dogRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Blob;
import java.util.List;

@Service
public class studyYolo {

    private dogRepository dogrepository;

    public studyYolo(dogRepository dogrepository){
        this.dogrepository = dogrepository;
    }

    public void study(List<Blob> img) {
        final String uri = "http://edu.sky100.kr:10200/items/4";
        RestTemplate restTemplate = new RestTemplate(); //REST API 호출 수행
        HttpHeaders headers = new HttpHeaders();    //요청 해더 정의
        HttpEntity<List<Blob>> requestEntity = new HttpEntity<>(img, headers);  //요청 본문 이미지, 해더 포함
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class); //Post API 요청

        if (responseEntity.getStatusCode().is2xxSuccessful()) {     //2xx 성공이면
            String response = responseEntity.getBody();
            System.out.println("학습 결과: " + response);
        } else {
            System.out.println("학습 실패: " + responseEntity.getStatusCodeValue());
        }
    }
    public void join(String name){

        dogrepository.save(name);

    }
}
