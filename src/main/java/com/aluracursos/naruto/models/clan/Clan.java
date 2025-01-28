package com.aluracursos.naruto.models.clan;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Clan(
        @JsonAlias("clans") List<ClansInfo> clans
) {

    public static CharSequence toUpperCase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUpperCase'");
    }
}
