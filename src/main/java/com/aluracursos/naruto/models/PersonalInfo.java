package com.aluracursos.naruto.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonalInfo(
        @JsonAlias("birthdate") String birthdate,
        @JsonAlias("sex") String sex,
        @JsonAlias("age") Map<String, String> age,
        @JsonAlias("height") Map<String, String> height,
        @JsonAlias("weight") Map<String, String> weight,
        @JsonAlias("bloodType") String bloodType,
        @JsonAlias("kekkeiGenkai") String[] kekkeiGenkai,
        @JsonAlias("classification") String[] classification,
        @JsonAlias("tailedBeast") String tailedBeast,
        @JsonAlias("occupation") String[] occupation,
        @JsonAlias("affiliation") String[] affiliation,
        @JsonAlias("team") String[] team,
        @JsonAlias("clan") String clan
) {
}