package com.aluracursos.naruto.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CharactersInfo(
        @JsonAlias("name") String name,
        @JsonAlias("id") String id,
        @JsonAlias("personal") Map<String, Object> personal,
        @JsonAlias("family") Map<String, String> family



        ) {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("ID: ").append(id).append("\n");

        //Accessing to "clan" information
//        sb.append("Clan: ").append(personal != null && personal.clan() != null ? personal.clan() : "Unknown").append("\n");
        String clan = personal != null ? (String) personal.getOrDefault("clan", "Unknown") : "Unknown";
        sb.append("Clan: ").append(clan).append("\n");

        if (family != null) {
            sb.append("Family: \n");
            sb.append("     Father: ").append(family.get("father")).append("\n");
            sb.append("     Mother: ").append(family.get("mother")).append("\n");
            sb.append("     Brother: ").append(family.getOrDefault("brother", "Unknown")).append("\n");
            sb.append("     Niece: ").append(family.getOrDefault("niece", "Unknown")).append("\n");
        }

        return sb.toString();
    }
}

