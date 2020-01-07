package br.com.projects.emailservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projects.emailservice.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
