package br.com.opta2.vacina.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.opta2.vacina.domain.Vacinacao;

@Repository
public interface VacinacaoRepository extends CrudRepository<Vacinacao, Long>{
	List<Vacinacao> findByCpf(Integer cpf);
	List<Vacinacao> findByNomeDoVacinado(String nomeDoVacinado);
}
