package com.br.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.senai.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

	Carro findByPlaca(String placa);

}
