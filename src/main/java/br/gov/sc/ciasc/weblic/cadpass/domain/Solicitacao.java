package br.gov.sc.ciasc.weblic.cadpass.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_orgao")
    private Orgao orgao;

    @NotNull
    @Column(name = "de_userName")
    @Size(min = 6, max = 20)
    private String userName;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_solicitacao")
    private Date dataCadastro = new Date();

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "tp_status")
    private SolicitacaoStatus status = SolicitacaoStatus.PENDENTE;

    @PrePersist
    void preInsert() {
        dataCadastro = new Date();
    }
}
