package br.com.opta2.vacina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opta2.vacina.domain.Vacinacao;
import br.com.opta2.vacina.repository.VacinacaoRepository;

@Service
public class VacinacaoService {
	@Autowired
	private VacinacaoRepository vacinacaoRepository;
	
	public Vacinacao save(Vacinacao vacinacao) {
		return vacinacaoRepository.save(vacinacao);
		}
	
	public List<Vacinacao> findAll(){
		return (List<Vacinacao>) vacinacaoRepository.findAll();
		}
	public Optional<Vacinacao> findById(Long id) {
		return vacinacaoRepository.findById(id);
		}
	public Vacinacao update(Vacinacao vacinacao) {
		return vacinacaoRepository.save(vacinacao);
		}
	public void deleteById(Long id) {
		vacinacaoRepository.deleteById(id);
		}
	public List<Vacinacao> findByCpf(Integer cpf){
		return (List<Vacinacao>) vacinacaoRepository.findByCpf(cpf);
		}
	public List<Vacinacao> findByNomeDoVacinado(String nomeDoVacinado){
		return (List<Vacinacao>) vacinacaoRepository.findByNomeDoVacinado(nomeDoVacinado);
		}
}
