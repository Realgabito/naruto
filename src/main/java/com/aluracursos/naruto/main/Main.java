package com.aluracursos.naruto.main;

import com.aluracursos.naruto.models.Akatsuki;
import com.aluracursos.naruto.models.AkatsukiInfo;
import com.aluracursos.naruto.models.CharactersInfo;
import com.aluracursos.naruto.models.Clan;
import com.aluracursos.naruto.models.ClansInfo;
import com.aluracursos.naruto.models.Data;
import com.aluracursos.naruto.service.ConvertData;
import com.aluracursos.naruto.service.RequestAPI;


import java.util.Optional;
import java.util.Scanner;

public class Main {
    private Scanner userInput = new Scanner(System.in);
    
    private final String characterURL = "https://dattebayo-api.onrender.com/characters";
    private final String clanURL = "https://dattebayo-api.onrender.com/clans";
    private final String akatsukiURL = "https://dattebayo-api.onrender.com/akatsuki";
    private ConvertData conversor = new ConvertData();
    

    public void showMenu() {
       
//        System.out.println(json);
//        var data = conversor.getData(json, Data.class);
//        System.out.println(data);


        int option = 0;
        boolean continueMenu = true;

        while (continueMenu) {
            
            System.out.println("""

                    -------------------------
                    ---- Choose an option ----
                    -------------------------
                    

                    1. Search for a character
                    2. Search for a clan
                    3. List Akatsuki members
                    4. Exit
                    
                    """);


            
            option = userInput.nextInt();
            userInput.nextLine();

            if (option >= 1 && option <= 4) {
                        
                switch (option) {
                        case 1 -> searchCharacter();
                            
                                            
                        case 2 -> searchClan();
                            

                        case 3 -> listAkatsuki();
                        

                        case 4 ->{ 
                            System.out.println("""
                                
                                    ----------------------------------
                                    ---- Thanks for using the app! ----
                                    ------------------------------------4

                                    """);
                                continueMenu = false;
                                continue;
                            }

                        
                        default -> System.out.println("Invalid option");


                        }

                        if (option != 4) {
                            continueMenu = askToContinue(); //  Update the value of continueMenu
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

    private void listAkatsuki() {
        System.out.println("""

                -------------------------
                ---- Akatsuki Members ----
                -------------------------

                """);

        try {
            //Realize a request to the API
        var json = RequestAPI.getData(akatsukiURL);
        var  akatsuki = conversor.getData(json, Akatsuki.class);

        //Print the information of each member
        
        
        int count = 0;

       

        for (AkatsukiInfo member : akatsuki.akatsuki) {
            // Formatear cada celda
            System.out.printf("%-25s", member.member());
            count++;

            
            if (count % 5 == 0) {
                System.out.println(); 
            }
        }

       
        if (count % 5 != 0) {
            System.out.println();
        }

        System.out.println("\n" +"-------------------------------------------");


        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private boolean askToContinue() {
        System.out.println("""

                -------------------------
                ---- Do you want to continue? ----
                -------------------------
                1. Yes
                2. No

                """);

        int option = userInput.nextInt();
        userInput.nextLine();

        return option == 1;
    }
                        

}
