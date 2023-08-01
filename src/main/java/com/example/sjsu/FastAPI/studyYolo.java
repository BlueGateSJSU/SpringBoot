package com.example.sjsu.FastAPI;

import com.example.sjsu.Repository.dogRepository;
import com.example.sjsu.domain.dog;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class studyYolo {

    private dogRepository dogrepository;

    public studyYolo(dogRepository dogrepository){
        this.dogrepository = dogrepository;
    }

    public void study(String name, List<Byte[]> img) {
        final String uri = "http://edu.sky100.kr:10200/items/4";
        RestTemplate restTemplate = new RestTemplate(); //REST API 호출 수행
        HttpHeaders headers = new HttpHeaders();    //요청 해더 정의
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("name", name);
        body.add("img", img);

        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);  //요청 본문 이미지, 해더 포함
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class); //Post API 요청

        if (responseEntity.getStatusCode().is2xxSuccessful()) {     //2xx 성공이면
            String response = responseEntity.getBody();
            System.out.println("학습 결과: " + response);
        } else {
            System.out.println("학습 실패: " + responseEntity.getStatusCodeValue());
        }
    }
    public void join(String name, byte[] profile){
        dog dog1 = new dog(name, profile);
        dogrepository.save(dog1);
    }
}