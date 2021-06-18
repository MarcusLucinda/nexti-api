package com.nexti.desafio.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nexti.desafio.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Modifying
	@Query("UPDATE Produto p SET p.nome = :nome, p.descricao = :descricao, p.preco = :preco, p.qtd = :qtd WHERE p.id = :id")
	void update(@Param("id") Long id, @Param("nome") String nome, @Param("descricao") String descricao, 
			@Param("preco") Double preco, @Param("qtd") Integer qtd);
}
