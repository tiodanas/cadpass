package br.gov.sc.ciasc.weblic.cadpass.controller;

import br.gov.sc.ciasc.weblic.cadpass.domain.Orgao;
import br.gov.sc.ciasc.weblic.cadpass.domain.Solicitacao;
import br.gov.sc.ciasc.weblic.cadpass.repository.OrgaoRepository;
import br.gov.sc.ciasc.weblic.cadpass.repository.SolicitacaoRepository;
import br.gov.sc.ciasc.weblic.cadpass.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SolicitacaoController {

    @Autowired()
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired()
    private OrgaoRepository orgaoRepository;

    @Autowired
    EmailSender emailSender;

    @RequestMapping(value = "solicitacao/create", method = RequestMethod.GET)
    String create(Solicitacao solicitacao, Model model) {

        if(solicitacao == null) {
            solicitacao = new Solicitacao();
        }
        model.addAttribute("solicitacao", solicitacao);
        System.out.println("--- SolicitacaoController.create, solicitacao: " + solicitacao);

        List<Orgao> listaDeOrgaos = orgaoRepository.findAllByOrderByNomeAsc();
        model.addAttribute("listaDeOrgaos", listaDeOrgaos);
        System.out.println("--- SolicitacaoController.create, listaDeOrgaos: " + listaDeOrgaos);

        return "/solicitacao/create";
    }

    @RequestMapping(value = "solicitacao/confirm", method = RequestMethod.POST)
    String confirm(@Valid Solicitacao solicitacao, BindingResult bindingResult, Model model) {
        System.out.println("--- SolicitacaoController.confirm, solicitacao: " + solicitacao);

        model.addAttribute("solicitacao", solicitacao);

        System.out.println("--- SolicitacaoController.save, bindingResult.hasErrors(): " + bindingResult.hasErrors());
        if(bindingResult.hasErrors()) {
            List<Orgao> listaDeOrgaos = orgaoRepository.findAllByOrderByNomeAsc();
            model.addAttribute("listaDeOrgaos", listaDeOrgaos);
            //
            // Implementar o re-select do órgão na view.
            return "/solicitacao/create";
        }

        return "/solicitacao/confirm";
    }

    @RequestMapping(value = "solicitacao", method = RequestMethod.POST)
    public String save(@Valid Solicitacao solicitacao, BindingResult bindingResult, Model model) {
        System.out.println("--- SolicitacaoController.save, solicitacao: " + solicitacao);

        System.out.println("--- SolicitacaoController.save, bindingResult.hasErrors(): " + bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            return "/solicitacao/create";
        }

        if (!emailSender.sendEmailSolicitacaoCriada(solicitacao)) {
            return "/solicitacao/create";
        }

        Solicitacao solicitacaoCreated = solicitacaoRepository.save(solicitacao);

        model.addAttribute("solicitacao", solicitacaoCreated);
        System.out.println("--- SolicitacaoController.save, solicitacao: " + solicitacaoCreated);

        return "solicitacao/created";
    }
}
