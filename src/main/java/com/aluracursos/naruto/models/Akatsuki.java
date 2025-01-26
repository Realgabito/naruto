package com.aluracursos.naruto.models;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Akatsuki {
    @JsonAlias("akatsuki")
    public List<AkatsukiInfo> akatsuki;

  
}
