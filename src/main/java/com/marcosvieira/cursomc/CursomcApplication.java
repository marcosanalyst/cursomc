package com.marcosvieira.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcosvieira.cursomc.domain.Categoria;
import com.marcosvieira.cursomc.domain.Cidade;
import com.marcosvieira.cursomc.domain.Cliente;
import com.marcosvieira.cursomc.domain.Endereco;
import com.marcosvieira.cursomc.domain.Estado;
import com.marcosvieira.cursomc.domain.Pagamento;
import com.marcosvieira.cursomc.domain.PagamentoComBoleto;
import com.marcosvieira.cursomc.domain.PagamentoComCartao;
import com.marcosvieira.cursomc.domain.Pedido;
import com.marcosvieira.cursomc.domain.Produto;
import com.marcosvieira.cursomc.domain.enuns.EstadoPagamento;
import com.marcosvieira.cursomc.domain.enuns.TipoCliente;
import com.marcosvieira.cursomc.repositories.CategoriaRepository;
import com.marcosvieira.cursomc.repositories.CidadeRepository;
import com.marcosvieira.cursomc.repositories.ClienteRepository;
import com.marcosvieira.cursomc.repositories.EnderecoRepository;
import com.marcosvieira.cursomc.repositories.EstadoRepository;
import com.marcosvieira.cursomc.repositories.PagamentoRepository;
import com.marcosvieira.cursomc.repositories.PedidoRepository;
import com.marcosvieira.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired	
	private CategoriaRepository categoriaRespository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired 
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));		
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		categoriaRespository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
			
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlâncdia", est1);
		Cidade c2= new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		Cliente cli1 = new Cliente(null, "Marcos Silva","analyst.marcos@gmail.com" , "00011122299", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("1195459-1891", "112875-5787"));
		
		Endereco e1 = new Endereco(null, "Avenida Santos de Barros", "999", "casa fundos", "Felicidade", "05588-000", cli1, c1 );
		Endereco e2 = new Endereco(null, "Rua Brasil","100","casa B","Centro", "01155-111", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2023 09:20"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2023 13:58"), cli1, e2);
		
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2023 00:30"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		
		
	}

}


