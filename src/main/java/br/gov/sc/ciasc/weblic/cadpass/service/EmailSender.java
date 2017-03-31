package br.gov.sc.ciasc.weblic.cadpass.service;

import br.gov.sc.ciasc.weblic.cadpass.domain.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    @Autowired
    MailSender mailSender;

    public Boolean sendEmailSolicitacaoCriada(Solicitacao solicitacao) {

//        System.out.println("--- EmailSender.create, sendEmailSolicitacaoCriada: " + Boolean.TRUE);
//        return Boolean.TRUE;

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("suportelic@ciasc.sc.gov.br");
        simpleMailMessage.setTo("danielsilva@ciasc.sc.gov.br");
        simpleMailMessage.setSubject("Resetar senha de usuário do Terminal Server do LIC");

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Boa tarde.\n\nA pedido do cliente ");
        messageBuilder.append(solicitacao.getOrgao());
        messageBuilder.append(",\nfavor resetar a senha da seguinte conta do Terminal Server do sistema LIC (servidor 172.19.215.123):\n\n- ");
        messageBuilder.append(solicitacao.getUserName().toUpperCase());
        messageBuilder.append("\n\nObrigado.");

        simpleMailMessage.setText(messageBuilder.toString());

        try {
            mailSender.send(simpleMailMessage);
            return true;

        } catch (MailException me) {
            me.printStackTrace();
            return false;
        }

    }
}
