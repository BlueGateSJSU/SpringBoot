package com.example.sjsu.DTO;

import com.example.sjsu.domain.dog;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.sql.Blob;
import java.util.List;

@Getter
@Setter
public class dogForm {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private List<Blob> img;

    public dog toEntity(){ return new dog(name, img); }
}
