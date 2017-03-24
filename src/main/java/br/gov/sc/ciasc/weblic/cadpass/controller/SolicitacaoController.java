package br.gov.sc.ciasc.weblic.cadpass.controller;

import br.gov.sc.ciasc.weblic.cadpass.domain.Solicitacao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SolicitacaoController {

    @RequestMapping("/solicitacao/create")
    String create(Model model) {
        Solicitacao solicitacao = new Solicitacao();
        System.out.println("--- SolicitacaoController.create, solicitacao: " + solicitacao);
        model.addAttribute("solicitacao", solicitacao);
        return "/solicitacao/create";
    }

    @RequestMapping("/solicitacao/confirm")
    String confirm(Solicitacao solicitacao, Model model) {
        model.addAttribute("solicitacao", solicitacao);
        return "/solicitacao/confirm";
    }

}
