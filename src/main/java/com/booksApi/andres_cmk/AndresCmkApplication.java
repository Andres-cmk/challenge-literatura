package com.booksApi.andres_cmk;

import com.booksApi.andres_cmk.principal.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class AndresCmkApplication{

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(AndresCmkApplication.class, args);
		Main main = context.getBean(Main.class); // Obtén la instancia de Main gestionada por Spring
		main.execute();
	}



}
