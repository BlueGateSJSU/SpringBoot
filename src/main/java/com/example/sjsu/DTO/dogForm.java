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
    private String name;
    private Blob profile;

    //public dog toEntity(){ return new dog(name, profile); }
}
