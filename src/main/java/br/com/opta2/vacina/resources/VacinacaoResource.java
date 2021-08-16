package br.com.opta2.vacina.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opta2.vacina.domain.Vacinacao;
import br.com.opta2.vacina.service.VacinacaoService;

@RestController
@RequestMapping("/api/v1/vacinas")
public class VacinacaoResource {
	@Autowired
	private VacinacaoService vacinacaoService;
	
	@PostMapping
	public Vacinacao save(@RequestBody Vacinacao vacinacao){
		return vacinacaoService.save(vacinacao);
	}
	
	@GetMapping
	public ResponseEntity<List<Vacinacao>> findAll(){
		List<Vacinacao> vacinacoes = vacinacaoService.findAll();
		if(vacinacoes == null || vacinacoes.isEmpty()) {
			return new ResponseEntity<List<Vacinacao>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Vacinacao>>(vacinacoes, HttpStatus.OK);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
		return vacinacaoService.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Vacinacao> update(@PathVariable("id") Long id,
	@RequestBody Vacinacao vacinacao) {
		return vacinacaoService.findById(id)
		.map(record -> {
			record.setNomeDoVacinado(vacinacao.getNomeDoVacinado());
			record.setCpf(vacinacao.getCpf());
			record.setUf(vacinacao.getUf());
			record.setCidade(vacinacao.getCidade());
			record.setDataDeAplicacao(vacinacao.getDataDeAplicacao());
			record.setVacina(vacinacao.getVacina());
			record.setNomeDoResponsavelDeAplicacao(vacinacao.getNomeDoResponsavelDeAplicacao());
			record.setDataProvavelSegundaDose(vacinacao.getDataProvavelSegundaDose());	
				Vacinacao updated = vacinacaoService.save(record);
				return ResponseEntity.ok().body(updated);			
	}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id) {
	return vacinacaoService.findById(id)
			.map(record -> {
				vacinacaoService.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = {"cpf/{cpf}"})
	public ResponseEntity<?>
	findByCpf(@PathVariable("cpf") Integer cpf){
	List<Vacinacao> vacinacoes = vacinacaoService.findByCpf(cpf);
	return vacinacoes.isEmpty()? ResponseEntity.noContent().build() :
	ResponseEntity.ok(vacinacoes);
	}

	@GetMapping(path = {"nomeDoVacinado/{nomeDoVacinado}"})
	public ResponseEntity<?>
	findByNomeDoVacinado(@PathVariable("nomeDoVacinado") String nomeDoVacinado){
	List<Vacinacao> vacinacoes = vacinacaoService.findByNomeDoVacinado(nomeDoVacinado);
	return vacinacoes.isEmpty()? ResponseEntity.noContent().build() :
	ResponseEntity.ok(vacinacoes);
	}
	
}

