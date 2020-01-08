package br.com.projects.emailservice.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.projects.emailservice.domain.Pedido;
import br.com.projects.emailservice.services.PedidoService;

@RestController
@RequestMapping("/emailservice/api")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> pedido = pedidoService.findAll();
		return ResponseEntity.ok().body(pedido);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok().body(pedido);
	}

	@PostMapping
	public ResponseEntity<Pedido> insert(@RequestBody Pedido pedido) {
		Pedido obj = pedidoService.insert(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		pedidoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido) {
		Pedido obj = pedidoService.update(id, pedido);
		return ResponseEntity.ok().body(obj);
	}

}
