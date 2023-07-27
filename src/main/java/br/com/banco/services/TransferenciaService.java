package br.com.banco.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entitites.Conta;
import br.com.banco.entitites.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;

@Service
public class TransferenciaService {
	@Autowired
	private TransferenciaRepository transacaoRepository;
	
	public List<Transferencia> buscarTransferencias(Conta conta, Optional<String> operador, Optional<Date> inicio, Optional<Date> fim) {
		Date dataInicio = new Date(0);
		Date dataFim = new Date();
		if (!inicio.isEmpty()) dataInicio = inicio.get();
		if (!fim.isEmpty()) dataFim = fim.get();
		if (!operador.isEmpty()) return transacaoRepository.findByContaAndNomeOperadorTransacaoAndDataTransferenciaBetween(conta, operador.get(), dataInicio, dataFim);
		return transacaoRepository.findByContaAndDataTransferenciaBetween(conta, dataInicio, dataFim);
	}
}
