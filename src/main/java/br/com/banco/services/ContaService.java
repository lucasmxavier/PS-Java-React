package br.com.banco.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entitites.Conta;
import br.com.banco.entitites.Transferencia;
import br.com.banco.repositories.ContaRepository;

@Service
public class ContaService {
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	public Conta retornarConta(Long id) {
		return contaRepository.findById(id).orElse(null);
	}
	
	public List<Transferencia> retornarTransferencias(Long id, Optional<String> operador, Optional<Date> inicio, Optional<Date> fim) {
		Conta conta = retornarConta(id);
		return transferenciaService.buscarTransferencias(conta, operador, inicio, fim);
    }
}
