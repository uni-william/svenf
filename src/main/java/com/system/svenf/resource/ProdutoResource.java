package com.system.svenf.resource;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.system.svenf.model.Produto;
import com.system.svenf.repository.ProdutoRepository;
import com.system.svenf.repository.filter.ProdutoFilter;
import com.system.svenf.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;

	
	@GetMapping
	public Page<Produto> pesquisar(ProdutoFilter produtoFilter, Pageable pageable) {
		return produtoRepository.filtrar(produtoFilter, pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Produto> novoProduto(@Valid @RequestBody Produto produto, HttpServletResponse response) {
		Produto produtoSalva = produtoService.salvar(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(produtoSalva.getId())
				.toUri();

		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(produtoSalva);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		Produto produtoSalva = produtoService.atualizar(id, produto);
		return ResponseEntity.ok(produtoSalva);
	}	

}
