package com.br.senai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.senai.entity.Carro;
import com.br.senai.service.CarroService;

@SpringBootApplication
public class Concessionaria2Application implements CommandLineRunner{

	@Autowired
	private CarroService carroService;
	
	public static void main(String[] args) {
		SpringApplication.run(Concessionaria2Application.class, args);
		
		
	
	}

	@Override
	public void run(String... args) throws Exception {
		Carro carro = new Carro();
		carro.setAno(2005);
		carro.setPlaca("kfgh-987");
		carroService.inserir(carro);
		
		carroService.removerPor(2);
		List<Carro> carros = carroService.listarTodos();
		mostrarLista(carros);
		
		System.out.println(carroService.buscarPor(3));
	}
	
	public void mostrarLista(List<Carro> carros) {
		for(Carro carro: carros) {
			System.out.println(carro);
			System.out.println("\n");
		}
	}
}
