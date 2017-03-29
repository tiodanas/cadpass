package br.gov.sc.ciasc.weblic.cadpass.repository;

import br.gov.sc.ciasc.weblic.cadpass.domain.Orgao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrgaoRepository extends CrudRepository<Orgao, Long> {
    Orgao findByCodigo(Integer codigo);
    List<Orgao> findAllByOrderByNomeAsc();
}
