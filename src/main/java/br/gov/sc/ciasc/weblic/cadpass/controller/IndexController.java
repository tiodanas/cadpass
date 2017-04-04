package br.gov.sc.ciasc.weblic.cadpass.controller;

import br.gov.sc.ciasc.weblic.cadpass.domain.Solicitacao;
import br.gov.sc.ciasc.weblic.cadpass.domain.SolicitacaoStatus;
import br.gov.sc.ciasc.weblic.cadpass.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class IndexController {

    @Autowired()
    private SolicitacaoRepository solicitacaoRepository;

    @RequestMapping("/")
    String index(Model model) {

        List<Solicitacao> solicitacoesPendentes = solicitacaoRepository.findAllByStatusOrderByDataCadastroAsc(SolicitacaoStatus.PENDENTE);
        model.addAttribute("solicitacoesPendentes", solicitacoesPendentes);
        System.out.println("--- IndexController.index, solicitacoesPendentes: " + solicitacoesPendentes);

        return "index";
    }
}
