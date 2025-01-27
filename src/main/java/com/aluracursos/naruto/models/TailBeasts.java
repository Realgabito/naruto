package com.aluracursos.naruto.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TailBeasts {
     @JsonAlias("tailed-beasts") public List<tailed_beasts> listTailedBeast;
}