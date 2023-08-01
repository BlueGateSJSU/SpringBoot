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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dogid")
    private long dogid;
    @Column(length = 40, nullable = false)
    private String name;

    @Column
    @Lob
    private byte[] profile;

    public void setDogid(long dogid){
        this.dogid = dogid;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getDogid() {
        return dogid;
    }

    public void setImg(byte[] profile){
        this.profile = profile;
    }

    public dog(String name, byte[] profile){
        this.name = name;
        this.profile = profile;
    }

    public dog(){

    }

}
