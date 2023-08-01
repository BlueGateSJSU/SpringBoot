package com.example.sjsu.DTO;

import com.example.sjsu.domain.dog;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class dogForm {
    private String name;
    private byte[] profile;

    private List<byte[]> img;

    public String getName() {
        return name;
    }

    public byte[] getProfile() {
        return profile;
    }

    public List<byte[]> getImg() {
        return img;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(List<byte[]> img) {
        this.img = img;
    }

    public dog toEntity(){ return new dog(name, profile); }
}//지워도되는거
