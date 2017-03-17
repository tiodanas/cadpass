package br.gov.sc.ciasc.weblic.cadpass.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Orgao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(1)
    @Column(name = "cd_orgao", unique = true)
    private Integer codigo;

    @NotNull
    @Column(name = "de_nome", unique = true)
    @Size(min = 5, max = 100)
    private String nome;

    @NotNull
    @Column(name = "de_sigla", unique = true)
    @Size(min = 2, max = 15)
    private String sigla;

    @Override
    public String toString() {
        return String.format("%s - %s", this.sigla.trim(), this.nome.trim());
    }
}
