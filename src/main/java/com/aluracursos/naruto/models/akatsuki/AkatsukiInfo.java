package com.aluracursos.naruto.models.akatsuki;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AkatsukiInfo(
        @JsonAlias("id")String id,
        @JsonAlias("name") String member
) {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(member).append("\n"); 
        
        
        return sb.toString();
    }
}
