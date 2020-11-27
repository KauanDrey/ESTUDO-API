package com.gft.api.model;

import javax.persistence.Embeddable;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class Endereco {

	@ApiModelProperty(example = "R Alemanha")
	private String logradouro;

	@ApiModelProperty(example = "2000")
	private String numero;

	@ApiModelProperty(example = "Casa 07")
	private String complemento;

	@ApiModelProperty(example = "Mogilar")
	private String bairro;

	@ApiModelProperty(example = "08773-123")
	private String cep;

	@ApiModelProperty(example = "Mogi das Cruzes")
	private String cidade;

	@ApiModelProperty(example = "São Paulo")
	private String estado;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
