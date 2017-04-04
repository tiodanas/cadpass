package br.gov.sc.ciasc.weblic.cadpass.repository;

import br.gov.sc.ciasc.weblic.cadpass.domain.Solicitacao;
import br.gov.sc.ciasc.weblic.cadpass.domain.SolicitacaoStatus;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SolicitacaoRepository extends CrudRepository<Solicitacao, Long> {
    List<Solicitacao> findAllByStatusOrderByDataCadastroAsc(SolicitacaoStatus solicitacaoStatus);
}
