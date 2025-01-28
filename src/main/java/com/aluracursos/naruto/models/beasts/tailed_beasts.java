package com.aluracursos.naruto.models.beasts;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record tailed_beasts(

        @JsonAlias("id") String id,
        @JsonAlias("name") String name

) {

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");

        return sb.toString();
    }
} 