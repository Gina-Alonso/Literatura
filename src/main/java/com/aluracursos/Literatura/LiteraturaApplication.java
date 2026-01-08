package com.aluracursos.Literatura;

import com.aluracursos.Literatura.principal.Principal;
import com.aluracursos.Literatura.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {
    @Autowired
    private LibroRepository libroRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}
    @Override
    public void run(String... args) throws Exception {
        Principal p = new Principal(libroRepository);
        p.menu();
    }
}
