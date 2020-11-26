package com.gft.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.api.event.RecursoCriadoEvent;
import com.gft.api.model.Categoria;
import com.gft.api.repository.CategoriaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Categorias")
@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;

	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@ApiOperation("Busca todas as categorias")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true,
	allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();

	}

	@ApiOperation("Cria uma nova categoria")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true,
	allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@PostMapping
	public ResponseEntity<Categoria> criar(@ApiParam(name="corpo", value = "Representação de criar uma categoria")@Valid @RequestBody Categoria categoria, HttpServletResponse response) {

		Categoria categoriaSalva = categoriaRepository.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);

	}
	
	@ApiOperation("Busca uma categoria pelo código")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true,
	allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPeloCodigo(@ApiParam(value = "Código de uma categoria para buscar", example = "1")@PathVariable Long codigo) {
		Categoria categoria = categoriaRepository.findById(codigo).orElse(null);
		return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();

	}

}
