package com.aluracursos.naruto;


import com.aluracursos.naruto.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NarutoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NarutoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.showMenu();

//		ClanMain clanMain = new ClanMain();
//		clanMain.searchClans();
	}
}

