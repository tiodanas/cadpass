package br.gov.sc.ciasc.weblic.cadpass.controller;

import br.gov.sc.ciasc.weblic.cadpass.domain.Solicitacao;
import br.gov.sc.ciasc.weblic.cadpass.domain.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.xml.ws.Binding;

@Controller
public class SolicitacaoController {

    @Autowired()
    private SolicitacaoRepository solicitacaoRepository;

    @RequestMapping(value = "solicitacao/create", method = RequestMethod.GET)
    String create(Model model) {
        Solicitacao solicitacao = new Solicitacao();
        System.out.println("--- SolicitacaoController.create, solicitacao: " + solicitacao);
        model.addAttribute("solicitacao", solicitacao);
        return "/solicitacao/create";
    }

    @RequestMapping(value = "solicitacao", method = RequestMethod.POST)
    public String save(@Valid Solicitacao solicitacao, BindingResult bindingResult, Model model) {
        System.out.println("--- SolicitacaoController.save, solicitacao: " + solicitacao);

        /*
        if(bindingResult.hasErrors()) {
            return "/solicitacao/create";
        }
        */

        Solicitacao solicitacaoCreated = solicitacaoRepository.save(solicitacao);

        model.addAttribute("solicitacao", solicitacaoCreated);
        return "solicitacao/created";
    }
}
