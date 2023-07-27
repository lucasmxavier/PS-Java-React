package br.com.banco.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entitites.Transferencia;
import br.com.banco.services.ContaService;

@RestController
@Controller
@RequestMapping("accounts")
public class ContaController {
	@Autowired
	private ContaService contaService;
	
	@RequestMapping(method=RequestMethod.GET, path="{id}/statements" )
	public ResponseEntity<?> extratoConta(@PathVariable Long id, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<Date> inicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<Date> fim,
            @RequestParam Optional<String> operador){
		List<Transferencia> transferencias = contaService.retornarTransferencias(id, operador, inicio, fim);
		return new ResponseEntity<>(transferencias,HttpStatus.OK);   
	}
}
