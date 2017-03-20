package br.gov.sc.ciasc.weblic.cadpass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SolicitacaoController {

    @RequestMapping("/solicitacao/create")
    String create() {
        return "/solicitacao/create";
    }
}
