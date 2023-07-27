package com.example.sjsu.FastAPI;

import org.springframework.web.client.RestTemplate;

import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

public class studyYolo {
    /*private BoardRepository boardRepository;
    public MovieRecommender(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }*/

    public String study(Blob img) {
        final String uri = "http://127.0.0.1:5000/"; // FastAPI 서버의 URL
        /*RestTemplate restTemplate = new RestTemplate();


        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        String result = restTemplate.postForObject(uri, params, String.class);
        String decodedResult = StringEscapeUtils.unescapeJava(result);

        System.out.println("MovieId: " + decodedResult);
        return decodedResult;*/
    }

}
