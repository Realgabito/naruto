package com.aluracursos.naruto.main;

import com.aluracursos.naruto.models.CharactersInfo;
import com.aluracursos.naruto.models.Clan;
import com.aluracursos.naruto.models.ClansInfo;
import com.aluracursos.naruto.models.Data;
import com.aluracursos.naruto.service.ConvertData;
import com.aluracursos.naruto.service.RequestAPI;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private Scanner userInput = new Scanner(System.in);
    private RequestAPI requestAPI = new RequestAPI();
    private final String characterURL = "https://dattebayo-api.onrender.com/characters";
    private final String clanURL = "https://dattebayo-api.onrender.com/clans";
    private ConvertData conversor = new ConvertData();
    

    public void showMenu() {
       
//        System.out.println(json);
//        var data = conversor.getData(json, Data.class);
//        System.out.println(data);


        int option = 0;
        while (option != 3) {
            
            System.out.println("""

                    -------------------------
                    ---- Choose an option ----
                    -------------------------
                    

                    1. Search for a character
                    2. Search for a clan
                    3. Exit
                    
                    """);


            
            option = userInput.nextInt();
            userInput.nextLine();

            if (option >= 1 && option <= 3) {
                        
                switch (option) {
                        case 1:
                            searchCharacter();
                            break;
                                            
                        case 2:
                            searchClan();
                            break;

                        case 3:
                            System.out.println("Goodbye!");
                            break; 
                        }
                    }
        }
                                                   
    }
                                                    
                                                    
    private void searchCharacter() {
                                
    //Ask user for a character name
    System.out.println("""

            -------------------------
            ---- Enter a character ----
            -------------------------

            """);
    var character = userInput.nextLine();

    //Realize a request to the API
    var json = RequestAPI.getData(characterURL);
                                
    //Search for the character replacing spaces with %20
    json = RequestAPI.getData(characterURL + "?name=" + character.replace(" ", "%20"));
    var searchCharacter = conversor.getData(json, Data.class);
    Optional<CharactersInfo> searchedCharacter = searchCharacter.characters().stream()
            .filter(c -> c.name().toUpperCase().contains(character.toUpperCase()))
            .findFirst();
                        
    if (searchedCharacter.isPresent()) {
        System.out.println("""

                -------------------------
                ---- Character Found! ----
                -------------------------

                """);
        System.out.println(searchedCharacter.get());
    } else {
        System.out.println("""
                -------------------------
                ---- No character found ----
                -------------------------
                """);
     }  
                                
                                
                                
}


    private void searchClan() {
        //Ask user for a clan name
        System.out.println("""

                -------------------------
                ---- Enter a clan ----
                -------------------------

                """);
        var clan = userInput.nextLine();

        //Realize a request to the API
        var json = RequestAPI.getData(clanURL);

        //Search for the clan 
        json = RequestAPI.getData(clanURL + "?name=" + clan);
        var searchClan = conversor.getData(json, Clan.class);
        Optional<ClansInfo> searchedClan = searchClan.clans().stream()
                .filter(c -> c.name().toUpperCase().contains(clan.toUpperCase()))
                .findFirst();

        //If the clan is found, print the information
        if (searchedClan.isPresent()) {
            System.out.println("""

                -------------------------
                ---- Clan found! ----
                -------------------------

                """);
            System.out.println(searchedClan.get());
        } else {
            System.out.println("""

                -------------------------
                ---- No clan found ----
                -------------------------

                """);
        }

    }
                        

}
