package br.com.projects.emailservice.configuration;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.projects.emailservice.domain.Pedido;
import br.com.projects.emailservice.repositories.PedidoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {

		Pedido pedido1 = new Pedido(null, "Notebook", "José da Silva", LocalDate.parse("2020-01-07"));
		Pedido pedido2 = new Pedido(null, "TV", "Maria da Conceição", LocalDate.parse("2020-01-07"));
		Pedido pedido3 = new Pedido(null, "Cafeteira", "Sebastião da Silva", LocalDate.parse("2020-01-07"));

		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
	}

}
