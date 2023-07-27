package br.com.banco.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.banco.entitites.Conta;
import br.com.banco.entitites.Transferencia;

@Repository
@Transactional(readOnly = false)
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{
	List<Transferencia> findByContaAndNomeOperadorTransacaoAndDataTransferenciaBetween(Conta conta, String operador, Date inicio, Date fim);
	List<Transferencia> findByContaAndDataTransferenciaBetween(Conta conta, Date inicio, Date fim);
}
