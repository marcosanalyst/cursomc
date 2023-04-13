package com.marcosvieira.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosvieira.cursomc.domain.Categoria;
import com.marcosvieira.cursomc.domain.Pagamento;
import com.marcosvieira.cursomc.domain.Pedido;

@Repository

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	
	

}