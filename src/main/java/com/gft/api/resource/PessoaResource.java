package com.gft.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

import com.gft.api.event.RecursoCriadoEvent;
import com.gft.api.model.Pessoa;
import com.gft.api.repository.PessoaRepository;
import com.gft.api.service.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Pessoas")
@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@ApiOperation("Busca todas as pessoas")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();

	}

	@ApiOperation("Cria uma nova pessoa")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@PostMapping
	public ResponseEntity<Pessoa> criar(
			@ApiParam(name = "corpo", value = "Representação de uma nova pessoa") @Valid @RequestBody Pessoa pessoa,
			HttpServletResponse response) {

		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);

	}

	@ApiOperation("Busca uma pessoa pelo código")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPeloCodigo(
			@ApiParam(value = "Código de uma pessoa para buscar", example = "1") @PathVariable Long codigo) {
		Pessoa pessoa = pessoaRepository.findById(codigo).orElse(null);
		return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();

	}

	@ApiOperation("Deleta uma pessoa pelo código")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(
			@ApiParam(value = "Código de uma pessoa para deletar", example = "1") @PathVariable Long codigo) {
		this.pessoaRepository.deleteById(codigo);

	}

	@ApiOperation("Atualiza uma pessoa pelo código")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(Long codigo, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.Atulizar(codigo, pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}

	@ApiOperation("Atualiza a propiedade ativo da pessoa")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(
			@ApiParam(value = "Código de uma pessoa para atualizar a propriedade 'Ativo' de pessoa", example = "1") @PathVariable Long codigo,
			@ApiParam(name = "corpo", value = "Representação de atualizar propriedade 'Ativo' de pessoa") @RequestBody Boolean ativo) {
		pessoaService.atualizarPropriedadeAtivo(codigo, ativo);

	}

}
