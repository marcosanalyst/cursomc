package com.marcosvieira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosvieira.cursomc.domain.Pedido;
import com.marcosvieira.cursomc.repositories.PedidoRepository;
import com.marcosvieira.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id" +
		Pedido.class.getName()));
				
						
		
	}

}
