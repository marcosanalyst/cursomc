package com.marcosvieira.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosvieira.cursomc.domain.ItemPedido;

@Repository

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
	
	

}