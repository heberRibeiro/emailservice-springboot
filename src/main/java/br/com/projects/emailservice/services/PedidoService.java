package br.com.projects.emailservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.projects.emailservice.domain.Pedido;
import br.com.projects.emailservice.repositories.PedidoRepository;
import br.com.projects.emailservice.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	public Pedido findById(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Pedido insert(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public void delete(Long id) {
		try {
			pedidoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Pedido update(Long id, Pedido pedido) {
		/*
		 * Returns a reference to the entity with the given identifier. Is very likely
		 * to return an instance and throw an EntityNotFoundException.
		 */
		Pedido obj = pedidoRepository.getOne(id);

		/*
		 * Modify the pedido entity (obj) in database from pedido object.
		 */
		obj.setProduto(pedido.getProduto());
		obj.setCliente(pedido.getCliente());
		obj.setData(pedido.getData());

		/*
		 * Save the modified entity in database
		 */
		return pedidoRepository.save(obj);

	}
}
