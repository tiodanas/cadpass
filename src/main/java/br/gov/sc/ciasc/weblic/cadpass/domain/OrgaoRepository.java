package br.gov.sc.ciasc.weblic.cadpass.domain;

import org.springframework.data.repository.CrudRepository;

public interface OrgaoRepository extends CrudRepository<Orgao, Long> {
    Orgao findByCodigo(Integer codigo);
}
