package com.aluracursos.naruto.main;

import com.aluracursos.naruto.models.Clan;
import com.aluracursos.naruto.models.ClansInfo;
import com.aluracursos.naruto.service.ConvertData;
import com.aluracursos.naruto.service.RequestAPI;

import java.util.Optional;
import java.util.Scanner;

public class ClanMain {
    private Scanner userInput = new Scanner(System.in);
    private RequestAPI requestAPI = new RequestAPI();
    private final String URL = "https://dattebayo-api.onrender.com/clans";
    private ConvertData conversor = new ConvertData();

    public void searchClans() {

        var json = requestAPI.getData(URL);

        //Ask user for a Clan name
        System.out.println("Enter the clan that you want to search");
        var Clan = userInput.nextLine();

        json  = requestAPI.getData(URL + "?name=" + Clan);
        var searchClan = conversor.getData(json, com.aluracursos.naruto.models.Clan.class);
        Optional<ClansInfo> searchedClan = searchClan.clans().stream()
                .filter(c -> c.name().toUpperCase().contains(Clan.toUpperCase()))
                .findFirst();


        if (searchedClan.isPresent()) {
            System.out.println("Clan Found");
            System.out.println(searchedClan.get().name());
        } else  {
            System.out.println("We could not find the clan");
        }


    }
}
