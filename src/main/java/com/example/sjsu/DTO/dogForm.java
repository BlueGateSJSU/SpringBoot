package com.example.sjsu.DTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class dogForm {
    private String name;
    private Byte[] profile;

    //public dog toEntity(){ return new dog(name, profile); }
}//지워도되는거
