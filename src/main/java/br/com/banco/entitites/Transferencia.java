package br.com.banco.entitites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transferencia")
@AllArgsConstructor
@NoArgsConstructor
public class Transferencia {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Date dataTransferencia;

    @Column(nullable = false, precision = 20, scale = 2)
    Double valor;

    @Column(nullable = false)
    String tipo;

    String nomeOperadorTransacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "conta_id")
    Conta conta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(Date dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}

	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
