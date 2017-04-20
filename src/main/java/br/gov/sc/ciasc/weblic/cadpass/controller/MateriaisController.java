package br.gov.sc.ciasc.weblic.cadpass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MateriaisController {

    @RequestMapping("/materiais")
    String senhasTS(Model model) {
        return "/materiais/index";
    }

}
