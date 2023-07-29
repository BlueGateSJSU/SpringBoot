package com.example.sjsu.domain;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "sjsu")
@Entity
public class dog {
    @Id
    @Column(name = "dogid")
    private long dogid;
    @Column(length = 40, nullable = false)
    private String name;

    @Column
    @Lob
    private Blob profile;

    public void setName(String name){
        this.name = name;
    }

    public void setImg(Blob profile){
        this.profile = profile;
    }

    public dog(String name, Blob profile){
        this.name = name;
        this.profile = profile;
    }
}