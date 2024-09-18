package com.br.senai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.senai.entity.Carro;
import com.br.senai.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public Carro inserir(Carro carro) {
		return carroRepository.save(carro);
	}
	
	public Carro alterar(Carro carro) {
		return carroRepository.save(carro);
	}
	
	public void removerPor(Integer id) {
		carroRepository.deleteById(id);
	}
	
	public List<Carro> inserir(List<Carro> carros){
		return carroRepository.saveAll(carros);
	}
	
	public List<Carro> listarTodos(){
		return carroRepository.findAll();
	}
	
	public Carro conultarPor(String placa) {
		return carroRepository.findByPlaca(placa);
	}
	
	public Carro buscarPor(Integer id) {
		return carroRepository.findById(id).orElse(null);
	}

}
