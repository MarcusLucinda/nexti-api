package com.nexti.desafio.repos;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nexti.desafio.models.Cliente;
import com.nexti.desafio.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Modifying
	@Query("UPDATE Pedido p SET p.cliente = :cliente, p.total = :total, p.dataCompra = :data WHERE p.id = :id")
	void update(@Param("id") Long id, @Param("cliente") Cliente cliente, @Param("total") Double total, @Param("data") LocalDate data);
}
