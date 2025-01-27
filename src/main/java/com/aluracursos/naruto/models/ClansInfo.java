package com.aluracursos.naruto.models;

import com.aluracursos.naruto.service.RequestAPI;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import java.util.stream.Collectors;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ClansInfo(
        @JsonAlias("id") Integer id,
        @JsonAlias("name") String name,
        @JsonAlias("characters") List<Integer> characters

        ) {

           

           

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(name).append("\n");
        stringBuilder.append("Characters: ").append(getCharacterNames()).append("\n");

        return stringBuilder.toString();
    }

    private String getCharacterNames() {
        return characters.stream()
                .map(this::getCharacterNameById)
                .collect(Collectors.joining(", "));
    }

    private String getCharacterNameById(Integer id) {
        try {
            String json = RequestAPI.getData("https://dattebayo-api.onrender.com/characters/" + id);
            ObjectMapper mapper = new ObjectMapper();
            CharactersInfo charactersInfo = mapper.readValue(json, CharactersInfo.class);
            return charactersInfo.name();
        } catch (IOException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }
}
