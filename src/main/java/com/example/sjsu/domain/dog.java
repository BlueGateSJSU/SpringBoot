package com.example.sjsu.domain;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class dog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dogid_generator")
    @SequenceGenerator(name = "dogid_generator", sequenceName = "dogid_seq", initialValue = 1)
    @Column(name = "dogid")
    private long dogid;
    @Column(length = 40, nullable = false)
    private String name;

    private List<Blob> img;

    public void setName(String name){
        this.name = name;
    }

    public void setImg(List<Blob> img){
        this.img = img;
    }

    public dog(String name, List<Blob> img){
        this.name = name;
        this.img = img;
    }
}
