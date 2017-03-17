package br.gov.sc.ciasc.weblic.cadpass.service;

import br.gov.sc.ciasc.weblic.cadpass.domain.Orgao;
import br.gov.sc.ciasc.weblic.cadpass.domain.OrgaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulate implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabasePopulate.class);

    @Autowired()
    private OrgaoRepository orgaoRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("DatabasePopulate, inicio");

        CriarOrgaos();

        logger.info("DatabasePopulate, fim");
    }

    private void CriarOrgaos() {
        CriarOrgao(1, "ORGAO DE TESTE", "TESTE");
        CriarOrgao(9, "Empresa de Pesquisa Agropecuária e Extensão Rural de Santa Catarina", "Epagri");
        CriarOrgao(201, "Procuradoria Geral do Estado", "PGE");
        CriarOrgao(301, "Centro de Informática e Automação do Estado de Santa Catarina", "CIASC");
        CriarOrgao(801, "Secretaria de Estado da Justiça e Cidadania", "SJC");
        CriarOrgao(1601, "Secretaria de Estado da Segurança Pública", "SSP");
        CriarOrgao(1605, "Policia Civil", "PC");
        CriarOrgao(1606, "Polícia Militar do Estado de Santa Catarina", "PMSC");
        CriarOrgao(1685, "Fundo de Melhoria do Corpo de Bombeiros Militar", "FUMCBM");
        CriarOrgao(1700, "Secretaria de Estado da Administração", "SEA");
        CriarOrgao(1801, "Secretaria de Estado do Planejamento", "SPG");
        CriarOrgao(1823, "SC Parcerias S.A", "SC-PARCERIAS");
        CriarOrgao(2006, "Fundação Catarinense de Esporte", "FESPORTE");
        CriarOrgao(2300, "Secretaria de Estado do Turismo, Cultura e Esporte", "SOL");
        CriarOrgao(2322, "Fundação Catarinense de Cultura", "FCC");
        CriarOrgao(2323, "Santa Catarina Turismo S.A", "SANTUR");
        CriarOrgao(2601, "Secretaria de Estado da Assistência Social, Trabalho e Habitação", "SST");
        CriarOrgao(2622, "Companhia de Habitação do Estado de Santa Catarina S/A", "COHAB/SC");
        CriarOrgao(2700, "Secretaria de Estado do Desenvolvimento Econômico Sustentável", "SDS");
        CriarOrgao(2721, "Fundação do Meio Ambiente", "FATMA");
        CriarOrgao(2727, "Agência Reguladora de Serviços Públicos de Santa Catarina", "AGESC");
        CriarOrgao(2728, "Agência Reguladora de Serviços de Saneamento Básico do Estado de SC", "AGESAN");
        CriarOrgao(4101, "Secretaria de Estado da Casa Civil", "SCC");
        CriarOrgao(4103, "Secretaria Executiva de Articulação Nacional", "SAN");
        CriarOrgao(4104, "Secretaria Executiva de Assuntos Internacionais", "SAI");
        CriarOrgao(4401, "Secretaria de Estado da Agricultura e da Pesca", "SAP");
        CriarOrgao(4422, "Companhia Integrada de Desenv. Agricola de Santa Catarina", "CIDASC");
        CriarOrgao(4501, "Secretaria de Estado da Educação", "SED");
        CriarOrgao(4521, "Fundação Catarinense de Educação Especial", "FCEE");
        CriarOrgao(4524, "Fundação de Amparo a Pesquisa e Inovação do Estado de Santa Catarina", "FAPESC");
        CriarOrgao(4722, "Instituto de Previdência do Estado de Santa Catarina", "IPREV");
        CriarOrgao(4891, "Secretaria de Estado da Saúde", "SES");
        CriarOrgao(5201, "Secretaria de Estado da Fazenda", "SEF");
        CriarOrgao(5222, "Junta Comercial do Estado de Santa Catarina", "JUCESC");
        CriarOrgao(5230, "Fundação Escola de Governo", "ENA");
        CriarOrgao(5301, "Secretaria de Estado da Infra-Estrutura", "SIE");
        CriarOrgao(5323, "Departamento de Transportes e Terminais", "DETER");
        CriarOrgao(5325, "Departamento Estadual de Infra-Estrutura", "DEINFRA");
        CriarOrgao(5501, "Secretaria de Estado da Defesa Civil", "SDC");
        CriarOrgao(5801, "Secretaria de Estado da Comunicação", "SEC");
        CriarOrgao(6001, "Agência de Desenvolvimento Regional - Itapiranga", "ADR-IPX");
        CriarOrgao(6101, "Agência de Desenvolvimento Regional - Quilombo", "ADR-QBO");
        CriarOrgao(6201, "Agência de Desenvolvimento Regional - Seara", "ADR-SAR");
        CriarOrgao(6301, "Agência de Desenvolvimento Regional - Taió", "ADR-TAO");
        CriarOrgao(6601, "Agência de Desenvolvimento Regional - Timbó", "ADR-TIO");
        CriarOrgao(6701, "Agência de Desenvolvimento Regional - Braço do Norte", "ADR-BON");
        CriarOrgao(7001, "Agência de Desenvolvimento Regional - São Miguel do Oeste", "ADR-SGE");
        CriarOrgao(7101, "Agência de Desenvolvimento Regional - Maravilha", "ADR-MVH");
        CriarOrgao(7201, "Agência de Desenvolvimento Regional - São Lourenço do Oeste", "ADR-SNX");
        CriarOrgao(7301, "Agência de Desenvolvimento Regional - Chapecó", "ADR-CCO");
        CriarOrgao(7401, "Agência de Desenvolvimento Regional - Xanxerê", "ADR-XXE");
        CriarOrgao(7501, "Agência de Desenvolvimento Regional - Concórdia", "ADR-CDA");
        CriarOrgao(7601, "Agência de Desenvolvimento Regional - Joaçaba", "ADR-JCA");
        CriarOrgao(7701, "Agência de Desenvolvimento Regional - Campos Novos", "ADR-CNV");
        CriarOrgao(7801, "Agência de Desenvolvimento Regional - Videira", "ADR-VII");
        CriarOrgao(7901, "Agência de Desenvolvimento Regional - Caçador", "ADR-CDR");
        CriarOrgao(8001, "Agência de Desenvolvimento Regionall - Curitibanos", "ADR-CBS");
        CriarOrgao(8101, "Agência de Desenvolvimento Regional - Rio do Sul", "ADR-RSL");
        CriarOrgao(8201, "Agência de Desenvolvimento Regional - Ituporanga", "ADR-IUP");
        CriarOrgao(8301, "Agência de Desenvolvimento Regional - Ibirama", "ADR-IIR");
        CriarOrgao(8401, "Agência de Desenvolvimento Regional - Blumenau", "ADR-BNU");
        CriarOrgao(8501, "Agência de Desenvolvimento Regional - Brusque", "ADR-BQE");
        CriarOrgao(8601, "Agência de Desenvolvimento Regional - Itajaí", "ADR-IAI");
        CriarOrgao(8701, "Secretaria de Estado de Desenv. Regional - Grande Fpolis", "ADR-SOO");
        CriarOrgao(8801, "Agência de Desenvolvimento Regional - Laguna", "ADR-LGA");
        CriarOrgao(8901, "Agência de Desenvolvimento Regional - Tubarão", "ADR-TRO");
        CriarOrgao(9001, "Agência de Desenvolvimento Regional - Criciúma", "ADR-CUA");
        CriarOrgao(9101, "Agência de Desenvolvimento Regional - Araranguá", "ADR-ARU");
        CriarOrgao(9201, "Agência de Desenvolvimento Regional - Joinville", "ADR-JVE");
        CriarOrgao(9221, "Administração do Porto de São Francisco do Sul", "APSFS");
        CriarOrgao(9301, "Agência de Desenvolvimento Regional - Jaraguá do Sul", "ADR-JGS");
        CriarOrgao(9401, "Agência de Desenvolvimento Regional - Mafra", "ADR-MFA");
        CriarOrgao(9501, "Agência de Desenvolvimento Regional - Canoinhas", "ADR-CNI");
        CriarOrgao(9601, "Agência de Desenvolvimento Regional - Lages", "ADR-LGS");
        CriarOrgao(9701, "Agência de Desenvolvimento Regional - São Joaquim", "ADR-SJQ");
        CriarOrgao(9801, "Agência de Desenvolvimento Regional - Palmitos", "ADR-PLI");
        CriarOrgao(9901, "Agência de Desenvolvimento Regional - Dionisio Cerqueira", "ADR-DCQ");
    }

    private void CriarOrgao(Integer codigo, String nome, String sigla) {
        Orgao orgao = new Orgao();
        orgao.setCodigo(codigo);
        orgao.setNome(nome);
        orgao.setSigla(sigla);
        orgaoRepository.save(orgao);
        logger.info("Criou Orgao: id " + orgao.getId() + ", " + orgao.getCodigo() + " - " + orgao);
    }
}
