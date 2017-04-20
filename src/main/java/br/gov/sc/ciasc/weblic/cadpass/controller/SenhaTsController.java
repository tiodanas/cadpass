package br.gov.sc.ciasc.weblic.cadpass.controller;

import br.gov.sc.ciasc.weblic.cadpass.domain.Orgao;
import br.gov.sc.ciasc.weblic.cadpass.domain.Solicitacao;
import br.gov.sc.ciasc.weblic.cadpass.domain.SolicitacaoStatus;
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
public class SenhaTsController {

    @Autowired()
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired()
    private OrgaoRepository orgaoRepository;

    @Autowired
    EmailSender emailSender;

    @RequestMapping("/senhaTs/index")
    String senhasTS(Model model) {

        List<Solicitacao> solicitacoesPendentes = solicitacaoRepository.findAllByStatusOrderByDataCadastroAsc(SolicitacaoStatus.PENDENTE);
        model.addAttribute("solicitacoesPendentes", solicitacoesPendentes);
        System.out.println("--- IndexController.index, solicitacoesPendentes: " + solicitacoesPendentes);

        return "/senhaTs/index";
    }

    @RequestMapping(value = "/senhaTs/create", method = RequestMethod.GET)
    String create(Solicitacao solicitacao, Model model) {

        if(solicitacao == null) {
            solicitacao = new Solicitacao();
        }
        model.addAttribute("solicitacao", solicitacao);
        System.out.println("--- SenhaTsController.create, solicitacao: " + solicitacao);

        List<Orgao> listaDeOrgaos = orgaoRepository.findAllByOrderByNomeAsc();
        model.addAttribute("listaDeOrgaos", listaDeOrgaos);
        System.out.println("--- SenhaTsController.create, listaDeOrgaos: " + listaDeOrgaos);

        return "/senhaTs/create";
    }

    @RequestMapping(value = "/senhaTs/confirm", method = RequestMethod.POST)
    String confirm(@Valid Solicitacao solicitacao, BindingResult bindingResult, Model model) {
        System.out.println("--- SenhaTsController.confirm, solicitacao: " + solicitacao);

        model.addAttribute("solicitacao", solicitacao);

        System.out.println("--- SenhaTsController.save, bindingResult.hasErrors(): " + bindingResult.hasErrors());
        if(bindingResult.hasErrors()) {
            List<Orgao> listaDeOrgaos = orgaoRepository.findAllByOrderByNomeAsc();
            model.addAttribute("listaDeOrgaos", listaDeOrgaos);
            //
            // Implementar o re-select do órgão na view.
            return "/senhaTs/create";
        }

        return "/senhaTs/confirm";
    }

    @RequestMapping(value = "/senhaTs/", method = RequestMethod.POST)
    public String save(@Valid Solicitacao solicitacao, BindingResult bindingResult, Model model) {
        System.out.println("--- SenhaTsController.save, solicitacao: " + solicitacao);

        System.out.println("--- SenhaTsController.save, bindingResult.hasErrors(): " + bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            return "/senhaTs/create";
        }

        solicitacao.setStatus(SolicitacaoStatus.PENDENTE);

        if (!emailSender.sendEmailSolicitacaoCriada(solicitacao)) {
            return "/senhaTs/create";
        }

        Solicitacao solicitacaoCreated = solicitacaoRepository.save(solicitacao);

        model.addAttribute("solicitacao", solicitacaoCreated);
        System.out.println("--- SenhaTsController.save, solicitacao: " + solicitacaoCreated);

        return "/senhaTs/created";
    }

}
