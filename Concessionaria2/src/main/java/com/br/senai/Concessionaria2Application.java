package com.br.senai;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
	private Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(Concessionaria2Application.class, args);
		
		
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		int opcaoMenu = 0;
		try {
			do {
				System.out.println("Escolha uma opção \n"
						+ "1 - Cadastrar \n"
						+ "2 - Remover \n"
						+ "3 - Alterar \n"
						+ "4 - Listar \n"
						+ "5 - Consultar carro \n"
						+ "6 - Sair");
				
				opcaoMenu = scanner.nextInt();
				
				switch (opcaoMenu) {
				case 1:
					cadastrar(new Carro());
					break;
				case 2:
					remover();
					break;
				case 3:
					alterar();
					break;
				case 4:
					listar();
					break;
				case 5:
					consultarCarro();
					break;
				case 6:
					System.out.println("Saindo");
					break;
				default:
					System.out.println("Opção inválida");
				}
			} while (opcaoMenu != 6);
			
		}catch(InputMismatchException e) {
			System.out.println("O valor do campo de ser um número inteiro");
		}
		
	}
	
	public void cadastrar(Carro carro) {
        System.out.println("Digite o Ano do carro:");
        carro.setAno(scanner.nextInt());
        
        System.out.println("Digite a Cor do carro:");
        carro.setCor(scanner.next());
        
        System.out.println("Digite a Kilometragem do carro:");
        carro.setQuilometragem(scanner.nextInt());
        
        System.out.println("Digite o Estado do carro:");
        carro.setEstado(scanner.next());
        
        System.out.println("Digite a Marca do carro:");
        carro.setMarca(scanner.next());
        
        System.out.println("Digite o Modelo do carro:");
        carro.setModelo(scanner.next());
        
        System.out.println("Digite a Placa do carro:");
        carro.setPlaca(scanner.next());
        
        System.out.println("Digite o Preço do carro:");
        carro.setPreco(scanner.nextDouble());
        
        carroService.inserir(carro);
		System.out.println("Carro adicionado");
		System.out.println(carro);

	}
	
	public void remover() {
		System.out.println("Qual carro você quer remover?");
		mostrarLista(carroService.listarTodos());
		int idCarro = scanner.nextInt();
		carroService.removerPor(idCarro);
		System.out.println("Carro removido");
	}
	
	public void alterar() {
		System.out.println("Qual carro você quer alterar?");
		mostrarLista(carroService.listarTodos());
		
		int idCarro = scanner.nextInt();
		Carro carroAlteracao = carroService.buscarPor(idCarro);
		
        System.out.println("Digite o Ano do carro Atual: "+ carroAlteracao.getAno());
        carroAlteracao.setAno(scanner.nextInt());
        
        System.out.println("Digite a Cor do carro Atual: "+carroAlteracao.getCor());
        carroAlteracao.setCor(scanner.next());
        
        System.out.println("Digite a Kilometragem do carro Atual: "+carroAlteracao.getQuilometragem());
        carroAlteracao.setQuilometragem(scanner.nextInt());
        
        System.out.println("Digite o Estado do carro Atual: "+carroAlteracao.getEstado());
        carroAlteracao.setEstado(scanner.next());
        
        System.out.println("Digite a Marca do carro Atual: "+carroAlteracao.getMarca());
        carroAlteracao.setMarca(scanner.next());
        
        System.out.println("Digite o Modelo do carro Atual: "+carroAlteracao.getModelo());
        carroAlteracao.setModelo(scanner.next());
        
        System.out.println("Digite a Placa do carro Atual: "+carroAlteracao.getPlaca());
        carroAlteracao.setPlaca(scanner.next());
        
        System.out.println("Digite o Preço do carro Atual: "+carroAlteracao.getPreco());
        carroAlteracao.setPreco(scanner.nextDouble());
        
        carroService.alterar(carroAlteracao);
		System.out.println("Carro alterado");
		System.out.println(carroAlteracao);
	}
	
	public void listar() {
		mostrarLista(carroService.listarTodos());
	}
	
	public void consultarCarro() {
		System.out.println("Digite a placa do carro:");
		String placa = scanner.next();
		Carro carro = carroService.conultarPor(placa);
		System.out.println(carro);
	}
	
	public void mostrarLista(List<Carro> carros) {
		for(Carro carro : carros) {
			System.out.println(carro);
		}
	}
	
	/*public void preco () {
		System.out.println("Qual carro você gostaria de saber o preço?");
		Double preco = scanner.nextDouble();
		Carro carro = carroService.buscarPor(preco);
		System.out.println(carro);
	}*/
}
