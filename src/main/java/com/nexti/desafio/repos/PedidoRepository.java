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
	
	@Modifying
	@Query(value = "INSERT INTO pedido_produtos (pedido_id, produtos_id) VALUES (:pedidoId, :produtoId)", nativeQuery = true)
	void addProducts(@Param("pedidoId") Long pedidoId, @Param("produtoId") Long produtoId);
	
	@Modifying
	@Query(value = "DELETE FROM pedido_produtos WHERE pedido_id = :pedidoId AND produtos_id = :produtoId", nativeQuery = true)
	void delProducts(@Param("pedidoId") Long pedidoId, @Param("produtoId") Long produtoId);
	
	@Modifying
	@Query(value = "DELETE FROM pedido_produtos WHERE pedido_id = :pedidoId", nativeQuery = true)
	void deleteAllPedidos(@Param("pedidoId") Long pedidoId);
	
}
