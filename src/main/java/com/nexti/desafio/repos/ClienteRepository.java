package com.nexti.desafio.repos;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nexti.desafio.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Modifying
	@Query("UPDATE Cliente c SET c.nome = :nome, c.cpf = :cpf, c.dataNascimento = :data WHERE c.id = :id")
	void update(@Param("id") Long id, @Param("nome") String nome, @Param("cpf") String cpf, @Param("data") LocalDate data);
}
