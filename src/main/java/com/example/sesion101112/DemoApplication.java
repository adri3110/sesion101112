package com.example.sesion101112;

import com.example.sesion101112.entities.Laptop;
import com.example.sesion101112.repository.LaptopRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	/*
		Logger log = LoggerFactory.getLogger(DemoApplication.class);
		SpringApplication.run(DemoApplication.class, args);
		log.info("PROGRAMA INICIALIZADO ... EJECUTANDO MAIN ...");
	*/

		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(1L, "Asus","Intel core i7", 16, 1024);
		Laptop laptop2 = new Laptop(2L, "Hp","Intel core i5", 12, 512);
		Laptop laptop3 = new Laptop(3L, "Acer","Intel core i3", 8, 256);

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);

		System.out.println("Ejecutando aplicación");

	}
}
